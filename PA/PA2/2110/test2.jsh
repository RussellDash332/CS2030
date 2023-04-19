Rand.of(2030).
   stream().
   limit(5).
   forEach(x -> System.out.println(x))
Rand.of(2030).
   next().
   stream().
   limit(5).
   forEach(x -> System.out.println(x))
Function<Integer,Integer> f = x -> x % 10
Rand.randRange(2030, f).
   limit(20).
   forEach(x -> System.out.print(x + " "))
/exit