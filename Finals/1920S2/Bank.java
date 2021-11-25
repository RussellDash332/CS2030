class Bank {
    Transaction transaction;

    void doTransfer(Transaction transaction) {
        this.transaction = transaction;
        this.transaction.complete();
    }
}