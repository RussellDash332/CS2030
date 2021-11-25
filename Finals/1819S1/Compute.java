interface Compute<T> {
    T eval();

    boolean isRecursive();

    Compute<T> recurse();
}