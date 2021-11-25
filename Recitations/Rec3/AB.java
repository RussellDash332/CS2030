class A {
    int x;
    
    A(int x) {
        this.x = x;
    }

    A method() {
        return new A(x);
    }

    void foo() { }
}

class B extends A {
    B(int x) {
        super(x);
    }
    
    @Override
    B method() {
        return new B(x);
    }
}