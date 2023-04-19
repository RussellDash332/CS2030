import java.util.function.Function;

class Maybe<T> {
    private final T thing;

    private Maybe (T thing) {
        this.thing = thing;
    }

    static <T> Maybe<T> of(T thing) {
        return new Maybe<T>(thing);
    }

    static <T> Maybe<T> empty() {
        return new Maybe<T>(null);
    }

    <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
        if (thing == null) {
            return Maybe.<R>empty();
        } else {
            return Maybe.<R>of(mapper.apply(this.thing));
        }
    }

    @Override
    public String toString() {
        return (thing == null) ? "Maybe.empty" : "Maybe[" + thing + "]";
    }
}
