/open CachedString.java
new CachedString(() -> "Hello").map(x -> x + " ").flatMap(x -> new CachedString(() -> x + "There")).flatMap(x -> new CachedString(() -> x.replaceAll("e","3"))).get()
new CachedString(() -> "2345432").map(x -> x + "4321").flatMap(x -> new CachedString(() -> x.substring(0,7))).forEach(x -> System.out.println("Answer: " + x))
new CachedString(() -> "2345432").map(x -> x + "4321").flatMap(x -> new CachedString(() -> x.substring(1,8))).forEach(x -> System.out.println("Answer: " + x))
new CachedString(() -> "Testing").map(x -> "").isEmpty()
/exit