Rand.of(2030).map(x -> x - 1).get() == 2029
Rand.of(2030).next().map(x -> x - 1).get() == 1327734300
Rand.of(2030).map(x -> x - 1).next().get() == 1327734300
Rand.of(2030).next().map(x -> x - 1).next().get() == 1503777124
Rand.of(2030).map(x -> x - 1).stream().
   limit(5).
   forEach(x -> System.out.print(x % 10 + " "))
Rand.of(2030).next().map(x -> x - 1).stream().
   limit(5).
   forEach(x -> System.out.print(x % 10 + " "))
Rand.of(2030).map(x -> x - 1).next().stream().
   limit(5).
   forEach(x -> System.out.print(x % 10 + " "))
Rand.of(2030).next().map(x -> x - 1).next().stream().
   limit(5).
   forEach(x -> System.out.print(x % 10 + " "))
Rand.of(2030).next().map(x -> x % 2 == 0).next().stream().
   limit(5).
   forEach(x -> System.out.print(x + " ")) 
Rand.randRange(2030, x -> x % 10).
   limit(5).
   forEach(System.out::println)
Rand.randRange(2030, x -> String.format("[%02d]", x % 100)).
   limit(5).
   forEach(System.out::println)
double lo = -1.0
double hi = 1.0
Rand.
   randRange(2030, x -> (hi - lo) * x / (Integer.MAX_VALUE - 1) + lo).
   limit(10).
   forEach(System.out::println)
Rand.of(2030).
   next().
   map(x -> { System.out.println("ouch!"); return x; }).
   next()
Rand.of(2030).next().
   map(x -> { System.out.println("ouch!"); return x; }).
   next().
   get()
Stream<Integer> ints = Rand.randRange(2030, x -> {
   System.out.println("ouch!"); return x; }).
   limit(5)
ints.forEach(x -> System.out.println(x))
/exit