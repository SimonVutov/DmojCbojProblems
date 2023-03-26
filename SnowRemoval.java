import java.math.BigInteger;
import java.util.Scanner;

public class SnowRemoval {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        BigInteger c = BigInteger.ZERO;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = s.nextInt();
        for (int i = 0; i < N; i++) {
            BigInteger add = BigInteger.valueOf(A[i]);
            if (i * 2 < N) add = add.multiply(BigInteger.valueOf(i + 1));
            else add = add.multiply(BigInteger.valueOf(N - i));
            c = c.add(add);
        }
        System.out.println(c);
    }
}
