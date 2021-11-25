Token t1 = new Token(1)
Token t2 = new Token(2)
t1 = t1.ping(t2, 10).ping(new Token(3), 5)
t1
t2
new RegistryImpl("r1", new Token[]{t1, t2}).alert(5)
new RegistryImpl("r2", new Token[]{t1, t2}).alert(8)
t2 = t2.ping(t1, 5)
new RegistryImpl("r3", new Token[]{t1, t2}).alert(5)
/exit
