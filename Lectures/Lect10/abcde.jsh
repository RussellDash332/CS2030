int doWork(int n) {
    try {
        Thread.sleep(n * 1000);
    } catch (InterruptedException e) { }
    return n;
}

class A { }
class B { }
class C { }
class D { }
class E { }

B f(A a) { return new B(); }

C g(B b, int n) {
    System.out.println("g: start");
    doWork(n);
    System.out.println("g: done");
    return new C();
}

D h(B b, int n) {
    System.out.println("h: start");
    doWork(n);
    System.out.println("h: done");
    return new D();
}

E n(C c, D d) { return new E(); }