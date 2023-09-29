package core.two.lesson5.task1;


/**
 *
 * Задание 1
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 10, 20 и 50.
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги: он принимает сумму денег,
 * а возвращает булево значение - успешность выполнения операции.
 * При снятии денег метод должен распечатывать каким количеством купюр
 * какого номинала выдаётся сумма. Сначала банкомат будет пытаться рассчитаться 50,
 * далее добавит недостающие 20, и только затем 10
 * (не нужно рассматривать более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).
 */
public class Runner {

    public static void main(String[] args) {
        new Runner().run();
    }

    public void run() {
        ATM sberATM = new ATM(2, 5, 10);

        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 160);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 90);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 60);
        printAvailableBalance(sberATM);
        addMoney(sberATM, 1, 2, 1);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 80);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 69);
        printAvailableBalance(sberATM);
    }

    private void withdrawMoney(ATM atm, int money) {
        boolean success = atm.getMoney(money);
        System.out.printf("Операция по снятию %d денежных единиц %s\n",
                          money, success ? "завершилась успешно." : "отклонена.");
    }

    private void addMoney(ATM atm, int count50, int count20, int count10) {

        boolean success = atm.addCurrency(count50, count20, count10);
        System.out.printf(
            "Внесение купюр %s%s\n",
            success ? "завершилось успешно." : "завершилось с ошибкой.",
            getCurrencyCount(count50, count20, count10)
        );
    }

    private String getCurrencyCount(int count50, int count20, int count10) {
        if (!ATM.checkInputValue(count50, count20, count10)) {
            return "\nУказано неверное количество купюр.";
        }

        final String patternCount = "\nНоминал: %d Количество: %d";
        final String patternSum = "\nСумма: %d";
        StringBuilder builder = new StringBuilder();
        if (count50 > 0) {
            builder.append(String.format(patternCount, ATM.NOMINAL_50, count50));
        }
        if (count20 > 0) {
            builder.append(String.format(patternCount, ATM.NOMINAL_20, count20));
        }
        if (count10 > 0) {
            builder.append(String.format(patternCount, ATM.NOMINAL_10, count10));
        }
        builder.append(String.format(patternSum, ATM.getSumCurrency(count50, count20, count10)));
        return builder.toString();
    }

    private void printAvailableBalance(ATM atm) {
        System.out.printf("Доступный остаток для снятия: %d\n", atm.getTotalMoney());
    }
}
