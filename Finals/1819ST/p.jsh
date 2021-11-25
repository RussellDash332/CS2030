class A {} 
class B {}
class C extends B {} 
class D extends B {} 
class E extends C {} 
class F extends E {}
class P<T extends C> {}

P<? super F> p;
p = new P<C>();
p = new P<E>();
p = new P<F>();