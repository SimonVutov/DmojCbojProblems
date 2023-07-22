import java.util.Scanner;
import java.io.*;
import java.util.*;

public class WC01SuicidalP3Regis {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        do {
            int[][][] cup = new int[n][n][n];
            s.nextLine();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    String line = s.nextLine();
                    for (int k = 0; k < n; k++) {
                        cup[i][j][k] = Integer.parseInt(line.substring(k, k + 1));
                    }
                }
                if (i != n - 1) {
                    s.nextLine();
                }
            }
            int startX = s.nextInt() - 1;
            int startY = s.nextInt() - 1;
            int startZ = 0;

            Queue<Integer> x = new LinkedList<Integer>();
            Queue<Integer> y = new LinkedList<Integer>();
            Queue<Integer> z = new LinkedList<Integer>();

            x.add(startX);
            y.add(startY);
            z.add(startZ);

            int totalSpace = 0;

            int[][] dx = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0}, {0, 0, -1}};

            int[][][] initial = new int[n][n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n;j++) {
                    for (int k = 0; k < n; k++) {
                        initial[i][j][k] = cup[i][j][k];
                    }
                }
            }

            if (cup[startX][startY][startZ] == 0) {
                while (!y.isEmpty()) {
                    int currX = x.poll();
                    int currY = y.poll();
                    int currZ = z.poll();
                    for (int i = 0; i < 6; i++) {
                        int newX = currX + dx[i][0];
                        int newY = currY + dx[i][1];
                        int newZ = currZ + dx[i][2];
    
                        if (newX >= 0 && newX < n && newY >= 0 && newY < n && newZ >= 0 && newZ < n) {
                            if (cup[newX][newY][newZ] == 0) {
                                x.add(newX);
                                y.add(newY);
                                z.add(newZ);
                                totalSpace++;
                                cup[newX][newY][newZ] = 1;
                            }
                        }
                    }
                }
            }

            System.out.println(totalSpace);

            n = s.nextInt();
        } while (n != -1);
    }
}