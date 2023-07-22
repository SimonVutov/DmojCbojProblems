import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC21S4DailyCommute {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int stations = s.nextInt();
        int walkways = s.nextInt();
        int days = s.nextInt();
        ArrayList<ArrayList<Integer>> walkway = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < stations; i++) walkway.add(new ArrayList<Integer>());
        for (int i = 0; i < walkways; i++) {
            int st = s.nextInt() - 1;
            int en = s.nextInt() - 1;
            walkway.get(en).add(st);
        }
        int[] reverseDist = new int[stations];
        Arrays.fill(reverseDist, Integer.MAX_VALUE);
        reverseDist[stations - 1] = 0;

        int station[] = new int[stations];
        for (int i = 0; i < stations; i++) station[i] = s.nextInt();
        for (int i = 1; i < stations; i++) {
            walkway.get(i).add(i - 1);
        }

        //print all walkways
        for (int i = 0; i < stations; i++) {
            System.out.println(walkway.get(i));
        }

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(stations - 1);
        int[] visited = new int[stations];

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : walkway.get(cur)) {
                if (visited[i] != 1) {
                    reverseDist[i] = Math.min(reverseDist[i], reverseDist[cur] + 1);
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }

        int[] index = new int[stations];
        for (int i = 0; i < stations; i++) index[i] = i;

        for (int i = 0; i < days; i++) {
            int c1 = s.nextInt() - 1;
            int c2 = s.nextInt() - 1;

            int temp = index[c1];
            index[c1] = index[c2];
            index[c2] = temp;

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < stations; j++) {
                min = Math.min(min, reverseDist[j] + index[j]);
            }

            System.out.println("reverse dist " + Arrays.toString(reverseDist));
            System.out.println("index " + Arrays.toString(index));

            System.out.println(min);
        }
    }
}