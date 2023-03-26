import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/ccc03s5
public class TruckingTroublesCCC03S5 {
    public static Scanner s = new Scanner(System.in);
    public class node {
        public int name; public int value;
        public LinkedList<int[]> l = new LinkedList<int[]>();
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        node[] list = new node[a];
        for (int i = 0; i < b; i++) {
            int x = s.nextInt(); int y = s.nextInt(); int w = s.nextInt();
            if (list[x - 1] == null) list[x - 1] = new TruckingTroublesCCC03S5().new node();
            if (list[y - 1] == null) list[y - 1] = new TruckingTroublesCCC03S5().new node();
            int[] u = new int[2];
            u[0] = y;
            u[1] = w;
            list[x - 1].l.add(u);
            u = new int[2];
            u[0] = x;
            u[1] = w;
            list[y - 1].l.add(u);
        }

        boolean[] needToReach = new boolean[a];
        for (int i = 0; i < c; i++) needToReach[s.nextInt() - 1] = true;
        int min = 100000;

        PriorityQueue<node> pq = new PriorityQueue<node>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o2.value - o1.value;
            }
        });

        node n = new TruckingTroublesCCC03S5().new node();
        n.value = 100000;
        n.name = 1;
        pq.add(n);
        boolean[] visited = new boolean[a];
        int counter = 0;
        while (!pq.isEmpty()){
            counter++;
            if (counter > 10000) { System.out.println(min); return; }
            node o = pq.poll();
            //System.out.println(o.name);
            if (visited[o.name - 1]) continue;
            visited[o.name - 1] = true;
            o.l = list[o.name - 1].l;

            if (needToReach[o.name - 1]) if (o.value < min) min = o.value;
                
            for (int[] v : o.l){
                if (!visited[v[0] - 1]){
                    node n2 = new TruckingTroublesCCC03S5().new node();
                    n2.value = Math.min(o.value, v[1]);
                    n2.name = v[0];
                    pq.add(n2);
                    //System.out.println("added " + n2.name + " with value " + n2.value);
                }
            }
        }

        System.out.println(min);
    }
}