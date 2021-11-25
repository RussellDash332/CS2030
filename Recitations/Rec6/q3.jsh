import java.util.List;
class A {
    void foo(List<Integer> integerList) {}
    void foo(List<String> StringList) {}
}

class B<T> {
    T x;
    static T y;
}

class C<T> {
    static int b = 0;
    C() {
        this.b = this.b + 1;
    }

    public static void main(String[] args) {
        C<Integer> x = new C<Integer>();
        C<String> y = new C<String>();
        System.out.println(x.b);
        System.out.println(y.b);
    }
}