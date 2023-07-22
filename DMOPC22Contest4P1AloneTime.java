import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DMOPC22Contest4P1AloneTime {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int N = s.nextInt(); //N classes
        int M = s.nextInt(); //stay for M minutes
        int K = s.nextInt(); //move one class by K minutes
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        int maxContinuous = 0;

        for (int i = 0; i < N; i++) {
            //move ith to the left
            int right = M + 1;
            if (i < N - 1) right = arr[i + 1];
            int left = Math.max(arr[i] - K, 0);
            if (i > 0) left = Math.max(left, arr[i - 1]);
            int continuous = right - left - 1;
            maxContinuous = Math.max(maxContinuous, continuous);

            //move ith to the right
            left = 0;
            if (i > 0) left = arr[i - 1];
            right = Math.min(arr[i] + K, M + 1);
            if (i < N - 1) right = Math.min(right, arr[i + 1]);
            continuous = right - left - 1;
            maxContinuous = Math.max(maxContinuous, continuous);
        }

        for (int i = 1; i < N; i++) {
            int continuous = arr[i] - arr[i - 1] - 1;
            maxContinuous = Math.max(maxContinuous, continuous);
        }

        System.out.println(maxContinuous);
    }
}