import java.util.stream.IntStream;
import java.util.Scanner;

public class Main17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        IntStream // continue the stream pipeline below
        .rangeClosed(0, Math.max(String.valueOf(i).length(), String.valueOf(j).toString().length()))
        .mapToObj(x -> new int[]{
            String.valueOf(i).length() >= x + 1 ? Integer.parseInt(String.valueOf(i).substring(String.valueOf(i).length() - 1 - x, String.valueOf(i).length())) : i,
            String.valueOf(j).length() >= x + 1 ? Integer.parseInt(String.valueOf(j).substring(String.valueOf(j).length() - 1 - x, String.valueOf(j).length())) : j,
            x,
        })
        .map(x -> {
            int l = x[0] / (int) Math.pow(10, x[2]) % 10;
            int r = x[1] / (int) Math.pow(10, x[2]) % 10;
            int q = (x[0] + x[1]) / (int) Math.pow(10, x[2]) % 10;
            int c = (x[0] + x[1]) / (int) Math.pow(10, x[2]);
            return new String[]{l + " + " + r + ((l + r) % 10 != (q % 10) ? " + (1)" : "") + " = " + q + (c >= 10 ? " carry 1" : ""), String.valueOf(x[2])};
        })
        .filter(x -> !(x[0].equals("0 + 0 = 0") && x[1].equals(String.valueOf(Math.max(String.valueOf(i).length(), String.valueOf(j).toString().length())))))
        .map(x -> x[0])
        .forEach(System.out::println);
    }
}
