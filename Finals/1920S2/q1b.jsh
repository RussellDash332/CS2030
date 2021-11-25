interface I1 {
    void bar(X x);
    void bar(I1 i);
}
interface I2 {
    void bar(Y y);
}

class X implements I1 {
    public void bar(X x) { System.out.println(1); }
    public void bar(I1 i) { System.out.println(2); }
}

class Y extends X implements I1, I2 {
    public void bar(X x) { System.out.println(3); }
    public void bar(I1 i) { System.out.println(4); }
    public void bar(Y y) { System.out.println(5); }
}

X x = new X();
X xy = new Y();
Y y = new Y();
I1 i = new Y();
i.bar(y);   // 3
x.bar(y);   // 1
y.bar(xy);  // 3
x.bar(x);   // 1
