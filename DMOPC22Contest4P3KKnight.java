import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DMOPC22Contest4P3KKnight {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            int k = s.nextInt();
            int[][] dist = new int[x + 2][y + 2];
            int[] spot = {x, y};

            Queue<int[]> q = new LinkedList<>();

            q.add(spot);
            dist[x][y] = 0;

            int[][] moves = new int[8 * k][2];
            for (int j = 1; j <= k; j++) {
                moves[0 + (j - 1) * 8] = new int[] {1, j};
                moves[1 + (j - 1) * 8] = new int[] {1, -j};
                moves[2 + (j - 1) * 8] = new int[] {-1, j};
                moves[3 + (j - 1) * 8] = new int[] {-1, -j};
                moves[4 + (j - 1) * 8] = new int[] {j, 1};
                moves[5 + (j - 1) * 8] = new int[] {j, -1};
                moves[6 + (j - 1) * 8] = new int[] {-j, 1};
                moves[7 + (j - 1) * 8] = new int[] {-j, -1};
            }

            innerloop:
            while (!q.isEmpty()) {
                int[] c = q.poll();
                int cx = c[0];
                int cy = c[1];

                if (cx == 0 && cy == 0) {
                    ans[i] = dist[cx][cy];
                    break innerloop;
                }

                for (int[] move : moves) {
                    int nx = cx + move[0];
                    int ny = cy + move[1];

                    if (nx >= 0 && nx < x + 2 && ny >= 0 && ny < y + 2 && dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[cx][cy] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            } 
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}