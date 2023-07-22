import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC18J5Chooseyourownpath {
    public static Scanner s = new Scanner(System.in);
    public static class page {
        public int id;
        ArrayList<Integer> to = new ArrayList<Integer>();
    }
    public static void main(String[] args) {
        int pages = s.nextInt();
        page[] p = new page[pages];
        boolean[] canJustHopToNext = new boolean[pages];
        for (int i = 0; i < pages; i++) {
            int choices = s.nextInt();
            if (choices == 0) {
                canJustHopToNext[i] = true;
            }
            p[i] = new page();
            p[i].id = i;
            for (int j = 0; j < choices; j++) {
                p[i].to.add(s.nextInt() - 1);
            }
        }

        int[] dist = new int[pages];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);

        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i : p[c].to) {
                if (dist[i] > dist[c] + 1) {
                    dist[i] = dist[c] + 1;
                    q.add(i);
                }
            }
            if (c < pages - 1 && canJustHopToNext[c]) {
                if (dist[c + 1] > dist[c] + 1 ) {
                    dist[c + 1] = dist[c] + 1;
                    q.add(c + 1);
                }
            }
        }

        boolean allReachable = true;
        for (int i = 0; i < pages; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                allReachable = false;
                break;
            }
        }

        if (allReachable) System.out.println("Y");
        else System.out.println("N");

        System.out.println(dist[pages - 1]);

        System.out.println(Arrays.toString(dist));
    }
}