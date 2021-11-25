class Gen<T> {
    private Object[] elems;
    private int idx;
    
    public Gen() {
        elems = new Object[100];
    }

    public void add(T elems) {
        this.elems[idx] = elems; // resolves attribute reference
        idx = idx + 1;
    }

    public void add2(Object obj) { // resolves type erasure
        elems[idx] = obj;
    }
}