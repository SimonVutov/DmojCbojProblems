import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ProblemS1 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        if (a.length < 6) { System.out.println(0); return; }

        Arrays.sort(a);

        int at = n - 4;

        while (at >= 0) {
            int a1 = a[at + 3];
            int b1 = a[at + 2];
            int c1 = a[at + 1];
            int a2 = a[at + 0];
            int b2 = a[at - 1];
            int c2 = a[at - 2];
            if (a1 + b1 > c1 && b1 + c1 > a1 && a1 + c1 > b1 && a2 + b2 > c2 && b2 + c2 > a2 && a2 + c2 > b2) {
                System.out.println((a1 + b1 + c1 + a2 + b2 + c2));
                return;
            }
            a1 = a[at + 3];
            b1 = a[at + 2];
            c1 = a[at + 1];
            a2 = a[at + 0];
            b2 = a[at - 1];
            c2 = a[at - 2];
        }
    }
}