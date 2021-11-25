CompletableFuture<A> bar(A a) {
    return CompletableFuture.<A>supplyAsync(() -> a.incr());
}
CompletableFuture<A> b = foo(new A()).thenCompose(x -> bar(x));
System.out.println(b.join());

CompletableFuture<A> baz(A a, int x) {
    if (x == 0) {
        return CompletableFuture.<A>completedFuture(new A(0));
    } else {
        return CompletableFuture.<A>supplyAsync(() -> a.incr().decr());
    }
}
CompletableFuture<A> c = baz(new A(), 1);
System.out.println(c.join());

CompletableFuture<Void> all = CompletableFuture.<Void>allOf(
        foo(new A()),
        bar(new A()),
        baz(new A(), 1));
all.join();
System.out.println("done!");

CompletableFuture<A> exc = CompletableFuture
.<A>supplyAsync(() -> new A().decr().decr())
    .handle((result, exception) -> {
            if (result == null) {
                System.out.println("ERROR: " + exception);
                return new A();
            } else {
                return result;
            }
        });
