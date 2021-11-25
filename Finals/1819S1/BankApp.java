import java.util.Scanner;

class BankApp {
    static void transfer(Account source, Account target, double amount) {
        if (source.canWithdraw(amount) && source.enoughBalance(amount) && amount > 0) {
            source = source.withdraw(amount);
            target = target.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Transfer unsuccessful");
        }
    }

    static double getAmount() {
        System.out.print("Enter amount to transfer: ");
        return new Scanner(System.in).nextDouble();
    }
    public static void main(String[] args) {
        Account s = getAccount();
        Account t = getAccount();
        double amt = getAmount();
        transfer(s, t, amt);
    }

    // getAccount and other methods omitted
    // No, what do you mean? I'm making it!
    static Account getAccount() {
        return new Account(new Scanner(System.in).nextDouble());
    }
}