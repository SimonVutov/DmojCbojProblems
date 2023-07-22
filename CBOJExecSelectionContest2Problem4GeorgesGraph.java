import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CBOJExecSelectionContest2Problem4GeorgesGraph {
    public static Scanner s = new Scanner(System.in);

    public static class node {
        public ArrayList<Integer> to = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        int nodes = s.nextInt();
        int querries = s.nextInt();
        int edges = (int)( nodes * (nodes - 1) * 0.5);
        node[] graph = new node[nodes];

        int[][] arr = new int[edges][2];

        for (int i = 0; i < edges; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
            if (graph[arr[i][0]] == null) graph[arr[i][0]] = new node();
            graph[arr[i][0]].to.add(arr[i][1]);
        }

        for (int i = 0; i < querries; i++) {
            int n = s.nextInt() - 1;
            int from = arr[n][0];
            int to = arr[n][1];
            graph[from].to.remove(graph[from].to.indexOf(to));
            graph[to - 1].to.add(from);
            
            int longestPath = 0;

            for (int j = 0; j < nodes; j++) {
                System.out.println(longestPath);
                if (graph[j] == null) continue;
                boolean visited[] = new boolean[nodes];
                LinkedList<Integer> queue = new LinkedList<Integer>();
                visited[j] = true;
                int[] dist = new int[nodes];
                dist[j] = 0;

                queue.add(j);
                int maxDist = 0;
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (int k = 0; k < graph[current].to.size(); k++) {
                        int next = graph[current].to.get(k);
                        if (!visited[next - 1]) {
                            visited[next] = true;
                            dist[next] = dist[current] + 1;
                            maxDist = Math.max(maxDist, dist[next]);
                            queue.add(next);
                        }
                    }
                }

                longestPath = Math.max(longestPath, maxDist);
            }
            System.out.println(longestPath);
        }
    }
}
