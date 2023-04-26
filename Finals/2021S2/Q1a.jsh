class A {
    private int x;

    A(int x) {
        this.x = x;
    }

    // skipping many other methods here...

    @Override
    public String toString() {
        return "[" + this.x + "]";
    }
}

void client(A a1) {
    A a2 = a1.set(20);
    System.out.println("a2: " + a2);
    System.out.println("a1: " + a1);
    A a3 = a2.set(30);
    System.out.println("a3: " + a3);
    System.out.println("a2: " + a2);
    System.out.println("a1: " + a1);
}

client(new A(10))