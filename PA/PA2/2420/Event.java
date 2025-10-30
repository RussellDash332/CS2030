class Event<T> {
    private final T t;
    private final double prob;

    Event(T t, double prob) {
        this.t = t;
        this.prob = prob;
    }

    T t() {
        return this.t;
    }

    double u() { // named u() to be consistent with usage of Pair
        return this.prob;
    }

    public String toString() {
        return "Event[" + t.toString() + String.format(", %.3f]", this.prob);
    }
}
