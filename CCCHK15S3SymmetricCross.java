import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCHK15S3SymmetricCross {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int R = s.nextInt();
        int C = s.nextInt();

        int[][] grid = new int[R][C];
        s.nextLine();
        for (int i = 0; i < R; i++) {
            String[] line = s.nextLine().split(" ");
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        int largestCross = 1;
        int xCoord = 0;
        int yCoord = 0;

        for (int x = 1; x < R - 1; x++) {
            for (int y = 1; y < C - 1; y++) {
                int counter = 0;
                while (x + counter + 1 < C && x - counter - 1 >= 0 && y + counter + 1 < R
                     && y - counter - 1 >= 0 && grid[x + counter][y] == grid[x - counter][y]
                     && grid[x][y + counter] == grid[x][y - counter] && grid[x + counter][y] == grid[x][y + counter]) 
                        counter++;
                if (grid[x + counter][y] == grid[x - counter][y] && grid[x][y + counter] == grid[x][y - counter] && grid[x + counter][y] == grid[x][y + counter]) counter++;
                if (counter > largestCross) {
                    largestCross = counter;
                    xCoord = x;
                    yCoord = y;
                }
            }
        }

        System.out.println(largestCross - 1 + " " + (xCoord + 1) + " " + (yCoord + 1));
    }
}