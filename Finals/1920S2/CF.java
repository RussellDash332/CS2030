import java.util.concurrent.CompletableFuture;

class CF {
    static void doSomething() {;}

    static CompletableFuture<Void> printAsync(int i) {
        return CompletableFuture.runAsync(() -> {
            doSomething();
            System.out.print(i);
        });
    }

    public static void main(String[] args) {
        printAsync(1).join();
        CompletableFuture.allOf(printAsync(2), printAsync(3))
            .thenRunAsync(() -> printAsync(4));
        doSomething();
    }

    static void doStuff() {
        printAsync(1).join();
        CompletableFuture.allOf(printAsync(2), printAsync(3))
            .thenRun(() -> printAsync(4));
        doSomething();
    }
}