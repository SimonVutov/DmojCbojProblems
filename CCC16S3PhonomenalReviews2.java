import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//https://dmoj.ca/problem/ccc16s3
public class CCC16S3PhonomenalReviews2 {
    public static Scanner s = new Scanner(System.in);

    public class Node {
        public int name = 0;
        public ArrayList<Integer> l = new ArrayList<Integer>();
    }
    //valid if it has a need node or a need node in its subtree
    public static boolean valid(int n, Node[] nodes, boolean[] needNodes) {
        if (nodes[n].l.size() == 1 && !needNodes[n]) return false;
        if (needNodes[n]) return true;
        for (int i : nodes[n].l) {
            if (valid(i, nodes, needNodes)) return true;
        }
        return false;
    }

    public static int findStartNode(Node[] nodes) {
        for (Node node : nodes) {
            if (node.l.size() == 1) return node.name;
        }
        return -1;
    }

    public static int bfs(int s, Node[] nodes) {
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

        int max = 0;
        for (int i : dist) {
            if (i > max) max = i;
        }

        return max;
    }

    private Map<Integer, List<Integer>> graph;
    private Stack<Integer> stack;
    private List<Integer> path;

    public CCC16S3PhonomenalReviews2(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
        this.stack = new Stack<>();
        this.path = new ArrayList<>();
    }

    public int findLength() {
        // Check if the graph is connected and has an even degree for all nodes
        //if (!isValidGraph()) {
        //    return -1;
        //}

        // Start the DFS from an arbitrary node
        int start = graph.keySet().iterator().next();
        stack.push(start);

        // DFS to find the Eulerian path
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.get(node) != null && !graph.get(node).isEmpty()) {
                int neighbor = graph.get(node).remove(0);
                stack.push(neighbor);
                graph.get(neighbor).remove((Integer) node);
            } else {
                path.add(stack.pop());
            }
        }

        // Reverse the path to obtain the Eulerian path
        java.util.Collections.reverse(path);

        // Return the length of the path (number of edges)
        return path.size() - 1;
    }

    private boolean isValidGraph() {
        int oddDegreeNodes = 0;
        for (int node : graph.keySet()) {
            int degree = graph.get(node).size();
            if (degree % 2 == 1) {
                oddDegreeNodes++;
            }
        }
        return oddDegreeNodes == 0 || oddDegreeNodes == 2;
    }

    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int[] needNodes = new int[b];
        for (int i = 0; i < b; i++) needNodes[i] = s.nextInt();
        boolean[] needNodesBool = new boolean[a];
        for (int i : needNodes) needNodesBool[i] = true;
        Node[] nodes = new Node[a];
        for (int i = 0; i < a - 1; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            if (nodes[x] == null) nodes[x] = new CCC16S3PhonomenalReviews2(null).new Node();
            if (nodes[y] == null) nodes[y] = new CCC16S3PhonomenalReviews2(null).new Node();
            nodes[x].l.add(y);
            nodes[y].l.add(x);
            nodes[i].name = i;
        } nodes[nodes.length - 1].name = nodes.length - 1;

        for (Node node : nodes) System.out.println(node.name + " - " + node.l);
        //arraylist of nodes to remove
        ArrayList<Integer> toRemove = new ArrayList<Integer>();

        int totalNodes = 8;

        //prune tree
        for (int i = 0; i < nodes.length; i++) {
            for (Integer j : nodes[i].l) {
                if (!valid(j, nodes, needNodesBool)) {
                    toRemove.add(j);
                    totalNodes--;
                }
            }
        }

        //remove nodes
        for (Integer i : toRemove) {
            for (Node node : nodes) {
                if (node.l.contains(i)) node.l.remove(i);
                if (node.name == i) node.l.clear();
            }
        }

        for (Node node : nodes) System.out.println(node.name + " - " + node.l);

        //dfs
        int s = findStartNode(nodes);
        boolean[] visited = new boolean[a];
        int ans = bfs(s, nodes);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (Node n : nodes) {
            graph.put(n.name, n.l);
        }

        CCC16S3PhonomenalReviews2 eulerianPath = new CCC16S3PhonomenalReviews2(graph);
        int length = eulerianPath.findLength();
        System.out.println("Length of Eulerian path: " + length);
    }
}