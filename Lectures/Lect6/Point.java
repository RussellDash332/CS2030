class Point {
    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point otherpoint) {
        double dispX = this.x - otherpoint.x;
        double dispY = this.y - otherpoint.y;
        return Math.sqrt(dispX * dispX + dispY * dispY);
    }

    static Point midPoint(Point p, Point q) {
        return new Point((p.x + q.x) / 2.0, (p.y + q.y) / 2.0);
    }

    Point move(double x, double y) {
        return new Point(x, y);
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

