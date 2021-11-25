/open abcde.jsh

void foo(int m, int n) {
    B b = f(new A());
    Thread t = new Thread(() -> g(b, m));
    t.start();
    D d = h(b, n);
    try {
        t.join();
    } catch (InterruptedException e) { }
    System.out.println("print");
}

foo(5, 10)
foo(10, 5)

/exit