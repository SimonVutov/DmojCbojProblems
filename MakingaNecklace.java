import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MakingaNecklace {
    public static Scanner s = new Scanner(System.in);
    public static int[][] dp = new int[100][100];
    public static int nCr(int n, int r)
    {
        if (r == 0 || n == r) {
            return 1;
        }
        if (dp[n][r] != 0) {
            return dp[n][r];
        }
        if (r == 0 || n == r) {
            return 1;
        }
        dp[n][r] = nCr(n - 1, r - 1) + nCr(n - 1, r);
        return dp[n][r];
    }
    public static double c(String s, int n)
    {
        if (s.length() == n) {
            int repetions = 1;
            for (int i = 1; i < s.length(); i++) {
                String newstr = s.substring(i, s.length()) + s.substring(0, i);
                if (newstr.equals(s)) {
                    repetions++;
                }
            }
            int aCount = 0;
            for (int i = 0; i < s.length() - 1; i++)
                if (s.charAt(i) == 'a') aCount++;
            return 1 / (double) Math.min(n * repetions, nCr(n, aCount));
        }

        return c(s + "a", n) + c(s + "b", n);
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        System.out.println(Math.round(c("", n)));
    }
}