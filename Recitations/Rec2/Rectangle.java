class Rectangle {
    protected final double height;
    protected final double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    double getArea() {
        return this.height * this.width;
    }

    Rectangle scaleHeight(double factor) {
        return new Rectangle(this.height * factor, this.width);
    }

    Rectangle scaleWidth(double factor) {
        return new Rectangle(this.height, this.width * factor);
    }

    @Override
    public String toString() {
        return "Rectangle: " + this.height + " x " + this.width;
    }
}

class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }

    @Override
    Square scaleHeight(double factor) {
        return new Square(super.height * factor);
    }

    @Override
    Square scaleWidth(double factor) {
        return new Square(super.width * factor);
    }

    @Override
    public String toString() {
        return "Square: " + super.height + " x " + super.width;
    }
}
