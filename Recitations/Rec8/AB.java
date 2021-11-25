abstract class A {
    abstract void g();
}

class B {
    int x = 1;

    void f() {
        int y = 2;

        A a = new A() {
            void g() {
                x = y;
            }
        };

        a.g();
    }
}

