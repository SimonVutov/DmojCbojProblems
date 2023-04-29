import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC09S3DegreesOfSeparation {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int adj[][] = {{}, {6}, {6}, {4,5,6,15}, {3,5,6}, {3,4,6}, {1,2,3,4,5,7}, {6,8}, {7,9}, {8,10,12}, {9,11}, {10,12}, {9,11,13}, {12,14,15}, {13}, {3,13}, {17,18}, {16,18}, {16,17}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
        char q = s.next().charAt(0);

        do {
            if (q == 'i') {
                int x = s.nextInt();
                int y = s.nextInt();
                if (adj[x].length == 0)
                    adj[x] = new int[1];
                else
                    adj[x] = Arrays.copyOf(adj[x], adj[x].length + 1);
                if (adj[y].length == 0)
                    adj[y] = new int[1];
                else
                    adj[y] = Arrays.copyOf(adj[y], adj[y].length + 1);
                adj[x][adj[x].length - 1] = y;
                adj[y][adj[y].length - 1] = x;
            } else if (q == 'd') {
                int x = s.nextInt();
                int y = s.nextInt();

                int[] xI = Arrays.copyOf(adj[x], adj[x].length);
                adj[x] = Arrays.copyOf(adj[x], adj[x].length - 1);
                int index = 0;
                for (int i = 0; i < xI.length; i++) {
                    if (xI[i] != y) { adj[x][index] = xI[i]; index++; }
                }

                int[] yI = Arrays.copyOf(adj[y], adj[y].length);
                adj[y] = Arrays.copyOf(adj[y], adj[y].length - 1);
                index = 0;
                for (int i = 0; i < yI.length; i++) {
                    if (yI[i] != x) { adj[y][index] = yI[i]; index++;}                    
                }
            } else if (q == 'n') {
                System.out.println(adj[s.nextInt()].length);
            } else if (q == 'f') {
                boolean[] ff = new boolean[adj.length];
                int x = s.nextInt();

                for (Integer integer : adj[x]) {
                    for (Integer integer2 : adj[integer]) {
                        ff[integer2] = true;
                    }
                }

                for (Integer i : adj[x]) {
                    ff[i] = false;
                }

                ff[x] = false;

                int count = 0;

                for (int i = 0; i < ff.length; i++) {
                    if (ff[i]) count++;
                }

                System.out.println(count);
            } else if (q == 's') {
                int x = s.nextInt();
                int y = s.nextInt();

                boolean[] visited = new boolean[adj.length];
                int[] dist = new int[adj.length];

                Queue<Integer> qu = new LinkedList<Integer>();

                qu.add(x);
                visited[x] = true;
                dist[x] = 0;

                boolean found = false;

                whileloop:
                while(!qu.isEmpty()) {
                    int p = qu.poll();

                    if (p == y) {
                        System.out.println(dist[p]);
                        found = true;
                        break whileloop;
                    }

                    for (Integer integer : adj[p]) {
                        if (!visited[integer]) {
                            visited[integer] = true;
                            dist[integer] = dist[p] + 1;
                            qu.add(integer);
                        }
                    }
                }

                if (!found) System.out.println("Not connected");
            }
            q = s.next().charAt(0);
        } while (q != 'q');
    }
}