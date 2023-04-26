/open SecondBest.java

// map method here

new SecondBest<Integer>(1, 2, (x, y) -> x - y).map(x -> x % 2, (x, y) -> x - y) // 0
new SecondBest<String>("hi", "five", (x, y) -> x.compareTo(y)).map(x -> x.length(), (x, y) -> x - y) // 2