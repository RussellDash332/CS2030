import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Scanner;
import java.util.Optional;

class Main3 {
    public static void main(String[] args) {
        System.out.print("From range: ");
        int from = (new Scanner(System.in)).nextInt();
        System.out.print("To range: ");
        int to = (new Scanner(System.in)).nextInt();
        Stream<Integer> instream = IntStream
            .rangeClosed(from, to)
            .mapToObj(x -> Integer.valueOf(x));
        System.out.println(findMinMax(instream));
    }

    static Optional<MinMax> findMinMax(Stream<Integer> instream) {
        return Optional.<MinMax>of(instream.map(x -> new MinMax(x, x))
            .reduce(
                new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE),
                (x, y) -> new MinMax(Math.min(x.min, y.min), Math.max(x.max, y.max))
                )).filter(x -> x.min != Integer.MAX_VALUE && x.max != Integer.MIN_VALUE);
    }
}  