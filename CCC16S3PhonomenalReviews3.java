import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC16S3PhonomenalReviews3{
    public static class connections {
        public int id;
        public ArrayList<Integer> connected = new ArrayList<Integer>();
        public int dist = 0;
    }
    public static ArrayList<Integer> trim (connections[] cont, int[] phot, int start) {
        System.out.println(start + " " + Arrays.toString(phot));
        ArrayList<Integer> toBeRemove = new ArrayList<Integer>();
        boolean NeedToKeep = false;

        if (cont[start].connected.size() == 0) {
            boolean remove = true;
            for (Integer integer : phot) {
                if (integer == start) remove = false;
            }
            if (remove) { toBeRemove.add(start); toBeRemove.add(-70); }
            System.out.println(start + " " + toBeRemove);
            return toBeRemove;
        }

        for (int i = 0; i < cont[start].connected.size(); i++) {
            ArrayList<Integer> toBeRemove2 = trim(cont, phot, cont[start].connected.get(i));
            if (toBeRemove2.size() != 0) {
                if (toBeRemove2.get(toBeRemove2.size() - 1) == -70) { 
                    toBeRemove2.remove(toBeRemove2.size() - 1);
                } else {
                    NeedToKeep = true;
                }
                toBeRemove.addAll(toBeRemove2);
            } else {
                NeedToKeep = true;
            }
        }

        if (!NeedToKeep) { toBeRemove.add(start); toBeRemove.add(-70); }

        System.out.println(start + " " + toBeRemove);
        return toBeRemove;
    }
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int m = s.nextInt();

        connections[] con = new connections[n];
        connections[] conTwoWAy = new connections[n];

        int[] pho = new int[m];

        for (int i = 0; i < m; i++)
            pho[i] = s.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (con[a] == null)
                con[a] = new connections();
            if (con[b] == null)
                con[b] = new connections();
            if (a > b) con[b].connected.add(a);
            else con[a].connected.add(b);
            con[a].id = a;
            con[b].id = b;

            if (conTwoWAy[a] == null)
                conTwoWAy[a] = new connections();
            if (conTwoWAy[b] == null)
                conTwoWAy[b] = new connections();
            conTwoWAy[b].connected.add(a);
            conTwoWAy[a].connected.add(b);
            conTwoWAy[a].id = a;
            conTwoWAy[b].id = b;
        }

        ArrayList<Integer> toBeRemove = trim(con, pho, 0);

        int[] trimmed = new int[n - toBeRemove.size()];

        int at = 0;
        for (int i = 0; i < n; i++) {
            if (toBeRemove.contains(i)) continue;
            trimmed[at] = i;
            at++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(trimmed[0]);
        con[trimmed[0]].dist = 0;
        //FIX BY STAERTING AT PHO, NOT 0

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < con[current].connected.size(); i++) {
                if (!toBeRemove.contains(con[current].connected.get(i))) {
                    q.add(con[current].connected.get(i));
                    con[con[current].connected.get(i)].dist = con[current].dist + 1;
                }
            }
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < trimmed.length; i++) {
            if (con[trimmed[i]].dist > max) {
                max = con[trimmed[i]].dist;
                maxIndex = trimmed[i];
            }
        }
        q.add(maxIndex);
        con[maxIndex].dist = 0;

        boolean[] visited = new boolean[n];
        visited[maxIndex] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < conTwoWAy[current].connected.size(); i++) {
                if (!toBeRemove.contains(conTwoWAy[current].connected.get(i)) && !visited[conTwoWAy[current].connected.get(i)]) {
                    visited[conTwoWAy[current].connected.get(i)] = true;
                    q.add(conTwoWAy[current].connected.get(i));
                    con[conTwoWAy[current].connected.get(i)].dist = con[current].dist + 1;
                }
            }
        }

        int span = 0;
        for (connections connection : con) {
            span = Math.max(span, connection.dist);
        }

        System.out.println(toBeRemove + " " + span);
        System.out.println((n - toBeRemove.size() - 1) * 2 - span);
    }
}