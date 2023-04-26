class Pair<T,U> {
    private final T t;
    private final U u;

    Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    T first() {
        return this.t;
    }

    U second() {
        return this.u;
    }

    @Override
    public String toString() {
        return "(" + this.t + ", " + this.u + ")";
    }
}

Stream<Pair<Integer,String>> foo(List<Pair<Integer,String>> list) {
    return list.stream().
        filter(x -> x.first() % 2 == 0);
}

Scanner sc = new Scanner(System.in)
List<Pair<Integer,String>> list = IntStream.range(1, 10).
    mapToObj(x -> new Pair<Integer, String>(x, sc.next())).
    collect(Collectors.toList())
foo(list).forEach(System.out::println)

// Modify foo here
// ...

Scanner sc = new Scanner(System.in)
List<Pair<Integer,Supplier<String>>> list =
    IntStream.range(1, 10).
    mapToObj(x ->
        new Pair<Integer, Supplier<String>>(x, () -> sc.next())).
    collect(Collectors.toList())
foo(list, x -> x % 2 == 0).forEach(System.out::println)