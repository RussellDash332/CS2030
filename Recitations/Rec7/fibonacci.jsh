class Pair<T,U> {
    private final T t;
    private final U u;

    Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    T first() {
        return this.t;
    }

    U second() {
        return this.u;
    }
}

Stream<BigInteger> fibonacci(int n) {
    Pair<BigInteger,Integer> startPair =
        new Pair<BigInteger,BigInteger>(BigInteger.ZERO, BigInteger.ONE);

    UnaryOperator<Pair<Integer,Integer>> nextPair = pr ->
        new Pair<BigInteger,BigInteger>(pr.second(),
                pr.first().add(pr.second()));

    return Stream.iterate(startPair, nextPair)
        .map(pr -> pr.second()).limit(n);
}
