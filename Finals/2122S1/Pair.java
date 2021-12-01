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
