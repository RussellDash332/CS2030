Circle c = new Circle(2.0)
Aggregate.<Double,Circle>seed(0.0).map(x -> x + 1.0, new Circle(1.0)).map(x -> x + c.getRadius(), c)
Aggregate.<Double,Circle>seed(0.0).map(x -> x + 1.0, new Circle(1.0)).map(x -> {
    Circle c = new Circle(2.0);  // Circle c is now within the lambda
    return Pair.<Double,Circle>of(x + c.getRadius(), c);
})
Pair.<Integer,String>of(1, "one")
Aggregate.<Double,Circle>seed(0.0).map(x -> x + 1.0, new Circle(1.0)).map(x -> Pair.<Double,Circle>of(x + 2.0, new Circle(2.0)))
Aggregate.<Double,Circle>seed(0.0).map(x -> x + 1.0, new Circle(1.0)).map(x -> {
    Circle c = new Circle(2.0); 
    return Pair.<Double,Circle>of(x + c.getRadius(), c);
})
Count<String> count = Count.<String>of("one").map("two").map("three")
Aggregate<Integer,String> agg = count.map("four").map(x -> Pair.<Integer,String>of(x + 1, "five"))
count
