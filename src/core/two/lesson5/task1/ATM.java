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


    public boolean addCurrency(int currency, int count) {
        if (count <= 0) {
            return false;
        }
        boolean result = true;
        switch (currency) {
            case NOMINAL_50 -> currency50 += count;
            case NOMINAL_20 -> currency20 += count;
            case NOMINAL_10 -> currency10 += count;
            default -> result = false;
        }
        return result;
    }

    public boolean getMoney(int value) {
        if (value < 10) {
            return false;
        }

        if (!isEnough(value)) {
            return false;
        }

        int reminder = value;
        int count50 = Math.min(reminder / 50, currency50);
        if (count50 > 0) {
            reminder -= count50 * 50;
        }
        int count20 = Math.min(reminder / 20, currency20);
        if (count20 > 0) {
            reminder -= count20 * 20;
        }
        int count10 = Math.min(reminder / 10, currency10);
        if (count10 > 0) {
            reminder -= count10 * 10;
        }
        if (reminder == 0) {
            if (count50 <= currency50 && count20 <= currency20 && count10 <= currency10 &&
                getSumCurrency(count50, count20, count10) == value) {
                return withdrawMoney(count50, count20, count10);
            }
        }
        return false;
    }

    public int getTotalMoney() {
        return getSumCurrency(currency50, currency20, currency10);
    }

    private int getSumCurrency(int currency50, int currency20, int currency10) {
        return currency50 * NOMINAL_50 + currency20 * NOMINAL_20 + currency10 * NOMINAL_10;
    }

    private boolean withdrawMoney(int nominal50, int nominal20, int nominal10) {
        if (isEnough(nominal50, nominal20, nominal10)) {
            if (nominal50 > 0) {
                this.currency50 -= nominal50;
            }
            if (nominal20 > 0) {
                this.currency20 -= nominal20;
            }
            if (nominal10 > 0) {
                this.currency10 -= nominal10;
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
