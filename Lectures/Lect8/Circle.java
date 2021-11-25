class Circle {
    private final Point centre;
    private final double radius;

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    double centreDistanceTo(Point p) {
        return this.centre.distanceTo(p);
    }

    boolean contains(Point p) {
        return this.centreDistanceTo(p) <= this.radius;
    }

    @Override
    public String toString() {
        return "circle of radius " + radius + " centered at " + centre;
    }
}
