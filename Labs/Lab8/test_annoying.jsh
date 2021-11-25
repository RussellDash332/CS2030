Logger.<String>of("hello").map(x -> {System.out.println("Hello!"); return x.length();}).map(x -> {System.out.println("Hello!"); return x + 3;})
Logger<Integer> five = Logger.<Integer>of(5)
five.map(x -> x + 1).
    test(x -> x == 5,
        five.map(x -> { System.out.println("add 1"); return x + 1; }),
        five.map(x -> { System.out.println("sub 1"); return x - 1; }))
