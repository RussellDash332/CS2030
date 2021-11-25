class Circle implements Shape, Scalable { // multiple implementation
    private final double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
    
    @Override
    public Circle scale(double factor) {
        return new Circle(this.radius * factor);
    }
    
    public String toString() {
        return "Area " + String.format("%.2f", getArea()) +
            " and perimeter " + String.format("%.2f", getPerimeter());
    }
}