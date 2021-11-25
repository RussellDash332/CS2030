Token t1 = new Token(1)
Token t2 = new Token(2)
t1 = t1.ping(t2, 10)
Registry r1 = new RegistryImpl("r1")
r1
Registry r2 = new RegistryImpl("r2", new Token[]{t1, t2})
r2
Registry r3 = new RegistryImpl("r3", new Token[]{})
r3
/exit
