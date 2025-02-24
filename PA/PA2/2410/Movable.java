import java.util.function.Supplier;

interface Movable<T> {
    public void turnLeft(int theta);
    public void moveForward(int step);
    public boolean equals(Supplier<T> supplier);
}
