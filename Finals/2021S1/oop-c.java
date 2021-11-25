import java.util.function.Supplier;

abstract class Base {
    private final Supplier<Base> other;

    protected Base(Supplier<Base> other) {
        this.other = other;
    }

    abstract Base set(Base other);
    abstract Base set(Supplier<Base> other);

    Base get() {
        return other.get();
    }
}

class A extends Base {
    public A() {
        super(() -> null);
    }

    private A(Supplier<Base> other) {
        super(other);
    }

    @Override
    A set(Base other) {
        return new A(() -> other);
    }

    @Override
    A set(Supplier<Base> other) {
        return new A(other);
    }
}

class B extends Base {
    public B() {
        super(() -> null);
    }

    private B(Supplier<Base> other) {
        super(other);
    }

    @Override
    B set(Base other) {
        return new B(() -> other);
    }

    @Override
    B set(Supplier<Base> other) {
        return new B(other);
    }
}