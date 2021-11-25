class Point {
    /*
     * Properties
     */
    private double x;
    private double y;

    /*
     * Constructor
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
     * Methods
     */
    double distanceTo(Point otherpoint) {
        double dispX = this.x - otherpoint.x;
        double dispY = this.y - otherpoint.y;
        return Math.sqrt(dispX * dispX + dispY * dispY);
    }

    Point move(double x, double y) {
        return new Point(x, y);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

