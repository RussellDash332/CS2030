class Quad<T> extends Pair<Pair<T>> {
    @SuppressWarnings("unchecked")
    Quad(T a, T b, T c, T d) {
        super(new Pair(a, b), new Pair(c, d));
    }

    T getLL() {
        return super.getL().getL();
    }

    T getLR() {
        return super.getL().getR();
    }

    T getRL() {
        return super.getR().getL();
    }

    T getRR() {
        return super.getR().getR();
    }
}