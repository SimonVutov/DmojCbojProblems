import java.util.Scanner;
import java.io.*;
import java.util.*;

public class KeeponTruckin {
    public static Scanner s = new Scanner(System.in);
    public static int c (int[] x, int currentdistance, int A, int B) {
        //System.out.println(currentdistance);
        if (currentdistance >= 7000) return 1;
        int total = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] - currentdistance <= A || x[i] - currentdistance >= B) continue;
            total += c(x, currentdistance + x[i], A, B);
        }
        return total;
    }
    public static void main(String[] args) {
        int A = s.nextInt();
        int B = s.nextInt();
        int n = s.nextInt();
        int[] start = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
        int[] x = new int[n + 14];
        for (int i = 0; i < n; i++) x[i] = s.nextInt();
        for (int i = 0; i < 14; i++) x[i + n] = start[i];
        System.out.println(c(x, 0, A, B));
    }
}