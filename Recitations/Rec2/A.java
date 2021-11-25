class A1 {
    void f(int x) {}
    void f(boolean y) {}
}
class A2 {
    void f(int x) {}
    void f(int y) {}
}
class A3 {
    private void f(int x) {}
    void f(int y) {}
}
class A4 {
    int f(int x) {
        return x;
    }

    long f(int x) { return 1; }
    // void f(int y) {}

    public static void main(String[] args) {
        long a = new A4().f(1);
        // new A4().f(1);
    }
}
class A5 {
    void f(int x, String s) {}
    void f(String s, int y) {}
}
