import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CCC16S3PhonomenalReviews {
    public static Scanner s = new Scanner(System.in);
    public class Node {
        int name = 0;
        ArrayList<Integer> l = new ArrayList<Integer>();
    }

    public static int bfs(int s, Node[] nodes, int[] needNodes) {
        boolean visited[] = new boolean[nodes.length];
        int prev[] = new int[nodes.length];
        int dist[] = new int[nodes.length];

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        prev[s] = -1;
        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i : nodes[n].l) {
                if (!visited[i]) {
                    visited[i] = true;
                    prev[i] = n;
                    dist[i] = dist[n] + 1;
                    q.add(i);
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }
        System.out.println();

        return -1;
    }

    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int[] needNodes = new int[b];
        for (int i = 0; i < b; i++) needNodes[i] = s.nextInt();
        Node[] nodes = new Node[a];
        int counter = 0;
        for (Node node : nodes) {
            node = new CCC16S3PhonomenalReviews().new Node();
            node.name = counter;
            counter++;
        }
        for (int i = 0; i < a - 1; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            if (nodes[x] == null) nodes[x] = new CCC16S3PhonomenalReviews().new Node();
            if (nodes[y] == null) nodes[y] = new CCC16S3PhonomenalReviews().new Node();
            nodes[x].l.add(y);
            nodes[y].l.add(x);
        }

        double min = Double.MAX_VALUE;
        for (Integer s : needNodes) {
            System.out.println(" start " + s + " length " + bfs(s, nodes, needNodes));
            //min = Math.min(min, bfs(node, nodes, needNodes));
        }
        System.out.println(min);
    }
}