Logger<Integer> five = Logger.<Integer>of(5)
Logger.<Integer>of(5).equals(five)
Logger.<Integer>of(5).map(x -> x).equals(five)
five.equals(five)
five.equals(5)
Function<Integer,Logger<Integer>> f = x -> Logger.of(x).map(y -> y + 2);
Function<Integer,Logger<Integer>> g = x -> Logger.of(x).map(y -> y * 2); 
Logger.of(5).flatMap(f).equals(f.apply(5)) // left identity 
five.flatMap(x -> Logger.of(x)).equals(five) // right identity  
five.flatMap(f).flatMap(g).equals(
    five.flatMap(x -> f.apply(x).flatMap(g)))
five.flatMap(f).flatMap(g).equals(
    five.flatMap(x -> f.apply(x).flatMap(g))) // associativity
