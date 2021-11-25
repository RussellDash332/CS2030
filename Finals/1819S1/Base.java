import java.util.function.Supplier;

class Base<T> implements Compute<T> {
    private final Supplier<T> sup;

    Base(Supplier<T> sup) {
        this.sup = sup;
    }

    public T eval() {
        return sup.get();
    }
    
    public boolean isRecursive() {
        return false;
    }

    public Compute<T> recurse() throws IllegalStateException {
        throw new IllegalStateException("Already a Base!");
    }
}