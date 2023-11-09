Pair<Integer,Integer> p = Pair.of(5, 5) // (a, b)
Predicate<Pair<Integer, Integer>> pred = pair -> pair.first() == pair.second() // atomic if a == b
Function<Pair<Integer, Integer>, Integer> f = pair -> pair.first() * pair.first() // trivial solution a*a
DnC<Pair<Integer,Integer>, Integer> dnc = DnC.of(p, pred, f)
dnc.peek(x -> System.out.println(x))
p = Pair.of(5, 7)
dnc = DnC.of(p, pred, f)
dnc.peek(x -> System.out.println(x))
DnC.of(List.of(1), list -> list.size() == 1, list -> list.get(0)).peek(x -> System.out.println(x))
DnC.of(List.of(1, 2, 3), list -> list.size() == 1, list -> list.get(0)).peek(x -> System.out.println(x))