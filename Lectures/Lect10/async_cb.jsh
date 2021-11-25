/open abcde.jsh
/open Async.java

void foo(int m, int n) {
    B b = f(new A());
    Async task = Async.doThis(() -> g(b, m))
        .thenDoThis(() -> System.out.println("print"))
        .thenDoThis(() -> System.out.println("print somemore"));
    h(b, n);
    task.join();
}

foo(10, 5)

/exit