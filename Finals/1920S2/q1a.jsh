interface I {
    void foo(A a);
    void foo(I i);
}

class A implements I {
    public void foo(A a) { System.out.println(1); }
    public void foo(I i) { System.out.println(2); }
}

class B extends A implements I {
    public void foo(A a) { System.out.println(3); }
    public void foo(I i) { System.out.println(4); }
    public void foo(B b) { System.out.println(5); }
}

A a = new A();
A ab = new B();
B b = new B();
I i = b;
a.foo(a);   // 1
b.foo(b);   // 5
b.foo(ab);  // 3
b.foo(i);   // 4
