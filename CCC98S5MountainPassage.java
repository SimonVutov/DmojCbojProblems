import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC98S5MountainPassage {
    public static Scanner s = new Scanner(System.in);

    public static class path {
        public int x = 0;
        public int y = 0;
        public int oxygen = 0;
        boolean[][] visited = new boolean[25][25];
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            int[][] arr = new int[m][m]; //y x
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = s.nextInt();
                }
            }

            PriorityQueue<path> pq = new PriorityQueue<>(new Comparator<path>() {
                @Override
                public int compare(path o1, path o2) {
                    return o1.oxygen - o2.oxygen;
                }
            });

            path start = new path();
            start.x = 0;
            start.y = 0;
            start.oxygen = 0;
            start.visited[0][0] = true;
            pq.add(start);

            int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int startO2 = arr[0][0];
            Boolean found = false;

            innerloop:
            while (!pq.isEmpty()) {
                path c = pq.poll();
                if (c.x == m - 1 && c.y == m - 1) {
                    System.out.println(c.oxygen);
                    found = true;
                    break innerloop;
                }
                for (int[] dir : d) {
                    int newX = c.x + dir[0];
                    int newY = c.y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < m && !c.visited[newY][newX] && Math.abs(arr[newY][newX] - arr[c.y][c.x]) <= 2) {
                        path next = new path();
                        next.x = newX;
                        next.y = newY;
                        if (arr[newY][newX] > startO2 || arr[c.y][c.x] > startO2) next.oxygen = c.oxygen + 1;
                        else next.oxygen = c.oxygen;
                        next.visited = c.visited;
                        next.visited[newY][newX] = true;
                        pq.add(next);
                    }
                }
            }
            if (!found) System.out.println("CANNOT MAKE THE TRIP");
            if (i != n - 1) System.out.println();
        }
    }
}