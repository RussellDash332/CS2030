class Circle {
    private final Point centre;
    private final double radius;
    private static final double EPSILON = 1e-15;
    private static int numOfCircles = 0;

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
        Circle.numOfCircles = Circle.numOfCircles + 1;
    }

    static int getNumOfCircles() {
        return Circle.numOfCircles;
    }

    static Circle createUnitCircle(Point p, Point q) {
        return new Circle(Point.midPoint(p, q), 1.0);
    }

    boolean contains(Point p) {
        return this.centre.distanceTo(p) < this.radius;
    }

    @Override
    public String toString() {
        return "Circle centered at " + this.centre + " with radius " + this.radius;
    }
}