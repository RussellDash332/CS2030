import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
abstract class MyStream<T> {
    static <T> MyStream<T> generate(Supplier<T> seed) {
        return new MyStream<T>() {
            public T get() {
                return seed.get();
            }
        };
    }
    abstract T get();
}
