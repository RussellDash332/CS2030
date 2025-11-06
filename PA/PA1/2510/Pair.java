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
    public T t() {
        return this.t;
    }

    /**
     * Returns the second item of the pair.
     *
     * @return the second item of the pair
     */
    public U u() {
        return this.u;
    }

    /**
     * Returns the string representation of the pair.
     *
     * @return the string representation of the pair
     */
    @Override
    public String toString() {
        return "Pair[t=" + this.t + ", u=" + this.u + "]";
    }
}
