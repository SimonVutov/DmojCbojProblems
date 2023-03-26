import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CrazyFencing {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        double total = 0;
        int[] c = new int[n + 1];
        for (int i = 0; i <= n; i++) c[i] = s.nextInt();
        for (int i = 0; i < n; i++) {
            int length = s.nextInt();
            total += (double)(c[i] + c[i + 1]) * 0.5 * length;
        }
        System.out.println(total);
    }
}