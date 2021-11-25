class A {
    private int x;
    
    public A(int x) {
        this.x = x;
    }
    
    public A copy() {
        return new A(x);
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
}

class B {
    private int x;
    private A a;

    public B(int x, A a) {
        this.x = x;
        this.a = a;
    }

    public B copy() {
        return new B(x, a.copy()); // resolve Q8 copy issue
    }

    public void setX(int x) {
        this.x = x;
        this.a.setX(x);
    }
    
    public int getX() {
        return this.x + this.a.getX();
    }
}