<T> void replace(List<? extends T> src, List<T> dst, BiFunction<T,T,Boolean> pred) {
    if (src.size() == dst.size()) {
        for (int i = 0; i < src.size(); i++) {
            if (pred.apply(src.get(i), dst.get(i))) {
                dst.set(i, src.get(i));
            }
        }
    }
}

List<Integer> destination = new ArrayList<>(List.of(1,2,3));
replace(new ArrayList<>(List.of(9,9,9)), destination, (x,y) -> x > y);
System.out.println(destination);

class A {
    int x;
    
    A(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "[" + this.x + "]";
    }
}

class B extends A {
    B(int x) {
        super(x);
    }
}

List<A> destination = new ArrayList<>(List.of(new B(1), new A(2), new B(3)));
replace(new ArrayList<>(List.of(new A(9), new B(9), new B(-1))), destination, (a,b) -> a.x > b.x);
System.out.println(destination);

/exit