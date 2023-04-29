import java.util.*;

public class ShopAndShip {
    static class Edge {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        List<Edge>[] graph = new List[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        int k = s.nextInt();
        int[] pencils = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pencils[i] = -1;
        }
        for (int i = 0; i < k; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            pencils[a] = b;
        }
        int d = s.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] {d, 0});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE/2);
        dist[d] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int c = cur[1];
            if (c > dist[u]) {
                continue;
            }
            for (Edge e : graph[u]) {
                int v = e.to;
                int w = e.cost;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    int totalCost = dist[v];
                    if (pencils[v] != -1) {
                        totalCost += pencils[v];
                    }
                    pq.add(new int[] {v, totalCost});
                }
            }
        }
        int minCost = Integer.MAX_VALUE/2;
        for (int i = 1; i <= n; i++) {
            if (pencils[i] != -1) {
                minCost = Math.min(minCost, dist[i] + pencils[i]);
            }
        }
        System.out.println(minCost);
    }
}