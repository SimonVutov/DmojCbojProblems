import java.util.Scanner;
import java.io.*;
import java.util.*;

public class AllensAsparagus {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int N = s.nextInt();
        int M = s.nextInt();
        int A = s.nextInt();
        int B = s.nextInt();
        int[] heights = new int[M];
        int[] growthrates = new int[M];
        for (int i = 0; i < M; i++) {
            heights[i] = s.nextInt();
            growthrates[i] = s.nextInt();
        }
        boolean[] possible = new boolean[M];
        int[] growthTime = new int[M];
        for (int i = 0; i < M; i++) {
            int amount = Math.max(heights[i], (int)Math.ceil((double)(A - heights[i]) / (double)Math.max(growthrates[i], 1)) * growthrates[i] + heights[i]);
            if (amount <= B && amount >= A) {
                possible[i] = true;
                growthTime[i] = Math.max(0, (int)(Math.ceil((double)(A - heights[i]) / (double)Math.max(growthrates[i], 1))));
            } else {
                possible[i] = false;
                growthTime[i] = -69000;
            }
        }
        int LongestTime = -1;

        Arrays.sort(growthTime);
        int at = 0;
        while (N > 0 && at < M) {
            if (growthTime[at] != -69000) {
                LongestTime = Math.max(growthTime[at], LongestTime);
                N--;
            }
            at++;
        }
        if (N > 0) System.out.println("-1");
        else System.out.println(LongestTime);
    }
}