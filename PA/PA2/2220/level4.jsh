Pair<Integer,Integer> p = Pair.of(5, 7)
Predicate<Pair<Integer, Integer>> pred = pair -> pair.first() == pair.second()
Function<Pair<Integer, Integer>, Integer> f = pair -> pair.first() * pair.first()
DnC<Pair<Integer,Integer>, Integer> dnc = DnC.of(p, pred, f, 
    pair -> {
        int a = pair.first();
        int b = pair.second();
        int mid = (a + b) / 2;
        return Pair.of(Pair.of(a, mid), Pair.of(mid + 1, b));
    })
BinaryOperator<Integer> bop = (x,y) -> x + y
dnc.solve()
dnc.solve(bop)
dnc.left().solve(bop) // 5*5 + 6*6
dnc.left().left().solve(bop) // the trivial solution 5*5