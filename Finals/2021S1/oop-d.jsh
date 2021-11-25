/open oop-c.java

List<Base> bases = new ArrayList<Base>();
Supplier<Base> aOtherSup = () -> bases.get(0);
Supplier<Base> a2OtherSup = () -> bases.get(1);
Supplier<Base> b1OtherSup = () -> bases.get(2);
Supplier<Base> b2OtherSup = () -> bases.get(3);

A a = new A().set(aOtherSup);
A a2 = new A().set(a2OtherSup);
B b1 = new B().set(b1OtherSup);
B b2 = new B().set(b2OtherSup);

bases.add(a2);
bases.add(b1);
bases.add(b2);
bases.add(a);

System.out.println(a);
System.out.println(a.get());
System.out.println(a.get().get());
System.out.println(a.get().get().get());
System.out.println(a.get().get().get().get());
System.out.println(a.get().get().get().get().get());

/exit