InfiniteList<Integer> list
InfiniteList.generate(() -> 1) instanceof InfiniteListImpl
InfiniteList.iterate(1, x -> x + 1) instanceof InfiniteListImpl
list = InfiniteListImpl.generate(() -> 1).peek()
list = InfiniteListImpl.iterate(1, x -> x + 1).peek()
list = InfiniteListImpl.iterate(1, x -> x + 1).peek().peek()
InfiniteList<Integer> list2 = list.peek()
list != list2
InfiniteList<String> list = InfiniteListImpl.iterate("A", x -> x + "Z").peek().peek().peek()
UnaryOperator<Integer> op = x -> { System.out.printf("iterate: %d -> %d\n", x, x + 1); return x + 1; };
list2 = InfiniteList.iterate(1, op).peek().peek()
/exit