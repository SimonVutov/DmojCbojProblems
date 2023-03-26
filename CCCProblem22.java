import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int[] a = new int[n];
        int[] minValues = new int[n];
        for (int i = 0; i < n; i++) minValues[i] = 2000000000;
        for (int i = 0; i < a.length; i++) a[i] = s.nextInt();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int left = i;
            int right = i;
            while (left >= 0 && right < n) {
                sum += Math.abs(a[left] - a[right]);
                minValues[right - left] = Math.min(minValues[right - left], sum);
                left--;
                right++;
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < n) {
                sum += Math.abs(a[left] - a[right]);
                minValues[right - left] = Math.min(minValues[right - left], sum);
                left--;
                right++;
            }
        }


        for (int i : minValues) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}