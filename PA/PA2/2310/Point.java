class Point implements Stringable {
    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Str toStr() {
        return Str.of("(" + this.x + ", " + this.y + ")");
    }
}
