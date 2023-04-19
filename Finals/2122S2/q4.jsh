boolean isLeap(int year) {
    if (year % 4 == 0) {
        return true;
    } else {
        return false;
    }
}

IfElse<Integer, Boolean> div4 = IfElse.
    of(x -> x % 4 == 0, x -> true, x -> false)
div4.apply(2022)

IfElse<Integer, Boolean> not100 = IfElse.
    of(x -> x % 100 != 0, x -> true, x -> false)
not100.apply(1900)

IfElse<Integer, Boolean> div4Not100 = div4.mapIf(not100)
div4Not100.apply(2022)
div4Not100.apply(2024)
div4Not100.apply(1900)

IfElse<Integer, Boolean> div400 = IfElse.
    of(x -> x % 400 == 0, x -> true, x -> false)
div400.apply(2000)

IfElse<Integer, Boolean> leap = div400.mapElse(div4Not100)
leap.apply(2022)
leap.apply(2024)
leap.apply(1900)
leap.apply(2000)

Function<Boolean, String> f = x -> x ? "Leap" : "Not leap"
leap.map(f).apply(2022)
leap.map(f).apply(2024)
leap.map(f).apply(1900)
leap.map(f).apply(2000)

Function<Integer, IfElse<Integer, Integer>> g = x -> IfElse.
    of(y -> x % 2 == 0, y -> y + 2, y -> y * 2)

IfElse.<String, Integer>of(x -> x.compareTo("cs2030") > 0,
    x -> x.length(), x -> 0).flatMap(g).apply("CS2030S")