Rand.of(2030).next().map(x -> x % 2 == 0).next().stream().
   limit(5).
   forEach(x -> System.out.print(x + " "))
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y))).get()
Rand.of(2030).
   flatMap(x -> Rand.of(x).map(y -> List.of(x,y)).next()).
   stream().limit(5).forEach(x -> System.out.println(x))
Stream<Integer> ints = Rand.of(2030).
   flatMap(x -> {
       System.out.println("ouch!");
       return Rand.of(x).map(y -> {
           System.out.println("aiyo!");
           return y + 1; }); }).
   stream().limit(5)
ints.forEach(x -> System.out.println(x))
Rand.of(20302040).flatMap(x -> Rand.of(x).map(y -> y % 1000)).get()
Rand.of(20302040).map(x -> x % 1000).flatMap(x -> Rand.of(x)).get()
Rand.of(20302040).next().flatMap(x -> Rand.of(x).map(y -> y % 1000)).get()
Rand.of(20302040).next().map(x -> x % 1000).flatMap(x -> Rand.of(x)).get()
Rand.of(20302040).map(x -> x % 1000).next().flatMap(x -> Rand.of(x)).get()
Rand.of(20302040).map(x -> x % 1000).flatMap(x -> Rand.of(x).next()).get()
/exit