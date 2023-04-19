class Count<T> extends Aggregate<Integer,T> {
    private Count(T val) {
        super(1, val, null, true);
    }

    private Count(Integer c, T val) {
        super(c, val, null, true);
    }

    static <T> Count<T> of(T val) {
        return new Count<T>(val);
    }

    Count<T> map(T newVal) {
        return new Count<T>(super.getVal() + 1, newVal);
    }
}