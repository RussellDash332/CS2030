package cs2030.test;
public class Base {
    private void foo() { }
    protected void bar() { }
    void baz() { }
    public void qux() { }
    private void test() {
        this.foo();
        this.bar();
        this.baz();
        this.qux();
    }
}