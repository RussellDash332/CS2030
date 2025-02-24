import java.util.function.Supplier;

class Terrapin implements Movable<Terrapin> {
    private int x;
    private int y;
    private int orientation;

    Terrapin() {
        this.x = 0;
        this.y = 0;
        this.orientation = 0;
        this.show();
    }

    public void moveForward(int step) {
        if (orientation == 0) {
            this.x = this.x + step;
        } else if (orientation == 1) {
            this.y = this.y - step;
        } else if (orientation == 2) {
            this.x = this.x - step;
        } else if (orientation == 3) {
            this.y = this.y + step;
        }
        this.show();
    }

    public void turnLeft(int numRightAngles) { 
        this.orientation = ((orientation + numRightAngles) % 4 + 4) % 4;
        this.show();
    }

    void show() {
        System.out.println(this + 
                " @ (" + this.x + ", " + this.y + 
                ") faces " + this.orientation);
    }

    public boolean equals(Supplier<Terrapin> supplier) {
        int orientation = this.orientation;
        int x = this.x;
        int y = this.y;
        Terrapin t = supplier.get();
        return orientation == t.orientation &&
            x == t.x && y == t.y;
    }

    public String toString() {
        return "Terrapin";
    }
}
