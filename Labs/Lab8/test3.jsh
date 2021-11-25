Logger<Integer> five = Logger.<Integer>of(5)
five.flatMap(x -> Logger.of(x + 1))
five.map(x -> x + 2).map(x -> x * 10)
five.flatMap(x -> Logger.of(x).map(y -> y + 2)).
    flatMap(y -> Logger.of(y).map(z -> z * 10))
Logger.<Integer>of(5).
    flatMap(x -> Logger.of(x).
        map(y -> y + 2).
        flatMap(y -> Logger.of(y).map(z -> z * 10)))
Function<Object, Logger<Integer>> f = x -> Logger.<Object>of(x).map(y -> y.hashCode())
Logger.of("hello").flatMap(f)
Function<String, Logger<Integer>> g = x -> Logger.<String>of(x).map(y -> y.length())
Logger<Number> lognum = Logger.<String>of("hello").flatMap(g)
