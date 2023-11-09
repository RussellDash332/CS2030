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
dnc.peek(x -> System.out.println(x))
dnc.left().peek(x -> System.out.println(x))
dnc.left().left().peek(x -> System.out.println(x))
dnc.left().left().left().peek(x -> System.out.println(x))
dnc.peek(x -> System.out.println(x))
dnc.right().peek(x -> System.out.println(x))
dnc.right().right().peek(x -> System.out.println(x))
dnc.left() instanceof DnC
dnc.right() instanceof DnC
dnc.solve()
dnc.left().solve()
dnc.left().left().solve()
dnc.right().solve()
dnc.right().right().solve()