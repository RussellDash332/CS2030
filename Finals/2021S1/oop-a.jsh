class A {
    private A other;
    
    void set(A other) {
        this.other = other;
    }

    A get() {
        return this.other;
    }
}

A a1 = new A();
A a2 = new A();
a1.set(a2);
a2.set(a1);