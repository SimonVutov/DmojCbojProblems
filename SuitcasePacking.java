import java.util.Scanner;
import java.util.Arrays;

public class SuitcasePacking
{
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int N = s.nextInt();
        int W = s.nextInt();
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) weights[i] = s.nextInt();
        Arrays.sort(weights);
        int count = 0;
        int s = 0;
        for (int i = 0; i < N; i++) {
            if (weights[N - i - 1] == -1) continue;
            if (weights[N - i - 1] + weights[s] <= W) {
                weights[s] = -1;
                s++;
                count++;
            }
            else count++;
        }
        System.out.println(count);
    }
}