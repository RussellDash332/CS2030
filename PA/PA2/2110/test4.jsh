Rand.of(2030).map(x -> x / 2).get() == 1015
Rand.of(2030).map(x -> x / 2).next().get() == 663867150
Rand.of(2030).flatMap(x -> Rand.of(x).map(y -> y / 2)).get() == 1015
Rand.of(2030).flatMap(x -> Rand.of(x).map(y -> y / 2)).next().get() == 663867150
Rand.of(2030).map(x -> x / 2).next().
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).next().flatMap(x -> Rand.of(x).map(y -> y / 2)).
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).flatMap(x -> Rand.of(x).next().map(y -> y / 2)).
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).flatMap(x -> Rand.of(x).map(y -> y / 2).next()).
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).flatMap(x -> Rand.of(x).map(y -> y / 2)).next().
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y))) instanceof Rand == true
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y))).get()
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y))).next().get()
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y))).
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y)).next()).
   get()
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y)).next()).
   next().
   get()
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y)).next()).
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).
   flatMap(x -> Rand.of(1010).map(y -> List.of(x,y))).
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).
   flatMap(x -> Rand.of(1010).map(y -> List.of(x,y)).next()).
   stream().limit(5).forEach(x -> System.out.println(x))
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.<Number>of(x, (y % 10) / 2.0))).
   stream().limit(5).forEach(x -> System.out.println(x))
Stream<Integer> ints = Rand.of(2030).
   flatMap(x -> {
       System.out.println("ouch!");
       return Rand.of(x); }).
   stream().limit(5)
ints.forEach(x -> {})
ints = Rand.of(2030).
   flatMap(x -> {
       System.out.println("ouch!");
       return Rand.of(x).map(y -> {
           System.out.println("aiyo!");
           return y + 1; }); }).
   stream().limit(5)
ints.forEach(x -> System.out.println(x))
/exit