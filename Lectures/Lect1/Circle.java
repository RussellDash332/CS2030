class Circle {
    private final Point centre;   // Circle has a Point as the centre
    private final double radius;  // Circle has a radius

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    boolean contains(Point point) {
        return this.centre.distanceTo(point) < this.radius;
    }

    Circle setRadius(double newRadius) {
        return new Circle(this.centre, newRadius);
    }

    public String toString() {
        return "Circle centered at " + this.centre + " with radius " + this.radius;
    }
}
