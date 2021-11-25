class X {
    private final int a;

    X(int a) {
        this.a = a;
    }
}

class Y extends X {
    Y() {
        super(1);
    }
}

class Z {
    X x;
    
    Z() {
        this.x = new X(2);
    }
}
