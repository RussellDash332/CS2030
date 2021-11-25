Logger<Integer> five = Logger.<Integer>of(5)
five.map(x -> x + 1)
five
five.map(x -> x + 1).map(x -> x - 1)
five.map(x -> x + 1).map(x -> x - 1).map(x -> x)
Logger.<String>of("hello").map(x -> x.length())
Logger.<String>of("hello").map(x -> x.length()).map(x -> x * 2)
Function<Object, Integer> f = x -> x.hashCode()
Logger.<String>of("hello").map(f) 
Function<String, Integer> g = x -> x.length();
Logger<Number> lognum = Logger.<String>of("hello").map(g)
