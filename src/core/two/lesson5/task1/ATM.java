package core.two.lesson5.task1;


public class ATM {

    public static final int NOMINAL_50 = 50;
    public static final int NOMINAL_20 = 20;
    public static final int NOMINAL_10 = 10;

    private int currency50;

    private int currency20;

    private int currency10;

    public ATM(int currency50, int currency20, int currency10) {
        this.currency50 = currency50;
        this.currency20 = currency20;
        this.currency10 = currency10;
    }

    public static boolean checkInputValue(int count50, int count20, int count10) {
        if (count50 < 0 || count20 < 0 || count10 < 0) {
            return false;
        }
      return count50 != 0 || count20 != 0 || count10 != 0;
    }

    public static int getSumCurrency(int count50, int count20, int count10) {
        if (!checkInputValue(count50, count20, count10)) {
            return 0;
        }
        return count50 * NOMINAL_50 + count20 * NOMINAL_20 + count10 * NOMINAL_10;
    }

    public boolean addCurrency(int count50, int count20, int count10) {
        if (!checkInputValue(count50, count20, count10)) {
            return false;
        }
        currency50 += count50;
        currency20 += count20;
        currency10 += count10;
        return true;
    }

    public int getTotalMoney() {
        return getSumCurrency(currency50, currency20, currency10);
    }

    public boolean getMoney(int value) {
        if (value < 10) {
            return false;
        }

        if (!isEnough(value)) {
            return false;
        }

        int reminder = value;
        int count50 = getCurrencyCount(NOMINAL_50, reminder);
        reminder = calcReminder(NOMINAL_50, count50, reminder);

        int count20 = getCurrencyCount(NOMINAL_20, reminder);
        reminder = calcReminder(NOMINAL_20, count20, reminder);

        int count10 = getCurrencyCount(NOMINAL_10, reminder);
        reminder = calcReminder(NOMINAL_10, count10, reminder);

        if (reminder == 0) {
            if (count50 <= currency50 && count20 <= currency20 && count10 <= currency10 &&
                getSumCurrency(count50, count20, count10) == value) {
                return withdrawMoney(count50, count20, count10);
            }
        }
        return false;
    }

    private int getCurrencyCount(int nominal, int reminder) {
        return switch (nominal) {
            case NOMINAL_50 -> Math.min(reminder / NOMINAL_50, currency50);
            case NOMINAL_20 -> Math.min(reminder / NOMINAL_20, currency20);
            case NOMINAL_10 -> Math.min(reminder / NOMINAL_10, currency10);
            default -> 0;
        };
    }

    private int calcReminder(int nominal, int count, int reminder) {
        return count > 0 ? reminder - count * nominal : reminder;
    }

    private boolean withdrawMoney(int nominal50, int nominal20, int nominal10) {
        if (isEnough(nominal50, nominal20, nominal10)) {
            if (nominal50 > 0) {
                currency50 -= nominal50;
            }
            if (nominal20 > 0) {
                currency20 -= nominal20;
            }
            if (nominal10 > 0) {
                currency10 -= nominal10;
            }
            return true;
        }
        return false;
    }

    private boolean isEnough(int totalMoney) {
        return totalMoney <= getTotalMoney();
    }

    private boolean isEnough(int currency50, int currency20, int currency10) {
        return (currency50 == 0 || (currency50 > 0 && this.currency50 >= currency50)) &&
               (currency20 == 0 || (currency20 > 0 && this.currency20 >= currency20)) &&
               (currency10 == 0 || (currency10 > 0 && this.currency10 >= currency10));
    }
}
