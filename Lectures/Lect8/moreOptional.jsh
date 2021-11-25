Optional.<Integer>of(1)
Optional.<Integer>ofNullable(null)
Optional.<Integer>empty()
Optional.<Integer>of(1).filter(x -> x % 2 == 0)
Optional.<Integer>of(1).filter(x -> x % 2 == 0).ifPresent(x -> System.out.println(x))
Optional.<Integer>of(1).filter(x -> x % 2 == 1).ifPresent(x -> System.out.println(x))
Optional.<Integer>of(1).filter(x -> x % 2 == 0).map(x -> x * 2)
Optional.<Integer>of(1).filter(x -> x % 2 == 1).map(x -> x * 2)
Optional.<Integer>of(1).filter(x -> x % 2 == 0).or(() -> Optional.of(2))
Optional.<Integer>of(1).filter(x -> x % 2 == 0).orElse(2)
Optional.<Integer>of(1).filter(x -> x % 2 == 1).orElse(2)
int foo() { System.out.println(2); return 2; }
Optional.<Integer>of(1).filter(x -> x % 2 == 1).orElse(foo())
/exit