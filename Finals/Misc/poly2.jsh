abstract class A {}
class B extends A {}
class C extends B {}

A a = new C(); // Yes
C c = new A(); // A is abstract
C c = new B(); // Cannot convert B to C
A c = new B(); // Yes
A c = new C(); // Yes
B c = new C(); // Yes

// a is now a C instance with CTT of type A
// c is now a C instance with CTT of type B
// All below are OK
(A) c
(B) c
(C) c
(A) a
(B) a
(C) a

A ab = new B();
A x = (C) a; // OK
B x = (C) a; // OK
C x = (C) a; // OK
A x = (C) ab; // CCE
B x = (C) ab; // CCE
C x = (C) ab; // CCE
B x = (B) ab; // OK
B x = (A) ab; // Error
A x = (B) ab; // OK
A x = (A) ab; // OK

/exit