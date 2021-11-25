class MinMax {
    final int min, max;
    
    public MinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    @Override
    public String toString() {
        return min + ", " + max;
    }
}