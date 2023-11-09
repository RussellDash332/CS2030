Pair<Integer,Integer> pairOf(int a, int b) {
    Pair<Integer,Integer> pair = Pair.of(a, b);
    System.out.println(pair + " evaluated");
    return pair;
}
Predicate<Pair<Integer, Integer>> pred = pair -> pair.first() == pair.second()
Function<Pair<Integer, Integer>, Integer> f = pair -> pair.first() * pair.first()
DnC<Pair<Integer,Integer>, Integer> dnc = DnC.of(pairOf(5, 7), pred, f, 
    pair -> {
        int a = pair.first();
        int b = pair.second();
        int mid = (a + b) / 2;
        return Pair.of(pairOf(a, mid), pairOf(mid + 1, b));
    })
BinaryOperator<Integer> bop = (x,y) -> x + y
dnc.solve(bop)
dnc = DnC.<Pair<Integer,Integer>, Integer>of(() -> pairOf(5, 7), pred, f, 
    pair -> {
        int a = pair.first();
        int b = pair.second();
        int mid = (a + b) / 2;
        return Pair.of(() -> pairOf(a, mid), () -> pairOf(mid + 1, b));
    })
BinaryOperator<Integer> bop = (x,y) -> x + y
dnc.solve(bop)