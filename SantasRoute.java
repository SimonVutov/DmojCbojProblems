import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SantasRoute
{
    public static Scanner s = new Scanner(System.in);
    public class Node
    {
        public int name = 0;
        public int x = 0;
        public int y = 0;
        public int p = 0;
        public ArrayList<Node> connected = new ArrayList<Node>();
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int r = s.nextInt();

        Node[] x = new Node[n];
        for (int i = 0; i < n; i++) 
        {
            x[i] = new SantasRoute().new Node();
            x[i].name = i;
            x[i].x = s.nextInt();
            x[i].y = s.nextInt();
            x[i].p = s.nextInt();
        }

        for (Node i : x){
            for (Node j : x){
                if (i.name != j.name){
                    double dist = Math.sqrt(Math.pow(i.x - j.x, 2) + Math.pow(i.y - j.y, 2));
                    if (dist <= r){
                        i.connected.add(j);
                    }
                }
            }
        }

        int max = 0;
        boolean searched[] = new boolean[n];
        for (Node node : x) {
            int sum = 0;
            boolean visited[] = new boolean[n];
            if (searched[node.name]) {
                continue;
            }
            searched[node.name] = true;
             
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);
            visited[node.name] = true;
            while(!q.isEmpty()){
                Node z = q.poll();
                sum += z.p;
                for (Node i : z.connected){
                    if (!visited[i.name]){
                        visited[i.name] = true;
                        q.add(i);
                    }
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}