import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MouseJourney {
    public static Scanner s = new Scanner(System.in);
    public static int[][] dp;
    public static int c (int[][] x, int row, int col) {
        if (dp[row][col] != 0) return dp[row][col];
        if (row == x.length - 1 && col == x[0].length - 1) return 1;
        if (row >= x.length || col >= x[0].length) return 0;
        if (x[row][col] == -1) return 0;
        int a = c(x, row + 1, col);
        int b = c(x, row, col + 1);
        dp[row][col] = a + b;
        return a + b;
    }
    public static void main(String[] args) {
        int r = s.nextInt();
        int c = s.nextInt();
        int[][] x = new int[r][c];

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int row = s.nextInt();
            int col = s.nextInt();
            x[row - 1][col - 1] = -1;
        }

        dp = new int[r + 1][c + 1];

        System.out.println(c(x, 0, 0));
    }
}