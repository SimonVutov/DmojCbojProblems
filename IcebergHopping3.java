import java.util.Scanner;
import java.io.*;
import java.util.*;
//https://cboj.ca/problem/binarysearch1
public class IcebergHopping3 {
    public static Scanner s = new Scanner(System.in);

    public static int solve(int[] arr, int K, int[] sorted, int smallestIceBerg)
    {
        System.out.println(Arrays.toString(arr));
        if (arr.length <= K) { System.out.println(K + " s" + Arrays.toString(sorted)); return smallestIceBerg; }

        int N = arr.length;

        for (int i = 0; i < N; i++)
        {
            if (arr[i] == sorted[0]) {
                int[] newStart = Arrays.copyOfRange(arr, 0, i);
                int[] newEnd = Arrays.copyOfRange(arr, i + 1, N);

                int[] newSorted = Arrays.copyOfRange(sorted, 1, N);

                return Math.min(solve(newStart, K, newSorted, sorted[0]), solve(newEnd, K, newSorted, sorted[0]));
            }
        }
        
        return -1;
    }
    public static void main(String[] args)
    {
        int N = s.nextInt();
        int K = s.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = s.nextInt();

        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        //reverse sorted
        for (int i = 0; i < sorted.length / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[sorted.length - i - 1];
            sorted[sorted.length - i - 1] = temp;
        }

        System.out.println(Math.min(solve(arr, K, sorted, 100000000), Math.min(arr[0], arr[N - 1])));
    }
}