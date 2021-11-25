// myCount(Stream.of("abc", "xyz")) returns 2;
// myCount(Stream.of()) returns 0;

<T> long myCount(Stream<T> stream) {
    return stream.map(x -> 1).reduce(0, (x, y) -> x + y);
}

long countRepeats(String str) {
    return IntStream
        .range(1, str.length())
        .filter(x -> str.charAt(x - 1) == str.charAt(x) && (x == str.length() - 1 || str.charAt(x + 1) != str.charAt(x)))
        .count();
}

// variance(IntStream.rangeClosed(1,6).toArray())
// variance(IntStream.of().toArray())
OptionalDouble variance(int[] data) {
    double average = (double) Arrays.stream(data).sum() / data.length;
    Function<Integer,Double> sq = x -> (x - average) * (x - average);
    double[] nums = new double[1];
    nums[0] = 0;
    IntStream.rangeClosed(1, data.length).forEach(x -> {nums[0] += sq.apply(x);});
    if (data.length >= 2) {
        return OptionalDouble.of(nums[0] / (data.length - 1));
    } else {
        return OptionalDouble.empty();
    }
}

String reverse(String s) {
    return s.chars().parallel().mapToObj(x -> String.valueOf((char) x)).reduce("", (x,y) -> y+x);
}