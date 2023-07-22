import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCO12P2TheHungaryGames {
    public static class path {
        public int at = 0;
        public int dist = 0;
    }
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] adj = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            adj[a][b] = s.nextInt();
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<path> pq = new PriorityQueue<path>(new Comparator<path>() {
            public int compare (path a, path b) {
                return a.dist - b.dist;
            }
        });

        path p = new path();
        p.at = 0;
        p.dist = 0;

        pq.add(p);
        dist[0] = 0;

        int[] timesvisited = new int[n];

        while (!pq.isEmpty()) {
            path c = pq.poll();
            if (c.at == n - 1 && c.dist > dist[n - 1]) {
                System.out.println(c.dist);
                break;
            }
            for (int i = 0; i < n; i++) {
                if (adj[c.at][i] != 0 && timesvisited[i] < 15) {
                    timesvisited[i]++;
                    dist[i] = Math.min(dist[i], dist[c.at] + adj[c.at][i]);
                    path np = new path();
                    np.at = i;
                    np.dist = c.dist + adj[c.at][i];
                    pq.add(np);
                }
            }
        }
    }
}