import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Consumer;

class CachedString {
    private final Supplier<String> sup;
    private final Supplier<Function<String,String>> mapper;

    CachedString(Supplier<String> sup) {
        this(sup, () -> (x -> x));
    }

    private CachedString(Supplier<String> sup, Supplier<Function<String,String>> mapper) {
        this.sup = sup;
        this.mapper = mapper;
    }

    String get() {
        return mapper.get().apply(sup.get());
    }

    CachedString map(Function<? super String,String> f) {
        return new CachedString(sup, () -> f.compose(mapper.get()));
    }

    CachedString flatMap(Function<? super String,CachedString> f) {
        return new CachedString(() -> f.apply(this.get()).get());
    }

    void forEach(Consumer<String> consumer) {
        consumer.accept(this.get());
    }

    boolean isEmpty() {
        return this.get().equals("");
    }
}