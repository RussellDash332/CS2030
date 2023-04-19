Token t1 = new Token(1)
Token t2 = new Token(2)
new Token(3)
t1
t2
t1.ping(t2,10)
t1
t2
t1 = t1.ping(t2, 10).ping(new Token(3), 5)
t1
t2
new Token(1).ping(new Token(3), 5).ping(new Token(2), 10)
/exit
