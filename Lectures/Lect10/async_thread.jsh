/open abcde.jsh

void foo(int m, int n) {
    B b = f(new A());
    Thread t = new Thread(() -> g(b, m));
    t.start();
    D d = h(b, n);
    while (t.isAlive()) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }
        System.out.println(".");
    }
    System.out.println("print");
}

foo(10, 5)

/exit