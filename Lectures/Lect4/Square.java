class Square implements Shape, Scalable { // multiple implementation
    private final double side;
    
    Square(double side) {
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return this.side * this.side;
    }
    
    @Override
    public double getPerimeter() {
        return 4.0 * this.side;
    }
    
    @Override
    public Square scale(double factor) {
        return new Square(this.side * factor);
    }
    
    public String toString() {
        return "Area " + String.format("%.2f", getArea()) +
            " and perimeter " + String.format("%.2f", getPerimeter());
    }
}