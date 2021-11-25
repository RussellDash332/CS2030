import java.math.BigInteger;
import java.util.Scanner;

public class Main18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		BigInteger left = new BigInteger(sc.next());
		BigInteger right = new BigInteger(sc.next());
		sc.close();
		Task<BigInteger> m = new Task<>(left,right);
		System.out.println(m.compute().toString());
    }
}