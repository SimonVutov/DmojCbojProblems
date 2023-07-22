import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC13S4WhoisTaller {
    public static Scanner s = new Scanner(System.in);
    public static class p {
        public ArrayList<Integer> taller = new ArrayList<Integer>();
    }
    public static void main(String[] args) {
        int N = s.nextInt();
        int M = s.nextInt();

        p[] people = new p[N+1];

        for (int i = 0; i < M; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            if (people[y] == null) people[y] = new p();
            people[y].taller.add(x);
        }
        int p1 = s.nextInt();
        int p2 = s.nextInt();

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(p1);
        boolean[] visited = new boolean[N+1];
        visited[p1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == p2) {
                System.out.println("no");
                return;
            }
            if (people[cur] != null) {
                for (int i : people[cur].taller) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }   
            }
        }

        q.add(p2);
        visited = new boolean[N+1];
        visited[p2] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == p1) {
                System.out.println("yes");
                return;
            }
            if (people[cur] != null) {
                for (int i : people[cur].taller) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }

        System.out.println("unknown");
    }
}