interface I {
    void baz(P p);
    void baz(I i);
}

class P implements I {
    public void baz(P p) { System.out.println(1); }
    public void baz(I i) { System.out.println(2); }
}

class Q extends P implements I {
    public void baz(P p) { System.out.println(3); }
    public void baz(I i) { System.out.println(4); }
    public void baz(Q q) { System.out.println(5); }
}

P p = new P();
P pq = new Q();
Q q = new Q();
I i = q;
q.baz(q);   // 5
q.baz(pq);  // 3
p.baz(p);   // 1
i.baz(q);   // 3
