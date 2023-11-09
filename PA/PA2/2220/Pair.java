class Pair<T,R> {
    private final T first;
    private final R second;

    private Pair(T first, R second) {
        this.first = first;
        this.second = second;
    }

    static <T,R> Pair<T,R> of(T first, R second) {
        return new Pair<T,R>(first, second);
    }

    T first() {
        return this.first;
    }

    R second() {
        return this.second;
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}