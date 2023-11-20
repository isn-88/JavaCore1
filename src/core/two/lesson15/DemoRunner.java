package core.two.lesson15;

import core.two.lesson15.exception.RunnerException;
import core.two.lesson15.thread.EventConsumer;
import core.two.lesson15.thread.EventInitTask;
import core.two.lesson15.thread.EventProducer;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Алгоритм работы:
 * 1) Из файла с обращениями клиентов считываются все id обращений
 * 2) Из файла с журналом обзвона клиентов считываются все id обработанных заявок
 * 3) Формируется множество ids необработанных заявок
 * 4) По этим ids формируется список заявок,
 *    которые отправляются в очередь для обработки диспетчерами
 * 5) Запускается процесс создания новых заявок
 * 6) С определённой периодичностью запускается процесс считывания новых заявок
 *    и последующая отправка этих заявок для обработки диспетчерами.
 * ---
 * Обработчики:
 * EventInitTask - собирает все необработанные заявки на момент запуска приложения
 *                 и отправляет их диспетчерам до запуска процесса, получения новых заявок
 * EventProducer - поток для создания и сохранения новых заявок
 * EventConsumer - поток для чтения новых заявок и отправки их в пул диспетчеров
 * EventTask - задача по обработке заявки диспетчером и сохранению в журнал,
 *             при успешном её выполнении
 *
 */
public class DemoRunner {

  private static final String PATH = "src/resources/lesson15";


  public void start(String sourceFilename, String resultFileName,
                    Duration producerDelay, Duration consumerDelay,
                    Duration callDelayMin, Duration callDelayMax,
                    int dispatcherCount) {

    Path pathSource = Path.of(PATH, sourceFilename);
    Path pathResult = Path.of(PATH, resultFileName);

    try {
      ExecutorService producerPool = Executors.newSingleThreadExecutor();
      ExecutorService consumerPool = Executors.newSingleThreadExecutor();
      ExecutorService taskPool = Executors.newFixedThreadPool(dispatcherCount);

      EventInitTask eventInitTask =
          new EventInitTask(pathSource, pathResult, taskPool,
                            callDelayMin.toMillis(), callDelayMax.toMillis());
      Future<Integer> future = producerPool.submit(eventInitTask);
      Integer lastIds = future.get();
      System.out.println("Init: Last ids = " + lastIds);

      EventProducer eventProducer = new EventProducer(pathSource, producerDelay.toMillis());
      producerPool.submit(eventProducer);

      while (true) {
        System.out.println(Thread.currentThread().getName() + " Consumer: start");
        EventConsumer eventConsumer =
            new EventConsumer(pathSource, pathResult, lastIds, taskPool,
                              callDelayMin.toMillis(), callDelayMax.toMillis());
        Future<Integer> consumerFuture = consumerPool.submit(eventConsumer);
        lastIds = consumerFuture.get();
        System.out.println(Thread.currentThread().getName() + " Consumer: pause - please wait " +
                           consumerDelay.getSeconds() + " seconds");
        Thread.sleep(consumerDelay.toMillis());
      }

    } catch (ExecutionException | InterruptedException e) {
      System.err.println(e.getMessage());
      throw new RunnerException("Error for execution");
    }
  }
}
