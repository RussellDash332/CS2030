/open SecondBest.java

// flatMap method here

new SecondBest<String>("hi", "five", (x, y) -> x.compareTo(y)).
    flatMap((x,y) -> new SecondBest<Integer>(
        x.length(), y.length(), (p,q) -> p - q)) // 2
new SecondBest<String>("hi", "five", (x, y) -> x.compareTo(y)).
    flatMap((x,y) -> new SecondBest<Integer>(
        x.length(), 5 - y.length(), (p,q) -> p - q)) // 1