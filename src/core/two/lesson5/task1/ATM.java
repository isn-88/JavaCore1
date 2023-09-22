package core.two.lesson5.task1;


public class ATM {

    private int nominal10;
    private int nominal20;
    private int nominal50;

    public ATM(int nominal10, int nominal20, int nominal50) {
        this.nominal10 = nominal10;
        this.nominal20 = nominal20;
        this.nominal50 = nominal50;
    }

    public void addNominal10(int count) {
        nominal10 += count;
    }

    public void addNominal20(int count) {
        nominal20 += count;
    }

    public void addNominal50(int count) {
        nominal50 += count;
    }

    public boolean getMoney(int value) {
        if (value < 10) {
            return false;
        }

        if (!isEnough(value)) {
            return false;
        }

        int reminder = value;
        int count50 = Math.min(reminder / 50, nominal50);
        if (count50 > 0) {
            reminder -= count50 * 50;
        }
        int count20 = Math.min(reminder / 20, nominal20);
        if (count20 > 0) {
            reminder -= count20 * 20;
        }
        int count10 = Math.min(reminder / 10, nominal10);
        if (count10 > 0) {
            reminder -= count10 * 10;
        }
        if (reminder == 0) {
            if (count50 <= nominal50 && count20 <= nominal20 && count10 <= nominal10 &&
                    getSumBanknotes(count50, count20, count10) == value) {
                return withdrawMoney(count50, count20, count10);
            }
        }
        return false;
    }

    public int getTotalMoney() {
        return nominal10 * 10 + nominal20 * 20 + nominal50 * 50;
    }

    private int getSumBanknotes(int nominal50, int nominal20, int nominal10) {
        return nominal50 * 50 + nominal20 * 20 + nominal10 * 10;
    }


    private boolean isEnough(int value) {
        return value <= getTotalMoney();
    }


    private boolean withdrawMoney(int nominal50, int nominal20, int nominal10) {
        if ((nominal50 == 0 || (nominal50 > 0 && nominal50 <= this.nominal50)) &&
                (nominal20 == 0 || (nominal20 > 0 && nominal20 <= this.nominal20)) &&
                (nominal10 == 0 || (nominal10 > 0 && nominal10 <= this.nominal10))) {
            if (nominal50 > 0) {
                this.nominal50 -= nominal50;
            }
            if (nominal20 > 0) {
                this.nominal20 -= nominal20;
            }
            if (nominal10 > 0) {
                this.nominal10 -= nominal10;
            }
            return true;
        }
        return false;
    }

}
