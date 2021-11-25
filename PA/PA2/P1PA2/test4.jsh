Aggregate.<Integer,String>seed(0).map(s -> Pair.of(s + 1, "one"))
Aggregate.<Integer,String>seed(0).map(s -> Pair.of(s + 1, "one")).
flatMap(t -> Aggregate.<Integer,String>of(s -> Pair.<Integer,String>of(s + 2, t + " two")))

Aggregate.<Integer,String>of(
    s -> Pair.<Integer,String>of(s + 2, "two"))

Aggregate.<Integer,String>seed(11).
flatMap(t -> Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, "two")))

Aggregate.<Integer,String>seed(11).
flatMap(t -> Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, "two"))).
map(s -> Pair.of(s + 1, "one"))

Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, "two")).
map(s -> Pair.of(s + 1, "one"))

Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, "two")).
map(s -> Pair.of(s + 1, "one")).
map(s -> Pair.of(s + 3, "three"))

Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, "two")).
map(s -> Pair.of(s + 1, "one")).
flatMap(t -> Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, t + " two")))

Aggregate.<Integer,String>seed(0).
map(s -> Pair.of(s + 1, "one"))

Aggregate.<Integer,String>seed(0).
map(s -> Pair.of(s + 1, "one")).
flatMap(t -> Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, t + " two")))

Aggregate.<Integer,String>seed(0).
map(s -> Pair.<Integer,String>of(s + 1, "one")).
flatMap(t -> Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, "two")))

Aggregate.<Integer,String>seed(0).
map(s -> Pair.<Integer,String>of(s + 1, "one")).
flatMap(t -> Aggregate.<Integer,String>of(
   s -> Pair.<Integer,String>of(s + 2, t + "two")))

Function<Integer, Pair<Integer,String>> doit(String s) {
    return x -> Pair.<Integer,String>of(x + s.length(), s);
}

Function<String, Aggregate<Integer,String>> doit2(String s) {
    return x -> Aggregate.<Integer,String>of(y -> {
        Pair<Integer,String> pair = doit(s).apply(y);
        return Pair.<Integer,String>of(
           pair.first(), x + " " + pair.second());
    });
}

Aggregate.<Integer,String>seed(0).
map(doit("one"));

Aggregate.<Integer,String>seed(0).
map(doit("one")).
flatMap(doit2("two")).
map(doit("three"))

Aggregate.<Integer,String>seed(0).
map(doit("one")).
flatMap(doit2("two")).
flatMap(doit2("three"))

Aggregate.<Integer,String>seed(10).
map(s -> Pair.of(s + 1, "one")).
flatMap(t -> Aggregate.<Integer,Integer>of(
   s -> Pair.<Integer,Integer>of(
      s + 2, t.length() + 5))).
flatMap(t -> Aggregate.<Integer,Circle>of(
   s -> Pair.<Integer,Circle>of(
      s + 3, new Circle(t))))
