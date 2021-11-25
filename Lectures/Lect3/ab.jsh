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
class A {
    void foo(Object obj) { System.out.println("one"); }
    void foo(Circle c) { System.out.println("two"); }
}
class B extends A {
    void foo(Object obj) { System.out.println("three"); }
    void foo(Circle c) { System.out.println("four"); }
}