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
            int[][] temp = Arrays.copyOf(grid, R);
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < C; k++) {
                    if (temp[i - j][k] == temp[i - j - 1][k]) temp[i - j - 1][k] = 0;
                    else temp[i - j - 1][k] = 1;
                }
            }
            set.add(Arrays.toString(temp[0]));
        }

        System.out.println(set.size());
    }
}