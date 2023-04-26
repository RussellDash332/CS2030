import java.util.Comparator;

class SecondBest<T> {
    private final T first;
    private final T second;
    private final Comparator<? super T> cmp;

    SecondBest(T x, T y, Comparator<? super T> cmp) {
        this.cmp = cmp;
        if (cmp.compare(x,y) < 0) {
            this.first = y;
            this.second = x;
        } else {
            this.first = x;
            this.second = y;
        }
    }

    @Override
    public String toString() {
        return "" + this.second;
    }
}