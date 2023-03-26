import java.util.Scanner;
import java.io.*;
import java.util.*;

public class AnAnimalContest2P3KoalaBalloons {
    public static Scanner s = new Scanner(System.in);
    public static boolean check (char[][] arr, int r, int c, int size, boolean[][] visited, int row, int col) {
        System.out.println(r + " " + c + " " + size);
        visited[r][c] = true;
        if (arr[r + size - 1][c + size - 1] == 'Y') return true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[r + i][c + j] == 'X') return false;
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            System.out.println(" possible add " + newR + " " + newC);
            if (newR >= 0 && newR < row - size && newC >= 0 && newC < col - size && !visited[newR][newC]) {
                if (check(arr, newR, newC, size, visited, row, col)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        int r = s.nextInt();
        int c = s.nextInt();
        s.nextLine();
        char[][] arr = new char[r][c];
        for(int i = 0; i < r; i++)
        {
            String str = s.nextLine();
            for(int j = 0; j < c; j++)
            {
                arr[i][j] = str.charAt(j);
            }
        }

        int size = Math.min(r, c);

        arr[r - 1][c - 1] = 'Y';

        while (true) {
            boolean[][] visited = new boolean[r][c];
            if (check(arr, 0, 0, size, visited, r, c)) {
                System.out.println(size);
                return;
            } else size--;
        }
    }
}