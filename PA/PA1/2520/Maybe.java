import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * A container object which may or may not contain a non-{@code null} value.
 * If a value is present, {@code isPresent()} returns {@code true}. If no
 * value is present, the object is considered <i>empty</i> and
 * {@code isPresent()} returns {@code false}.
 *
 * <p>Additional methods that depend on the presence or absence of a contained
 * value are provided, such as {@link #orElse(T) orElse()}
 * (returns a default value if no value is present) and
 * {@link #ifPresent(Consumer) ifPresent()} (performs an
 * action if a value is present).
 *
 * {@code Maybe} is primarily intended for use as a method return type where
 * there is a clear need to represent "no result," and where using {@code null}
 * is likely to cause errors. A variable whose type is {@code Maybe} should
 * never itself be {@code null}; it should always point to an {@code Maybe}
 * instance.
 *
 * @author cs2030
 * @param <T> the type of value
 */

public class Maybe<T> {
    private final T value;

    private Maybe(T value) {
        this.value = value;
    }

    /**
     * Returns an {@code Maybe} describing the given value, if
     * non-{@code null}, otherwise returns an empty {@code Maybe}.
     *
     * @param value the possibly-{@code null} value to describe
     * @param <T> the type of the value
     * @return an {@code Maybe} with a present value if the specified value
     *         is non-{@code null}, otherwise an empty {@code Maybe}
     */
    public static <T> Maybe<T> of(T value) {
        if (value == null) { 
            return Maybe.<T>empty();
        }
        return new Maybe<T>(value);
    }

    /**
     * Returns an empty {@code Maybe} instance.  No value is present for this
     * {@code Maybe}.
     *
     * @param <T> The type of the non-existent value
     * @return an empty {@code Maybe}
     */
    public static <T> Maybe<T> empty() {
        T val = null;
        return new Maybe<T>(val);
    }

    private T get() {
        return this.value;
    }

    private boolean isPresent() {
        return this.value != null;
    }

    /**
     * If a value is present, and the value matches the given predicate,
     * returns an {@code Maybe} describing the value, otherwise returns an
     * empty {@code Maybe}.
     *
     * @param predicate the predicate to apply to a value, if present
     * @return an {@code Maybe} describing the value of this
     *         {@code Maybe}, if a value is present and the value matches the
     *         given predicate, otherwise an empty {@code Maybe}
     * @throws NullPointerException if the predicate is {@code null}
     */
    public Maybe<T> filter(Predicate<? super T> predicate) {
        if (this.isPresent() && predicate.test(this.get())) {
            return this;
        }
        return Maybe.<T>empty();
    }

    /**
     * If a value is present, performs the given action with the value,
     * otherwise does nothing.
     *
     * @param action the action to be performed, if a value is present
     * @throws NullPointerException if value is present and the given action is
     *         {@code null}
     */
    public void ifPresent(Consumer<? super T> action) {
        if (this.isPresent()) {
            action.accept(this.get());
        }
    }

    /**
     * If a value is present, returns an {@code Maybe} describing
     * the result of applying the given mapping function to
     * the value, otherwise returns an empty {@code Maybe}.
     *
     * <p>If the mapping function returns a {@code null} result then this method
     * returns an empty {@code Maybe}.
     *
     * @param mapper the mapping function to apply to a value, if present
     * @param <R> The type of the value returned from the mapping function
     * @return an {@code Maybe} describing the result of applying a mapping
     *         function to the value of this {@code Maybe}, if a value is
     *         present, otherwise an empty {@code Maybe}
     * @throws NullPointerException if the mapping function is {@code null}
     */
    public <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
        if (this.isPresent()) {
            return Maybe.<R>of(mapper.apply(this.get()));
        }
        return Maybe.<R>empty();
    }

    /**
     * If a value is present, returns the result of applying the given
     * {@code Maybe}-bearing mapping function to the value, otherwise returns
     * an empty {@code Maybe}.
     *
     * <p>This method is similar to {@link #map(Function)}, but the mapping
     * function is one whose result is already an {@code Maybe}, and if
     * invoked, {@code flatMap} does not wrap it within an additional
     * {@code Maybe}.
     *
     * @param <R> The type of value of the {@code Maybe} returned by the
     *            mapping function
     * @param mapper the mapping function to apply to a value, if present
     * @return the result of applying an {@code Maybe}-bearing mapping
     *         function to the value of this {@code Maybe}, if a value is
     *         present, otherwise an empty {@code Maybe}
     * @throws NullPointerException if the mapping function is {@code null} or
     *         returns a {@code null} result
     */
    public <R> Maybe<R> flatMap(Function<? super T, ? extends Maybe<? extends R>> mapper) {
        if (this.isPresent()) {
            return flatten(this.map(mapper));
        }
        return Maybe.<R>empty();
    }

    private static <R> Maybe<R> flatten(Maybe<? extends Maybe<? extends R>> mmr) {
        Maybe<? extends R> mr = mmr.get();
        if (mr.isPresent()) {
            return Maybe.<R>of(mr.get());
        }
        return Maybe.<R>empty();
    }

    /**
     * If a value is present, returns an {@code Maybe} describing the value,
     * otherwise returns an {@code Maybe} produced by the supplying function.
     *
     * @param supplier the supplying function that produces an {@code Maybe}
     *        to be returned
     * @return returns an {@code Maybe} describing the value of this
     *         {@code Maybe}, if a value is present, otherwise an
     *         {@code Maybe} produced by the supplying function.
     * @throws NullPointerException if the supplying function is {@code null} or
     *         produces a {@code null} result
     */
    public Maybe<T> or(Supplier<? extends Maybe<? extends T>> supplier) {
        if (this.isPresent()) {
            return this;
        }
        Maybe<? extends T> maybeT = supplier.get();
        return Maybe.<T>of(maybeT.get());
    }

    /**
     * If a value is present, returns the value, otherwise returns
     * {@code other}.
     *
     * @param other the value to be returned, if no value is present.
     *        May be {@code null}.
     * @return the value, if present, otherwise {@code other}
     */
    public T orElse(T other) {
        if (this.isPresent()) {
            return this.value;
        }
        return other;
    }

    /**
     * If a value is present, returns the value, otherwise returns the result
     * produced by the supplying function.
     *
     * @param supplier the supplying function that produces a value to be returned
     * @return the value, if present, otherwise the result produced by the
     *         supplying function
     * @throws NullPointerException if no value is present and the supplying
     *         function is {@code null}
     */
    public T orElseGet(Supplier<? extends T> supplier) {
        if (this.isPresent()) {
            return this.value;
        }
        return supplier.get();
    }

    /**
     * Returns a non-empty string representation of this {@code Maybe}
     * suitable for debugging.  The exact presentation format is unspecified and
     * may vary between implementations and versions.
     *
     * <p>If a value is present the result must include its string representation
     * in the result.  Empty and present {@code Maybe}s must be unambiguously
     * differentiable.
     *
     * @return the string representation of this instance
     */
    @Override
    public String toString() {
        if (this.isPresent()) {
            return "Maybe[" + value + "]";
        }
        return "Maybe.empty";
    }
}
