import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/allengraph
public class AllensGraph {
    public static Scanner s = new Scanner(System.in);
    public class node {
        public LinkedList<Integer> l = new LinkedList<Integer>();
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        node[] list = new node[a];
        for(int i = 0; i < b; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            if (x != y) {
                if (list[x-1] == null) list[x-1] = new AllensGraph().new node();
                list[x-1].l.add(y);
            }
        }

        int c = s.nextInt();
        int[][] arr = new int[c][2];
        for(int i = 0; i < c; i++){
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }

        for (int i = 0; i < c; i++){
            int x = arr[i][0];
            int y = arr[i][1];
            if (x == y) {
                System.out.println("YES");
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            boolean[] searched = new boolean[a];
            q.add(x);
            boolean printed = false;
            while (!q.isEmpty()){
                int n = q.poll();
                if (searched[n-1]) continue;
                searched[n-1] = true;
                if (list[n-1] == null) continue;
                loop:
                for (int j : list[n-1].l) {
                    if (j == y) {
                        System.out.println("YES");
                        printed = true;
                        break loop;
                    } else {
                        q.add(j);
                    }
                }
            }
            if(!printed) System.out.println("NO");
        }
    }
}