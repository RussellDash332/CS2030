import java.util.function.Supplier;

class Recursive<T> implements Compute<T> {
    private final Supplier<Compute<T>> sup;

    Recursive(Supplier<Compute<T>> sup) {
        this.sup = sup;
    }

    public T eval() throws IllegalStateException {
        throw new IllegalStateException("Still a Recursive!");
    }
    
    public boolean isRecursive() {
        return true;
    }

    public Compute<T> recurse() {
        return sup.get();
    }
}