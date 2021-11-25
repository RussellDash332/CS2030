class Rectangle implements Shape, Scalable { // multiple implementation
    private final double width;
    private final double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return this.width * this.height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }
    
    @Override
    public Rectangle scale(double factor) {
        return new Rectangle(this.width * factor, this.height * factor);
    }
    
    public String toString() {
        return "Area " + String.format("%.2f", getArea()) +
            " and perimeter " + String.format("%.2f", getPerimeter());
    }
}