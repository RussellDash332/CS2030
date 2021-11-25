/open abcde.jsh

void foo(int m, int n) {
    B b = f(new A());
    CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> g(b, m))
        .thenRun(() -> System.out.println("print"));
    h(b, n);
    cf.join();
}

foo(10, 5)

E bar(int m, int k) {
    B b = f(new A());
    CompletableFuture<C> cf = CompletableFuture.supplyAsync(() -> g(b, m));
    D d = h(b, k);
    return cf.thenApply(x -> n(x, d)).join();
}

bar(10, 5)

/exit