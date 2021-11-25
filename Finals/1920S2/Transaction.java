class Transaction {
    Account send;
    Account receive;
    Double amount;

    Transaction(Account send, Account receive, Double amount) {
        this.send = send;
        this.receive = receive;
        this.amount = amount;
    }

    void complete() {
        this.send.balance -= amount;
        this.receive.balance += amount;
    }
}