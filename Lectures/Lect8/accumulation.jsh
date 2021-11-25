String name() {
return Thread.currentThread().getName();
}

Stream.of(1, 2, 3, 4, 5).
parallel().
filter(x -> {
System.out.println("filter: " + x + " " + name());
return x % 2 == 1; }).
reduce(0,
(x, y) -> {
System.out.println("accumulate: " + x + " + " + y + " " + name());
return x + y; },
(x, y) -> {
System.out.println("combine: " + x + " + " + y + " " + name());
return x + y; })

Stream.of(1, 2, 3, 4, 5).
parallel().
filter(x -> {
System.out.println("filter: " + x + " " + name());
return x % 2 == 1; }).
reduce(1,
(x, y) -> {
System.out.println("accumulate: " + x + " + " + y + " " + name());
return x + y; },
(x, y) -> {
System.out.println("combine: " + x + " + " + y + " " + name());
return x + y - 1; })

Stream.of(1, 2, 3, 4, 5).
filter(x -> {
System.out.println("filter: " + x + " " + name());
return x % 2 == 1; }).
reduce(1,
(x, y) -> {
System.out.println("accumulate: " + x + " + " + y + " " + name());
return x + y; },
(x, y) -> {
System.out.println("combine: " + x + " + " + y + " " + name());
return x + y - 1; })
/exit
