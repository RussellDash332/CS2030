class Pair<T> { 
    private T l; 
    private T r;
    
    public Pair(T l, T r) { 
        this.l = l;
        this.r = r;
    }
    
    public T getL() { return this.l; } 
    
    public T getR() { return this.r; } 
    
    public String toString() {
        return "<" + this.l + "," + this.r + ">";
    }
}