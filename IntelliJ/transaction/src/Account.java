import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    /**nap tien.*/
    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban nap vao khong hop le!");
        } else {
            balance += amount;
        }
    }

    /**rut tien.*/
    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else if (amount > balance) {
            System.out.println(" So tien ban rut vuot qua so du!");
        } else {
            balance = balance - amount;
        }
    }


    /**them hoac nap.*/
    public void addTransaction(double amount, String operation) {
        if (operation.equals(Transaction.DEPOSIT)) {
            deposit(amount);
            Transaction a = new Transaction(operation, amount, balance);
            transitionList.add(a);
        } else if (operation.equals(Transaction.WITHDRAW)) {
            withdraw(amount);
            Transaction a = new Transaction(operation, amount, balance);
            transitionList.add(a);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**int. */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.printf("Giao dich " + (i + 1));
            if (transitionList.get(i).getOperation().equals(Transaction.DEPOSIT)) {
                System.out.printf(": Nap tien $%.2f", transitionList.get(i).getAmount());
            } else {
                System.out.printf(": Rut tien $%.2f", transitionList.get(i).getAmount());
            }
            System.out.printf(". So du luc nay: $%.2f", transitionList.get(i).getBalance());
            System.out.println(".");
        }
    }
}
