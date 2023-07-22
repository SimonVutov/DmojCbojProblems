import java.util.Scanner;
import java.math.BigInteger;

public class CBOJExecSelectionContest2Problem3AnitasArray2 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int x = s.nextInt();
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextBigInteger();
        }

        BigInteger max = BigInteger.ZERO;
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1].add(arr[i - 1]);
            for (int j = i - 2; j >= 0; j--) {
                BigInteger sum = dp[i].subtract(dp[j]);
                if (sum.compareTo(BigInteger.valueOf(x)) <= 0) {
                    max = max.max(sum);
                    break;
                }
            }
        }

        System.out.println(max.equals(BigInteger.ZERO) ? "-1" : max);
    }
}
