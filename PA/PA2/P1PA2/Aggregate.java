import java.util.function.Function;

class Aggregate<T,R> {
    private final T val;
    private final R obj;
    private final Function<T, Pair<T,R>> f;
    private boolean valid;

    Aggregate(T val, R obj, Function<T, Pair<T,R>> f, boolean valid) {
        this.val = val;
        this.obj = obj;
        this.f = f;
        this.valid = valid;
    }

    T getVal() {
        return this.val;
    }

    Function<T, Pair<T,R>> getFun() {
        return this.f;
    }

    static <T,R> Aggregate<T,R> seed(T val) {
        return new Aggregate<T,R>(val, null, null, true);
    }

    static <T,R> Aggregate<T,R> of(Function<T, Pair<T,R>> f) {
        return new Aggregate<T,R>(null, null, f, true);
    }

    Aggregate<T,R> map(Function<T,T> f, R newObj) {
        return new Aggregate<T,R>(f.apply(this.val), newObj, null, true);
    }

    Aggregate<T,R> map(Function<T,Pair<T,R>> f) {
        if (this.val == null) {
            return new Aggregate<T,R>(null, null, null, false);
        }
        Pair<T,R> pair = f.apply(this.val);
        return new Aggregate<T,R>(pair.first(), pair.second(), null, true);
    }

    <S> Aggregate<T,S> flatMap(Function<R,Aggregate<T,S>> f) {
        if (this.obj == null) {
            return new Aggregate<T,S>(null, null, null, false);
        }
        Aggregate<T,S> agg = f.apply(this.obj);
        // agg.getFun() is of type Function<T, Pair<T,S>>
        Pair<T,S> pair = agg.getFun().apply(this.val);
        return new Aggregate<T,S>(pair.first(), pair.second(), null, true);
    }

    @Override
    public String toString() {
        if (this.valid) {
            if (this.val != null) {
                if (this.obj != null) {
                    return "(" + this.val + ", " + this.obj + ")";
                } else {
                    return "(" + this.val + ")";
                }
            } else {
                return "Aggregate";
            }
        } else {
            return "Invalid Aggregate";
        }
    }
}