package lesson4;


/**
 * Задание 3
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию
 * на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 */
public class Task3 {

    private static final double SALARY = 600.0;
    private static final double SALARY_UP = 400.0;
    private static final int EVERY_MONTHS = 6;
    private static final double COSTS = 300.0;
    private static final double COLLECT_PCT = 10.0;
    private static final double BROKER_PCT = 2.0;


    public static void main(String[] args) {
        calculate(3 * 12 + 2);
    }

    private static void calculate(int totalMonths) {
        double actualSalary = SALARY;
        double collect = getMoneyOfPercent(actualSalary, COLLECT_PCT);
        double accountUp = getBalance(SALARY, COSTS, collect);
        double account = accountUp;
        double deposit = collect;
        report(1, actualSalary, accountUp, account, collect, deposit);
        for (int monthCount = 2; monthCount <= totalMonths; monthCount++) {
            actualSalary = actualSalaryFromMonth(SALARY, SALARY_UP, EVERY_MONTHS, monthCount);
            collect = getMoneyOfPercent(actualSalary, COLLECT_PCT);
            accountUp = getBalance(actualSalary, COSTS, collect);
            account += accountUp;
            deposit += getProfit(deposit, BROKER_PCT) + collect;
            report(monthCount, actualSalary, accountUp, account, collect, deposit);
        }
    }

    private static void report(int monthCount, double salary,
                               double accountUp, double account,
                               double depositUp, double deposit) {
        String text = String.join(" || ",
                "По итогу месяца: %d", "зарплата: %.2f",
                "пополнение счёта: %.2f", "счёт: %.2f",
                "пополнение депозита: %.2f", "депозит: %.2f\n");
        System.out.printf(text, monthCount, salary, accountUp, account, depositUp, deposit);
    }

    private static double getProfit(double deposit, double percent) {
        return roundMoney(deposit / 100 * percent);
    }

    private static double roundMoney(double value) {
        return Math.floor(value * 100) / 100;
    }

    private static double actualSalaryFromMonth(double salary, double increaseSalary,
                                                int increaseMonth, int currentMonth) {
        int increaseCount = increaseMonth > 0 ? currentMonth / increaseMonth : 0;
        return salary + roundMoney(increaseCount * increaseSalary);
    }

    private static double getBalance(double salary, double spending, double collect) {
        return salary - spending - collect;
    }

    private static double getMoneyOfPercent(double value, double percent) {
        return roundMoney(value / 100 * percent);
    }
}
