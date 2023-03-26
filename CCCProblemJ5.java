import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCProblemJ5 {
    public static Scanner s = new Scanner(System.in);

    public static boolean search(int i, int j, int index, String word, char[][] grid) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] != word.charAt(index)) {
            return false;
        }
        grid[i][j] = ' ';
        boolean result = search(i + 1, j, index + 1, word, grid) || search(i - 1, j, index + 1, word, grid) || search(i, j + 1, index + 1, word, grid) || search(i, j - 1, index + 1, word, grid);
        grid[i][j] = word.charAt(index);
        return result;
    }
    
    public static void main(String[] args) {
        String word = s.nextLine();
        int r = s.nextInt();
        int c = s.nextInt();

        char[][] grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = s.nextLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = str.charAt(j);
            }
        }
/*
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    if (search(i, j, 0, word, grid)) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        } */
    }
}