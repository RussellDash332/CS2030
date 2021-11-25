class X {
    protected int a;
}

class Y extends X {
    Y() {
        super.a = 1;
    }
}

class Z {
    X x;
    
    Z() {
        this.x = new X();
        this.x.a = 2;
    }
}
