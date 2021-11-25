class Circle {
    private static int numOfCircles = 0;
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
        numOfCircles = numOfCircles + 1;
    }

    double getRadius() {
        return this.radius;
    }

    static int getNumOfCircles() {
        return Circle.numOfCircles;
    }

    @Override
    public String toString() {
        return "Circle of radius " + this.radius;
    }
}