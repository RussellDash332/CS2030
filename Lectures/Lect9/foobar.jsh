int foo() {
    System.out.println("foo");
    return 1;
}

int bar() {
    System.out.println("bar");
    return 2;
}

int baz(int n, int x, int y) {
    return n % 2 == 0 ? x : y;
}

int baz2(int n, Supplier<Integer> x, Supplier<Integer> y) {
    return n % 2 == 0 ? x.get() : y.get();
}

int baz3(int n, Lazy<Integer> x, Lazy<Integer> y) {
    return n % 2 == 0 ? x.get() : y.get();
}