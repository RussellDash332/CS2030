Aggregate.<Integer,Circle>seed(0)
Aggregate.<Integer,Circle>seed(10)
Aggregate.<Integer,Circle>seed(1).map(x -> x * 2, new Circle(2.0))
Count<String> count = Count.<String>of("one").map("two").map("three")
Aggregate<Integer,String> agg = count.map("four")
count
Aggregate.<Integer,Circle>seed(0).map(x -> x + 1, new Circle(1.0)).map(x -> x + 2, new Circle(2.0))
Aggregate.<Double,Circle>seed(0.0).map(x -> x + 1.0, new Circle(1.0)).map(x -> x + 2.0, new Circle(2.0))
