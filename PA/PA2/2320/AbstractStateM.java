import java.util.function.Function;

abstract class AbstractStateM<T,S> {
    private final Function<S,Pair<T,S>> f;

    AbstractStateM(T t) {
        this.f = s -> new Pair<T,S>(t, s);
    }

    AbstractStateM(Function<S,Pair<T,S>> f) {
        this.f = f;
    }

    Pair<T,S> accept(S s) {
        return this.f.apply(s);
    }
}
