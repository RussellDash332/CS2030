class Account {
    private double balance;
    
    Account(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) {
        this.balance = this.balance - amount;
    }

    void deposit(double amount) {
        this.balance = this.balance + amount;
    }
    
    // other methods omitted
}