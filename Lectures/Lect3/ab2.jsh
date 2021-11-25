class Circle {
    protected final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public String toString() {
        return "area " + String.format("%.2f", this.getArea()) +
            ", perimeter " + String.format("%.2f", this.getPerimeter());
    }
}
import java.awt.Color;
class FilledCircle extends Circle {
    private final Color color;

    FilledCircle(double radius, Color color) {
        super(radius);
        this.color = color;
    }

    FilledCircle fillColor(Color color) {
        return new FilledCircle(super.radius, color); // access radius?
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.color;
    }
}
class A {
    Circle foo() {
        return new Circle(1.0);
    }
}
class B extends A {
    @Override
    FilledCircle foo() {
        return new FilledCircle(1.0, java.awt.Color.BLUE);
    }
}
