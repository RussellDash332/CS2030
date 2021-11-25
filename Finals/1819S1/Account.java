class Account {
    private final double balance;
    private final double limit;

    Account(double balance) {
        this(balance, Double.MAX_VALUE);
    }
    
    Account(double balance, double limit) {
        this.balance = balance;
        this.limit = limit;
    }

    Account withdraw(double amount) {
        return new Account(this.balance - amount);
    }

    Account deposit(double amount) {
        return new Account(this.balance + amount);
    }

    boolean canWithdraw(double amount) {
        return this.limit >= amount;
    }

    boolean enoughBalance(double amount) {
        return this.balance >= amount;
    }

    // other methods omitted
}