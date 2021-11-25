void sleep(int n) {
    try {
        Thread.sleep(n * 1000);
    } catch (InterruptedException e) { }
}

void foo() {
    CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
        sleep(5);
        System.out.println("cf1: " + Thread.currentThread().getName()); });

    CompletableFuture<Void> cf2 = cf1.thenRun(() -> {
        sleep(5);
        System.out.println("cf2: " + Thread.currentThread().getName()); });

    CompletableFuture<Void> cf3 = cf1.thenRunAsync(() -> {
        sleep(5);
        System.out.println("cf3: " + Thread.currentThread().getName()); });

    cf2.join();
    cf3.join();
}

foo()

void bar() {
    CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
        sleep(5);
        System.out.println("cf1: " + Thread.currentThread().getName()); });

    CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> {
        sleep(5);
        System.out.println("cf2: " + Thread.currentThread().getName()); });

    CompletableFuture<Void> cf3 = cf1.thenRun(() -> {
        sleep(5);
        System.out.println("cf3: " + Thread.currentThread().getName()); });

    cf2.join();
    cf3.join();
}

bar()

/exit