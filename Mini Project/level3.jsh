InfiniteList<Integer> list, list2
list = InfiniteList.generate(() -> 1).map(x -> x * 2)
list2 = list.peek()
list2 = list.peek()
InfiniteList.generate(() -> 1).map(x -> x * 2) instanceof InfiniteListImpl
list = InfiniteList.generate(() -> 1).map(x -> x * 2).peek()
list = InfiniteList.generate(() -> 1).map(x -> x * 2).peek().peek()
list = InfiniteList.iterate(1, x -> x + 1).map(x -> x * 2).peek().peek()
Supplier<Integer> generator = () -> { System.out.println("generate: 1"); return 1; }
Function<Integer,Integer> doubler = x -> { System.out.printf("map: %d -> %d\n", x, x * 2); return x * 2; };
Function<Integer,Integer> oneLess = x -> { System.out.printf("map: %d -> %d\n", x, x - 1); return x - 1; };
list = InfiniteList.generate(generator).map(doubler).peek().peek()
list = InfiniteList.generate(generator).map(doubler).map(oneLess).peek().peek()
list = InfiniteList.iterate(1, x -> x + 1).filter(x -> x % 2 == 0)
list2 = list.peek()
list2 = list.peek()
InfiniteList.iterate(1, x -> x + 1).filter(x -> x % 2 == 0) instanceof InfiniteListImpl
list = InfiniteList.iterate(1, x -> x + 1).filter(x -> x % 2 == 0).peek().peek()
list = InfiniteList.iterate(1, x -> x + 1).filter(x -> x % 2 == 0).filter(x -> x < 4).peek().peek().peek().peek()
Predicate<Integer> isEven = x -> { System.out.printf("filter: %d -> %b\n", x, x % 2 == 0); return x % 2 == 0; }
Predicate<Integer> lessThan10 = x -> { System.out.printf("filter: %d -> %b\n", x, x < 10); return x < 10; }
UnaryOperator<Integer> op = x -> { System.out.printf("iterate: %d -> %d\n", x, x + 1); return x + 1; };
list = InfiniteList.iterate(1, op).filter(isEven).peek().peek()
list = InfiniteList.iterate(1, op).filter(isEven).filter(lessThan10).peek().peek()
list = InfiniteList.iterate(1, op).map(doubler).filter(isEven).filter(lessThan10).peek().peek()
list = InfiniteList.iterate(1, op).filter(isEven).map(doubler).filter(lessThan10).peek().peek()
list = InfiniteList.iterate(1, op).filter(isEven).filter(lessThan10).map(doubler).peek().peek()
/exit