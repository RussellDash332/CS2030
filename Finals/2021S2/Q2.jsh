new Account(10)
new Account(10).credit(1)
new Account(10).credit(1).debit(2)

Creditor.deposit(new Account(20), 10)
Debitor.withdraw(new Account(20), 10)