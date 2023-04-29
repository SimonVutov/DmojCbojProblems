import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC16S3PhonomenalReviews4 {
    public static boolean conatins (int[] x, int a) {
        for (int i : x) {
            if (i == a) return true;
        }
        return false;
    }
    public static class connections {
        public int id;
        public ArrayList<Integer> connected = new ArrayList<Integer>();
        public int dist = 0;
    }
    public static Scanner s = new Scanner(System.in);
    public static int[] notNeeded = new int[100000];
    public static boolean[] visited = new boolean[100000];

    public static void check(Integer start, connections[] cons) {
        if (visited[start]) { return; }
        visited[start] = true;
        int needChildren = 0;
        for (Integer i : cons[start].connected) {
            if (notNeeded[i] != 1 && !visited[i]) check(i, cons);
            if (notNeeded[i] == 1) {
                needChildren++;
            }
        }
        if (needChildren > 0 || notNeeded[start] == 1) {
            notNeeded[start] = 1;
        } else {
            notNeeded[start] = 0;
        }

        return;
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int m = s.nextInt();

        connections[] conTwoWAy = new connections[n];

        int[] pho = new int[m];

        for (int i = 0; i < m; i++) {
            pho[i] = s.nextInt();
            notNeeded[pho[i]] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (conTwoWAy[a] == null)
                conTwoWAy[a] = new connections();
            if (conTwoWAy[b] == null)
                conTwoWAy[b] = new connections();
            conTwoWAy[b].connected.add(a);
            conTwoWAy[a].connected.add(b);
            conTwoWAy[a].id = a;
            conTwoWAy[b].id = b;
        }

        check(pho[0], conTwoWAy);

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(pho[0]);
        boolean[] visited = new boolean[n];
        visited[pho[0]] = true;

        while (!q.isEmpty()) { 
            int c = q.poll();
            for (Integer i : conTwoWAy[c].connected) {
                if (!visited[i] && notNeeded[i] == 1) {
                    visited[i] = true;
                    conTwoWAy[i].dist = conTwoWAy[c].dist + 1;
                    q.add(i);
                }
            }
        }

        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (conTwoWAy[i].dist > max) {
                max = conTwoWAy[i].dist;
                maxIndex = i;
            }
        }

        q.add(maxIndex);
        conTwoWAy[maxIndex].dist = 0;
        visited = new boolean[n];
        visited[maxIndex] = true;

        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i : conTwoWAy[c].connected) {
                if (!visited[i] && notNeeded[i] == 1) {
                    visited[i] = true;
                    conTwoWAy[i].dist = conTwoWAy[c].dist + 1;
                    q.add(i);
                }
            }
        }

        max = 0;
        for (int i = 0; i < n; i++) {
            if (conTwoWAy[i].dist > max) {
                max = conTwoWAy[i].dist;
            }
        }

        int amountNeeded = 0;
        for (int i = 0; i < n; i++) {
            if (notNeeded[i] == 1) {
                amountNeeded++;
            }
        }
        System.out.println((amountNeeded - 1) * 2 - max);
    }
}