public class Main {
    public static void main(String[] args) {
        // Version A
        Account a1 = new Account("James");
        Account a2 = new Account("William");
        Transaction t = new Transaction(a1, a2, 37.3);
        Bank b = new Bank();
        b.doTransfer(t);
        // System.out.println(a1.customerName + ": " + a1.balance);
        // System.out.println(a2.customerName + ": " + a2.balance);

        // Version B
        Addressee a = new Addressee("John", "13 Computing Drive");
        Parcel p = new Parcel(a);
        Courier c = new Courier(p);
        Depot d = new Depot();
        d.outForDelivery(c);
        // System.out.println(p.addressee == a);
        // System.out.println(p.delivered);

        // Version C
        Library lib = new Library();
        Book bk = new Book("Book Title", "Sam");
        Borrower br = new Borrower("John", 1234);
        lib.loanBook(bk, br); 
    }
}