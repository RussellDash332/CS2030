class NestedStream<T> {
    private final Stream<T> s;

    NestedStream(Stream<T> s) {
        this.s = s;
    }

    // ????
    <R> Stream<R> nestedMap(BiFunction<T,T,R> lambda) {
        return s.map(i -> s.flatMap(j, (i,j) -> lambda.apply(i,j)));
    }
}