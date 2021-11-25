import java.util.Scanner;

class BankApp {
    static void transfer(Account source, Account target, double amount) {
        source.withdraw(amount);
        target.deposit(amount);
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
        System.out.println("Transfer successful");
    }

    // getAccount and other methods omitted
    // No, what do you mean? I'm making it!
    static Account getAccount() {
        return new Account(new Scanner(System.in).nextDouble());
    }
}