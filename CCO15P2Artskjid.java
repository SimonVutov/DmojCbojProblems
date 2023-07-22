import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCO15P2Artskjid {
    public static Scanner s = new Scanner(System.in);
    public static class path {
        public int at;
        public boolean[] visited;
        public int distance;
    }
    public static void main(String[] args) {
        int n = s.nextInt();
        int m = s.nextInt();

        int[][] adj = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            adj[a][b] = s.nextInt();
        }

        path p = new path();
        p.visited = new boolean[n];
        p.distance = 0;
        p.at = 0;

        Queue <path> q = new LinkedList<>();

        q.add(p);

        int longest = 0;

        while (!q.isEmpty()) {
            path c = q.poll();
            if (c.at == m - 1) longest = Math.max(longest, c.distance);
            else {
                for (int i = 0; i < n; i++) {
                    if (adj[c.at][i] != 0 && !c.visited[i]) {
                        path np = new path();
                        np.at = i;
                        np.visited = new boolean[n];
                        for (int j = 0; j < n; j++) {
                            np.visited[j] = c.visited[j];
                        }
                        np.visited[i] = true;
                        np.distance = c.distance + adj[c.at][i];
                        q.add(np);
                    }
                }
            }
        }

        System.out.println(longest);
    }
}