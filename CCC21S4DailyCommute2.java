import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC21S4DailyCommute2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int stations = s.nextInt();
        int walkways = s.nextInt();
        int days = s.nextInt();
        ArrayList<ArrayList<Integer>> walkway = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < stations; i++) walkway.add(new ArrayList<Integer>());
        for (int i = 0; i < walkways; i++) walkway.get(s.nextInt() - 1).add(s.nextInt() - 1);
        int station[] = new int[stations];
        for (int i = 0; i < stations; i++) station[i] = s.nextInt() - 1;
        int[] dist = new int[stations];
        int startChecking = 0;
        for (int i = 0; i < days; i++) {
            int c1 = s.nextInt() - 1;
            int c2 = s.nextInt() - 1;
            startChecking = Math.min(c1, c2);
            int temp = station[c1];
            station[c1] = station[c2];
            station[c2] = temp;
            Queue<Integer> q = new LinkedList<Integer>();
            dist = new int[stations];
            for (int j = 0; j < stations; j++) {
                dist[station[j]] = j;
                if (j > startChecking && i > 0) q.add(j);
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Integer j : walkway.get(cur)) {
                    if (dist[cur] + 1 < dist[j]) {
                        dist[j] = dist[cur] + 1;
                        q.add(j);
                    }
                }
            }

            System.out.println(dist[stations - 1]);
        }
    }
}