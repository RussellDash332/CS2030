interface I {
    void baz(P p);
    void baz(I i);
}

class P implements I {
    public void baz(P p) { System.out.println("Class P baz P"); }
    public void baz(I i) { System.out.println("Class P baz I"); }
}

class Q extends P implements I {
    public void baz(P p) { System.out.println("Class Q baz P"); }
    public void baz(I i) { System.out.println("Class Q baz I"); }
    public void baz(Q q) { System.out.println("Class Q baz Q"); }
}

P p = new P();
Q q = new Q();
P pq = new Q();
Q qp = new P(); // no!
P qp = (P) new Q();
I i = q;
I i2 = p;
I i3 = pq;

System.out.println("P p = new P();");
p.baz(p);   // P P
p.baz(q);   // P P
p.baz(pq);  // P P
p.baz(qp);  // P P
p.baz(i);   // P I
p.baz(i2);  // P I
p.baz(i3);  // P I
System.out.println("\nQ q = new Q();");
q.baz(p);   // Q P
q.baz(q);   // Q Q
q.baz(pq);  // Q P
q.baz(qp);  // Q P
q.baz(i);   // Q I
q.baz(i2);  // Q I
q.baz(i3);  // Q I
System.out.println("\nP pq = new Q();");
pq.baz(p);  // Q P
pq.baz(q);  // Q P, fun stuff
pq.baz(pq); // Q P
pq.baz(qp); // Q P
pq.baz(i);  // Q I
pq.baz(i2); // Q I
pq.baz(i3); // Q I
System.out.println("\nP qp = (P) new Q();");
qp.baz(p);  // everything same as pq case
qp.baz(q);
qp.baz(pq);
qp.baz(qp);
qp.baz(i);
qp.baz(i2);
qp.baz(i3);
System.out.println("\nWeird things now");
q.baz((P) q);   // Q P
q.baz((I) q);   // Q I
q.baz((Q) i);   // Q Q
q.baz((Q) i2);  // ClassCastException because i2 is a P instance
q.baz((Q) i3);  // Q Q
q.baz((P) i);   // Q P
q.baz((P) i2);  // Q P
q.baz((P) i3);  // Q P
q.baz((P) pq);  // Q P
q.baz((Q) pq);  // Q Q
q.baz((I) pq);  // Q I
q.baz((P) qp);  // Q P
q.baz((Q) qp);  // Q Q
q.baz((I) qp);  // Q I

P q_to_p = (P) new Q(); // Yes
Q p_to_q = (Q) new P(); // CCE
I p_to_i = (I) new P(); // Yes
I q_to_i = (I) new Q(); // Yes