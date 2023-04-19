DataStore db = new DataStore()
db.write("Hello")
Token t1 = new Token(1)
Token t2 = new Token(2)
t1 = t1.ping(t2, 10)
t1
new RegistryStub()
Registry stub = new RegistryStub("Test Stub")
stub
stub.store("Hello world")
new RegisteredToken(t1, stub)
new RegisteredToken(t1, stub).contact()
Token t = new RegisteredToken(t1, stub)
t1
/exit
