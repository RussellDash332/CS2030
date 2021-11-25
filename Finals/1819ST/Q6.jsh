class A {
    public void f(int x) {
        System.out.println("A");
    }
}

class B extends A {
    public void f(double x) {
        System.out.println("B");
    }
}

class C extends B {
    public void f(int y) {
        System.out.println("C");
    }
}