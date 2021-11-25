import java.util.function.Supplier;
import java.util.function.Function;
import java.util.Optional;

class Lazy<T> {
    private final Supplier<T> supplier;
    private Optional<T> cache;

    private Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
        this.cache = Optional.<T>empty();
    }

    static <T> Lazy<T> of(Supplier<T> supplier) {
        return new Lazy<T>(Optional.<Supplier<T>>ofNullable(supplier).orElseThrow());
    }

    static <T> Lazy<T> of(T t) {
        return new Lazy<T>(() -> t);
    }

    <R> Lazy<R> map(Function<? super T, ? extends R> mapper) {
        Supplier<R> supplier = new Supplier<R>() {
            @Override
            public R get() {
                return mapper.apply(Lazy.this.get()); // this.get()? or get()?
            } // mapper and Lazy is accessible from Supplier local class
        };
        return Lazy.<R>of(supplier);
    }

    T get() {
        T v = this.cache.orElseGet(this.supplier);
        this.cache = Optional.<T>of(v);
        return v;
    }
}