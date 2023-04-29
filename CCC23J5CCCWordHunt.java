import java.util.*;
import java.io.*;
import java.util.Scanner;

public class CCC23J5CCCWordHunt {
    public static Scanner s = new Scanner(System.in);
    public static int search (boolean usedRightAngle, int x, int y, int dx, int dy, char[][] grid, String word, boolean firstIteration) {
        int total = 0;
        if (word.length() == 1 && grid[y][x] == word.charAt(0)) return 1;
        int dxPurpendicular = -dy;
        int dyPurpendicular = dx;

        if (usedRightAngle) {
            if (!(x + dx < 0 || x + dx >= grid[0].length || y + dy < 0 || y + dy >= grid.length)) {
                if (grid[y + dy][x + dx] == word.charAt(1)) {
                    total += search(true, x + dx, y + dy, dx, dy, grid, word.substring(1), false);
                }
            }
        } else if (!usedRightAngle) {
            if (!(x + dx < 0 || x + dx >= grid[0].length || y + dy < 0 || y + dy >= grid.length)) {
                if (grid[y + dy][x + dx] == word.charAt(1)) {
                    total += search(false, x + dx, y + dy, dx, dy, grid, word.substring(1), false);
                }
            }
            if (!firstIteration) {
                if (x + dxPurpendicular >= 0 && x + dxPurpendicular < grid[0].length && y + dyPurpendicular >= 0 && y + dyPurpendicular < grid.length) {
                    if (grid[y + dyPurpendicular][x + dxPurpendicular] == word.charAt(1)) {
                        total += search(true, x + dxPurpendicular, y + dyPurpendicular, dxPurpendicular, dyPurpendicular, grid, word.substring(1), false);
                    }
                }
                if (x - dxPurpendicular >= 0 && x - dxPurpendicular < grid[0].length && y - dyPurpendicular >= 0 && y - dyPurpendicular < grid.length) {
                    if (grid[y - dyPurpendicular][x - dxPurpendicular] == word.charAt(1)) {
                        total += search(true, x - dxPurpendicular, y - dyPurpendicular, dxPurpendicular, dyPurpendicular, grid, word.substring(1), false);
                    }
                }
            }
        }
        
        return total;
    }
    public static void main(String[] args) {
        String word = s.next();
        int h = s.nextInt();
        int w = s.nextInt();
        char[][] grid = new char[h][w];
        s.nextLine();
        for (int i = 0; i < h; i++) {
            char[] chars = s.nextLine().replace(" ", "").toCharArray();
            for (int j = 0; j < w; j++)  grid[i][j] = chars[j];
        }
        int total = 0;
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int k = 0; k < 8; k++) {
                        total += search(false, j, i, dx[k], dy[k], grid, word, true);
                    }
                }
            }
        }
        if (word.length() == 1) total /= 8;
        System.out.println(total);
    }
}