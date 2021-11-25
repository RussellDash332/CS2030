Token t1 = new Token(1)
Token t2 = new Token(2)
t1 = t1.ping(t2, 10).ping(new Token(3), 5)
t1
t2
new RegistryImpl("r1", new Token[]{t1, t2}).alert(5)
new RegistryImpl("r2", new Token[]{t1, t2}).alert(8)
t2 = t2.ping(t1, 5)
Registry r = new RegistryImpl("r3", new Token[]{t1, t2})
r.alert(5)
new SafeEntry(10, 5)
Registry s = r.add(new SafeEntry(10, 5)).add(new Token(4).ping(t2, 5))
s
s.alert(5)
s.alert(8)
r
/exit
