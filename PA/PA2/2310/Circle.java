class Circle implements Stringable {
    private final Point centre;
    private final double radius;

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public Str toStr() {
        return Str.of("Circle at centre ")
            .join(this.centre.toStr())
            .join(" with radius " + this.radius);
    }
}
