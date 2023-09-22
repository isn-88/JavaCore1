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
public class Task1 {

    public static void main(String[] args) {
        ATM sberATM = new ATM(2, 5, 10);

        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 160);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 80);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 80);
        printAvailableBalance(sberATM);
        addMoney(sberATM, ATM.NOMINAL_50, 1);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 80);
        printAvailableBalance(sberATM);
        withdrawMoney(sberATM, 30);
        printAvailableBalance(sberATM);
    }

    private static void withdrawMoney(ATM atm, int money) {
        boolean success = atm.getMoney(money);
        System.out.printf("Операция по снятию %d денежных единиц %s\n",
                          money, success ? "завершилась успешно." : "отклонена.");
    }

    private static void addMoney(ATM atm, int nominal, int count) {
        boolean success = atm.addCurrency(nominal, count);
        System.out.printf(
            "Внесение купюр номиналом %d денежных единиц в количестве %d купюр %s\n",
            nominal, count, success ? "завершилась успешно." : "отклонена."
        );
    }

    private static void printAvailableBalance(ATM atm) {
        System.out.printf("Доступный остаток для снятия %d\n",
                          atm.getTotalMoney());
    }
}
