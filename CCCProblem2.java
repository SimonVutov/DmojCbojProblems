import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCProblem2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int[] a = new int[n];
        int[] minValues = new int[n];
        for (int i = 0; i < n; i++) minValues[i] = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) a[i] = s.nextInt();
        minValues[0] = 0;
        for (int i = 1; i < n; i++) {
            innerloop:
            for (int j = 0; j < n - i; j++) {
                System.out.println("looping here i: " + i + " j: " + j);
                if (minValues[i] == 0) break innerloop;
                int sum = 0;
                for (int k = 0; k < (i + 1) / 2; k++) {
                    System.out.println("i: " + i + " j: " + j + " k: " + k);
                    sum += Math.abs(a[j + k] - a[j + i - k]);
                }
                minValues[i] = Math.min(minValues[i], sum);
            }
        }
        for (int i : minValues) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}