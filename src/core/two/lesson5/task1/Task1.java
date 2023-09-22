package core.two.lesson5.task1;

public class Task1 {

    public static void main(String[] args) {
        ATM sberATM = new ATM(10, 5, 2);
        System.out.println(sberATM.getMoney(80));
        System.out.println(sberATM.getTotalMoney());
        System.out.println(sberATM.getMoney(80));
        System.out.println(sberATM.getTotalMoney());
        System.out.println(sberATM.getMoney(80));
        System.out.println(sberATM.getTotalMoney());
        System.out.println(sberATM.getMoney(80));
        System.out.println(sberATM.getTotalMoney());
        sberATM.addNominal50(1);
        System.out.println(sberATM.getTotalMoney());
        System.out.println(sberATM.getMoney(80));
        System.out.println(sberATM.getTotalMoney());
        System.out.println(sberATM.getMoney(30));
        System.out.println(sberATM.getTotalMoney());
    }
}
