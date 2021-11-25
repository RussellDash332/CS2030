import java.awt.Color;

class A {
    Circle foo() {
        return new Circle(1.0, Color.BLUE);
    }
}

class B extends A {
    @Override
    Circle foo() {
        return new Circle(2.0, Color.BLUE);
    }
}