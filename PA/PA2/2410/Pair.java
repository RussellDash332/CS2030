/**
 * This utility class stores two items together in a pair.
 * It could be used, for instance, to faciliate returning of
 * two values in a function.
 *
 * @author cs2030
 * @param <T> the type of the first element
 * @param <U> the type of the second element
 **/
public class Pair<T, U> {
    private final T t;
    private final U u;

    /**
     * Creates a {@code Pair} of items.
     *
     * @param t first item of the pair
     * @param u second item of the pair
     **/
    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    /**
     * Returns the first item of the pair.
     *
     * @return the first item of the pair
     */
    public T first() {
        return this.t;
    }

    /**
     * Returns the second item of the pair.
     *
     * @return the second item of the pair
     */
    public U second() {
        return this.u;
    }

    /**
     * Returns a string representation of this pair enclosed in ({@code "()"}).  
     * The two elements are separated by the characters {@code ", "} (comma and space).
     * Elements are converted to strings as by {@link String#valueOf(Object)}.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        return "(" + this.t + ", " + this.u + ")";
    }
}
