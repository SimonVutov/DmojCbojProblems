import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/graph2
public class GraphTheoryConnectivity {
    public static Scanner s = new Scanner(System.in);
    public class node {
        public int name;
        public LinkedList<Integer> l = new LinkedList<Integer>();
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        node[] list = new node[a];
        for (int i = 0; i < b; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            if (x != y){
                if (list[x - 1] == null) list[x - 1] = new GraphTheoryConnectivity().new node();
                list[x - 1].l.add(y);
                if (list[y - 1] == null) list[y - 1] = new GraphTheoryConnectivity().new node();
                list[y - 1].l.add(x);
            } else{
                if (list[x - 1] == null) list[x - 1] = new GraphTheoryConnectivity().new node();
                list[x - 1].l.add(y);
            }
        }

        Queue<node> q = new LinkedList<>();
        boolean[] visited = new boolean[a];
        node n = new GraphTheoryConnectivity().new node();
        n.l = list[0].l;
        n.name = 1;
        q.add(n);

        while (!q.isEmpty()){
            node x = q.poll();
            if (x.name == a) { System.out.println("YES"); return;}
            if (visited[x.name - 1]) continue;
            visited[x.name - 1] = true;
            for (Integer i : x.l) {
                node y = new GraphTheoryConnectivity().new node(); 
                y.name = i;
                y.l = list[i - 1].l;
                q.add(y);
            }
        }

        System.out.println("NO");
    }
}