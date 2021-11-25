class Circle {
    Point centre;

    public Circle(Point centre) {
        this.centre = centre;
    }

    @Override
    public String toString() {
        return "Circle: " + centre;
    }
}