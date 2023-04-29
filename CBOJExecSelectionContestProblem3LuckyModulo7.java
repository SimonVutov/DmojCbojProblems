import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class CBOJExecSelectionContestProblem3LuckyModulo7 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] arr = new int[n];
        int k = Integer.parseInt(input[1]);
    
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    
        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
    
            StringBuilder sb = new StringBuilder();
            int[] subarray = Arrays.copyOfRange(arr, x - 1, y);
            for (int j = 0; j < subarray.length; j++) {
                sb.append(subarray[j]);
            }
    
            BigInteger big = new BigInteger(sb.toString());

            while (big.compareTo(BigInteger.valueOf(20)) >= 0) {
                big = big.divide(BigInteger.valueOf(10)).subtract( big.remainder(BigInteger.valueOf(10)).multiply(BigInteger.valueOf(2)) );
            }
    
            System.out.println(big);
        }
    }    
}