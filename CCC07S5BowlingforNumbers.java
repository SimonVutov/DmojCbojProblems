import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC07S5BowlingforNumbers {
    public static Scanner s = new Scanner(System.in);
    public static int maxBowl (int n, int k, int w, int[] pins, int runningTotal, int last) {
        if (k == 0) return runningTotal;
        if (last >= n) return 0;
        int max = Integer.MIN_VALUE;
        if (last > 0) last += w;
        for (int i = last; i < n - w + 1; i++) {
            if (pins[i] == -1) continue;

            int p1 = 0;
            if (i < n) {
                p1 = pins[i];
                pins[i] = -1;
            }

            int p2 = 0;
            if (i + 1  < n) {
                p2 = pins[i + 1];
                pins[i + 1] = -1;
            }

            int p3 = 0;
            if (i + 2 < n) {
                p3 = pins[i + 2];
                pins[i + 2] = -1;
            }

            max = Math.max(max, maxBowl(n, k - 1, w, pins, runningTotal + p1 + p2 + p3, i));

            pins[i] = p1;
            pins[i + 1] = p2;
            pins[i + 2] = p3;
        }
        return max;
    }
    public static void main(String[] args) {
        int u = s.nextInt();
        int[] ans = new int[u];
        dp = new int[u];

        for (int i = 0; i < u; i++) {
            int n = s.nextInt(); //number of bowling pins
            int k = s.nextInt(); //number of bowling balls
            int w = s.nextInt(); //number of adjacent pins it can knock over
            int[] pins = new int[n]; //score of the pins
            for (int j = 0; j < n; j++) pins[j] = s.nextInt();

            ans[i] = maxBowl(n, k, w, pins, 0, 0);
        }

        for (int i : ans) {
            System.out.println(i);
        }
    }
}