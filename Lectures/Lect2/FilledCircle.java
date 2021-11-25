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
