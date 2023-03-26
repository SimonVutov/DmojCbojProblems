import java.util.Scanner;
import java.io.*;
import java.util.*;

public class StackingSpacersProblem3 {
    public static Scanner s = new Scanner(System.in);
    public static int[][] answer = new int[10001][1000];

    public static int stack (int n, int c, int[] blocks) {
        if (n < 0) return -1;
        if (n == 0) return c;
        if (answer[n][c] != 0) return answer[n][c];
        answer[n][c] = -1;
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] == 0) continue;
            int[] temparr = blocks.clone();
            temparr[i] = 0;
            int temp = stack(n - blocks[i], c + 1, temparr);
            if (temp != -1) {
                if (answer[n][c] == -1) {
                    answer[n][c] = temp;
                } else {
                    answer[n][c] = Math.min(answer[n][c], temp);
                }
            }
        }

        return answer[n][c];
    }
    public static void main(String[] args) {
        int n = s.nextInt();
        int x = s.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) blocks[i] = s.nextInt();
        System.out.println(stack(x, 0, blocks));
    }
}