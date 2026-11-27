import java.util.function.Supplier;
import java.util.function.Function;
import java.util.Optional;

class Lazy<T> implements Supplier<T> {
    private final Supplier<? extends T> supplier;
    private Optional<T> cache;

    Lazy(Supplier<? extends T> supplier) {
        this.supplier = supplier;
        this.cache = Optional.<T>empty();
    }

    static <T> Lazy<T> of(Supplier<? extends T> supplier) {
        return new Lazy<T>(supplier);
    }

    <R> Lazy<R> map(Function<? super T, ? extends R> mapper) {
        return new Lazy<R>(() -> mapper.apply(this.get()));
    }

    <R> Lazy<R> flatMap(Function<? super T, ? extends Lazy<? extends R>> mapper) {
        return new Lazy<R>(() -> mapper.apply(this.get()).map(Function.<R>identity()).get());
    }

    public T get() {
        return this.cache.orElseGet(() -> {
            T v = supplier.get();
            this.cache = Optional.of(v);
            return v;
        });
    }
}


