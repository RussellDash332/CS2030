import java.util.stream.IntStream;
import java.util.stream.LongStream;

boolean isPrime(int n) {
    return n > 1 && IntStream
        .range(2, n)
        .noneMatch(x -> n%x == 0);
}

IntStream factors(int x) {
    return IntStream
        .rangeClosed(1, x)
        .filter(d -> x % d == 0);
}

IntStream primeFactorsOf(int x) {
    return factors(x)
        .filter(d -> isPrime(d));
}

LongStream omega(int n) {
    return IntStream
        .rangeClosed(1, n)
        .mapToLong(x -> primeFactorsOf(x).count());
}

omega(10).forEach(System.out::println)
