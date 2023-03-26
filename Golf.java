import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Golf {
    public static Scanner s = new Scanner(System.in);
    public static int[][] dp;
    public static int s (int[] distances, int currentdistance, int strokes) {
        if (dp[distances.length - 1][currentdistance] != 0) return dp[distances.length - 1][currentdistance];
        if (currentdistance == 0) return strokes;
        if (currentdistance < 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == 0 || currentdistance - distances[i] < 0) continue;
            int strok = s(distances, currentdistance - distances[i], strokes + 1);
            if (strok < min) min = strok;
        }
        dp[distances.length - 1][currentdistance] = min;
        return min;
    }
    public static void main(String[] args) {
        int d = s.nextInt();
        int n = s.nextInt();
        dp = new int[n][d + 1];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = s.nextInt();
        }
        int strokes = s(x, d, 0);
        if (strokes == Integer.MAX_VALUE) {
            System.out.println("Roberta acknowledges defeat.");
        } else {
            System.out.println("Roberta wins in " + strokes + " strokes.");
        }
    }
}