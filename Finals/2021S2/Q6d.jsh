/open SecondBest.java

// flip method here

new SecondBest<Integer>(1, 2, (x, y) -> x - y).flip() // 2
new SecondBest<Integer>(1, 2, (x, y) -> x - y).flip().add(3) // 2
new SecondBest<Integer>(1, 2, (x, y) -> x - y).flip().add(3).add(4) // 2