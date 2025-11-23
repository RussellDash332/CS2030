import java.util.function.BinaryOperator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.List;

/**
 * A infinite sequence of elements supporting sequential operations.
 *
 * <p>To perform a computation, infinite list operations are composed into a
 * <em>pipeline</em>.  A pipeline consists of a source iterator,
 * zero or more <em>intermediate operations</em> (which transform a
 * {@code InfList} into another {@code InfList}, such as {@link filter}), and a
 * <em>terminal operation</em> (which produces a result or side-effect, such
 * as {@link forEach}).
 * Infinite lists are lazy; computation on the source data is only performed when the
 * terminal operation is initiated, and source elements are consumed only
 * as needed.
 *
 * <p>Most operations accept parameters that describe user-specified
 * behavior, such as the lambda expression which are always instances of a
 * <a href="../function/package-summary.html">functional interface</a> such
 * as {@link java.util.function.Function}.  Unless other specified,
 * these parameters must be <em>non-null</em>.
 *
 * @author cs2030
 * @param <T> the type of the infinite list elements
 */
public interface InfList<T> {

    /**
     * Returns an infinite sequential ordered {@code InfList} produced by iterative
     * application of a function {@code next} to an initial element {@code seed},
     * producing a {@code InfList} consisting of {@code seed}, {@code next(seed)},
     * {@code next(next(seed))}, etc.
     *
     * <p>The first element (position {@code 0}) in the {@code InfList} will be
     * the provided {@code seed}.  For {@code n > 0}, the element at position
     * {@code n}, will be the result of applying the function {@code next} to the
     * element at position {@code n - 1}.
     *
     * @param <T> the type of stream elements
     * @param seed the initial element
     * @param next a function to be applied to the previous element to produce
     *          a new element
     * @return a new sequential {@code InfList}
     */
    public static <T> InfList<T> iterate(T seed, UnaryOperator<T> next) {
        return InfList.<T>of(() -> Maybe.<T>of(seed),            
                () -> InfList.iterate(next.apply(seed), next));
    }

    /**
     * Returns a sequential ordered stream whose elements are the specified values.
     *
     * @param <T> the type of stream elements
     * @param elems the elements of the new stream
     * @return the new stream
     */
    @SafeVarargs
    public static <T> InfList<T> of(T... elems) {
        List<T> list = List.of(elems);
        return InfList.<Integer>iterate(0, x -> x + 1)
            .takeWhile(x -> x < list.size())
            .map(x -> list.get(x));
    }

    private static <T> InfList<T> of(Supplier<Maybe<T>> head, 
            Supplier<InfList<T>> tail) {
        return new InfList<T>() {
            public InfList<T> next() {
                return tail.get();
            }

            public boolean isEmpty() {
                return false;
            }

            public Maybe<T> get() {
                return head.get();
            }

            public Maybe<T> findFirst() {
                return head.get().or(
                        () -> tail.get().findFirst());
            }

            public InfList<T> takeWhile(Predicate<? super T> pred) {
                return InfList.<T>of(() -> this.get().filter(pred),
                        () -> this.get().flatMap(h -> 
                            Maybe.of(h).filter(pred).map(x -> this.next().takeWhile(pred))
                        .or(() -> Maybe.of(InfList.<T>empty())))
                        .orElseGet(() -> this.takeWhile(pred)));
            }

            public InfList<T> filter(Predicate<? super T> pred) {
                return InfList.<T>of(() -> this.get().filter(pred),
                        () -> this.next().filter(pred));
            }

            public InfList<T> limit(int n) {
                if (n <= 0) {
                    return InfList.<T>empty();
                }
                return InfList.<T>of(head, () -> 
                        this.get().map(x -> 
                            tail.get().limit(n - 1))
                        .orElseGet(() -> tail.get().limit(n)));
            }

            public void forEach(Consumer<? super T> consumer) {
                this.get().ifPresent(consumer);
                this.next().forEach(consumer);
            }

            public Maybe<T> reduce(BinaryOperator<T> bop) {
                return this.get().map(x -> 
                        this.next().reduce(x, bop))
                    .or(() -> this.next().reduce(bop));
            }

            public <U> U reduce(U seed, BiFunction<U,T,U> bop) {
                return this.get().map(x -> 
                        this.next().reduce(bop.apply(seed,x), bop))
                    .orElseGet(() -> this.next().reduce(seed, bop));
            }

            public <R> InfList<R> map(Function<? super T, ? extends R> mapper) {
                return InfList.<R>of(() -> this.get().map(mapper),
                        () -> this.next().map(mapper));
            }

            public <R> InfList<R> flatMap(Function<? super T, 
                    ? extends InfList<? extends R>> mapper) {
                return InfList.<R>of(() -> this.get().map(mapper) // Maybe<InfList<R>>
                        .flatMap(iflr -> iflr.get().map(Function.<R>identity())),
                        () -> this.get().map(mapper) // Maybe<InfList<R>>
                        .map(iflr -> iflr.next().map(Function.<R>identity())
                            .concat(this.next().flatMap(mapper))) // Maybe<InfList<R>>
                        .orElse(InfList.<R>empty()));

            }

            public InfList<T> concat(InfList<? extends T> other) {
                return InfList.<T>of(head, () -> 
                        this.next().concat(other));
            }

            public boolean anyMatch(Predicate<? super T> predicate) {
                return this.filter(predicate)
                    .map(x -> true)
                    .findFirst().orElse(false);
                    //.reduce(false, (x,y) -> x || y);
            }

            public boolean allMatch(Predicate<? super T> predicate) {
                return !this.anyMatch(predicate.negate());
            }

            public boolean noneMatch(Predicate<? super T> predicate) {
                return !this.anyMatch(predicate);
            }
        };
    }

    private static <T> InfList<T> empty() {
        return new InfList<T>() {
            public Maybe<T> get() {
                return Maybe.<T>empty();
            }

            public Maybe<T> findFirst() {
                return Maybe.<T>empty();
            }

            public InfList<T> next() {
                return InfList.<T>empty();
            }

            public boolean isEmpty() {
                return true;
            }

            public InfList<T> filter(Predicate<? super T> pred) {
                return this;
            }

            public InfList<T> takeWhile(Predicate<? super T> pred) {
                return this;
            }

            public InfList<T> limit(int n) {
                return this;
            }

            public void forEach(Consumer<? super T> consumer) {
            }

            public <R> InfList<R> map(Function<? super T, ? extends R> mapper) {
                return InfList.<R>empty();
            }

            public <U> U reduce(U seed, BiFunction<U,T,U> bop) {
                return seed;
            }

            public Maybe<T> reduce(BinaryOperator<T> bop) {
                return Maybe.<T>empty();
            }

            public <R> InfList<R> flatMap(Function<? super T, 
                    ? extends InfList<? extends R>> mapper) {
                return InfList.<R>empty();
            }

            public InfList<T> concat(InfList<? extends T> other) {
                return other.map(Function.<T>identity());
            }

            public boolean anyMatch(Predicate<? super T> predicate) {
                return false;
            }

            public boolean allMatch(Predicate<? super T> predicate) {
                return true;
            }

            public boolean noneMatch(Predicate<? super T> predicate) {
                return true;
            }
        };
    }

    /**
     * Returns an {@link Maybe} describing the first element of this infinite list,
     * or an empty {@code Maybe} if the list is empty.  
     *
     * @return an {@code Maybe} describing the first element of this infinite list, 
     *     or an empty {@code Maybe} if the list is empty
     * @throws NullPointerException if the element selected is null
     */
    public Maybe<T> findFirst();

    /**
     * This method is for internal use only.
     * @hidden
     * @return start element of the infinite list
     */
    Maybe<T> get();

    /**
     * This method is for internal use only.
     * @hidden
     * @return infinite list excluding the first element
     */
    InfList<T> next();

    /**
     * This method is for internal use only.
     * @hidden
     * @return true if infinite list is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * This method is for internal use only.
     * @hidden
     * @param other the other infinite list
     * @return result of concatenating {@code other} to the end of this infinite list
     */
    InfList<T> concat(InfList<? extends T> other);

    /**
     * Returns an infinite list consisting of the elements of this list, truncated
     * to be no longer than {@code maxSize} in length.
     *
     * @param maxSize the number of elements the list should be limited to
     * @return the new list
     * @throws IllegalArgumentException if {@code maxSize} is negative
     */
    public InfList<T> limit(int maxSize);

    /**
     * Performs an action for each element of this infinite list.
     *
     * @param action an action to perform on the elements
     */
    public void forEach(Consumer<? super T> action);

    /**
     * Returns an infinite list consisting of the results of applying the given
     * function to the elements of this list.
     *
     * @param <R> The element type of the new infinite list
     * @param mapper a function to apply to each element
     * @return the new infinite list
     */
    public <R> InfList<R> map(Function<? super T, ? extends R> mapper);

    /**
     * Returns an infinite list consisting of the results of replacing each element of
     * this list with the contents of a mapped list produced by applying
     * the provided mapping function to each element.  
     * If a mapped list is {@code null}
     * an empty list is used, instead.)
     *
     * @param <R> The element type of the new infinitelist
     * @param mapper a function to apply to each element which produces a 
     *     list of new values
     * @return the new infinite list
     */
    public <R> InfList<R> flatMap(Function<? super T, ? extends InfList<? extends R>> mapper);

    /**
     * Returns an infinite list consisting of the elements of this list that match
     * the given predicate.
     *
     * @param predicate a predicate to apply to each element to determine if it
     *     should be included
     * @return the new infinite list
     */
    public InfList<T> filter(Predicate<? super T> predicate);

    /**
     * Returns an infinite list consisting of the longest
     * prefix of elements taken from this list that match the given predicate.
     *
     * @param predicate a predicate to apply to elements to determine the longest
     *                  prefix of elements.
     * @return the new infinite list
     */
    public InfList<T> takeWhile(Predicate<? super T> predicate);

    /**
     * Performs a reduction on the
     * elements of this infinite list, using the provided identity value and an
     * accumulation function, and returns the reduced value.  This is equivalent
     * to:
     * <pre>{@code
     *     T result = identity;
     *     for (T element : this stream)
     *         result = accumulator.apply(result, element)
     *     return result;
     * }</pre>
     *
     * @param <U> The element type of the new infinite list
     * @param identity the identity value for the accumulating function
     * @param accumulator a binary function for combining two values
     * @return the result of the reduction
     */
    public <U> U reduce(U identity, BiFunction<U,T,U> accumulator);

    /**
     * Performs a reduction on the
     * elements of this infinite list, using a
     * function, and returns a {@code Maybe} describing the reduced value,
     * if any. This is equivalent to:
     * <pre>{@code
     *     boolean foundAny = false;
     *     T result = null;
     *     for (T element : this stream) {
     *         if (!foundAny) {
     *             foundAny = true;
     *             result = element;
     *         }
     *         else
     *             result = accumulator.apply(result, element);
     *     }
     *     return foundAny ? Maybe.of(result) : Maybe.empty();
     * }</pre>
     *
     * @param accumulator a function for combining two values
     * @return a {@link Maybe} describing the result of the reduction
     */
    public Maybe<T> reduce(BinaryOperator<T> accumulator);

    /**
     * Returns whether any elements of this stream match the provided
     * predicate.  May not evaluate the predicate on all elements if not
     * necessary for determining the result.  If the stream is empty then
     * {@code false} is returned and the predicate is not evaluated.
     *
     * This method evaluates the <em>existential quantification</em> of the
     * predicate over the elements of the stream (for some x P(x)).
     *
     * @param predicate predicate to apply to elements of this stream
     * @return {@code true} if any elements of the stream match the provided
     * predicate, otherwise {@code false}
     */
    public boolean anyMatch(Predicate<? super T> predicate);

    /**
     * Returns whether all elements of this stream match the provided predicate.
     * May not evaluate the predicate on all elements if not necessary for
     * determining the result.  If the stream is empty then {@code true} is
     * returned and the predicate is not evaluated.
     *
     * This method evaluates the <em>universal quantification</em> of the
     * predicate over the elements of the stream (for all x P(x)).  If the
     * stream is empty, the quantification is said to be <em>vacuously
     * satisfied</em> and is always {@code true} (regardless of P(x)).
     *
     * @param predicate a predicate to apply to elements of this stream
     * @return {@code true} if either all elements of the stream match the
     * provided predicate or the stream is empty, otherwise {@code false}
     */
    public boolean allMatch(Predicate<? super T> predicate);

    /**
     * Returns whether no elements of this stream match the provided predicate.
     * May not evaluate the predicate on all elements if not necessary for
     * determining the result.  If the stream is empty then {@code true} is
     * returned and the predicate is not evaluated.
     *
     * This method evaluates the <em>universal quantification</em> of the
     * negated predicate over the elements of the stream (for all x ~P(x)).  If
     * the stream is empty, the quantification is said to be vacuously satisfied
     * and is always {@code true}, regardless of P(x).
     *
     * @param predicate a predicate to apply to elements of this stream
     * @return {@code true} if either no elements of the stream match the
     * provided predicate or the stream is empty, otherwise {@code false}
     */
    public boolean noneMatch(Predicate<? super T> predicate);
}
