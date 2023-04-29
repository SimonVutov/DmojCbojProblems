import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC09S2LightsGoingOnandOff {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int R = s.nextInt();
        int C = s.nextInt();
        int[][] grid = new int[R][C];
        s.nextLine();
        for (int i = 0; i < R; i++) {
            String[] str = s.nextLine().split(" ");
            for (int j = 0; j < C; j++) grid[i][j] = Integer.parseInt(str[j]);
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < R; i++) {
            int[][] temp = new int[R][C];
            for (int j = 0; j < R; j++) for (int k = 0; k < C; k++) temp[j][k] = grid[j][k];
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < C; k++) {
                    if (temp[R - i + j][k] == temp[R - i + j - 1][k]) temp[R - i + j][k] = 0;
                    else temp[R - i + j][k] = 1;
                }
            }
            set.add(Arrays.toString(temp[R - 1]));
        }
        System.out.println(set.size());
    }
}