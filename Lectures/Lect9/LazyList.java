class LazyList<T> {
    private final Supplier<T> head;
    private final Supplier<LazyList<T>> tail;
    
    private LazyList(Supplier<T> head, Supplier<LazyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    static <T> LazyList<T> generate(Supplier<T> supplier) {
        Supplier<T> newHead = supplier;
        Supplier<LazyList<T>> newTail = () -> LazyList.<T>generate(supplier);
        return new LazyList<T>(newHead, newTail);
    }

    static <T> LazyList<T> generate(Supplier<T> supplier) {
        Supplier<T> newHead = supplier;
        Supplier<LazyList<T>> newTail = () -> LazyList.<T>generate(supplier);
        return new LazyList<T>(newHead, newTail);
    }

    void forEach(Consumer<? super T> consumer) {
        LazyList<T> curr = this;
        for (int i = 0; i < 5; i++) {
            T value = curr.head.get();
            consumer.accept(value);
            curr = curr.tail.get();
        }
    }

    <U> LazyList<U> map(Function<? super T, ? extends U> mapper) {
        Supplier<U> newHead = () -> mapper.apply(LazyList.this.head.get());
        Supplier<LazyList<U>> newTail = () -> LazyList.this.tail.get().map(mapper);
        return new LazyList<U>(newHead, newTail);
    }
}    