import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCProblem4 {
    public static Scanner s = new Scanner(System.in);
    public static class edge {
        public int id;
        public int length;
        public int cost;
        public int from;
        public int to;
    }
    public static class node {
        public int id;
        public ArrayList<edge> l = new ArrayList<edge>();
    }
    public static int search (node[] nodes, int start, int end, boolean[] visited, int length) {
        visited[start] = true;
        System.out.println(start + " " + end);
        if (start == end) {
            System.out.println("returning " + length);
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (edge edg : nodes[start].l) {
            if (visited[edg.to]) continue;
            int len = length + edg.length;
            int node = edg.to;
            int x = search(nodes, node, end, visited, len);
            if (min > x) {
                min = x;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int nodes = s.nextInt();
        int edges = s.nextInt();
        node[] n = new node[nodes];
        for (int i = 0; i < edges; i++) {
            int from = s.nextInt() - 1;
            int to = s.nextInt() - 1;
            int length = s.nextInt();
            int cost = s.nextInt();
            if (n[from] == null) {
                n[from] = new node();
                n[from].id = from;
            }
            if (n[to] == null) {
                n[to] = new node();
                n[to].id = to;
            }
            edge e = new edge();
            e.id = i;
            e.length = length;
            e.cost = cost;
            e.from = from;
            e.to = to;
            n[from].l.add(e);
            e = new edge();
            e.id = i;
            e.length = length;
            e.cost = cost;
            e.from = to;
            e.to = from;
            n[to].l.add(e);
        }
        for (node node : n) {
            for (edge edge : node.l) {
                System.out.println(edge.id + " " + edge.length + " " + edge.cost + " " + edge.from + " " + edge.to);
                boolean[] visited = new boolean[nodes];
                System.out.println(search(n, node.id, edge.to, visited, 0));
            }
            System.out.println();
        }
    }
}