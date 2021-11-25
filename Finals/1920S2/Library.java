class Library {
    Loan loan;

    public void loanBook(Book book, Borrower borrower) {
        loan = new Loan(book, borrower);
    }
}