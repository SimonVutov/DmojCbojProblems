import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CCC05S4PyramidMessageScheme {
    public static Scanner s = new Scanner(System.in);
    public static int find (String[] a, String b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            
            String[] names = new String[m];
            int distinct = 0;
            int[] num = new int[m];
            String[] nam = new String[m];

            //store all the input names in an array, and number the names

            for (int j = 0; j < m; j++) {
                names[j] = s.next();
                if (j == 0) {
                    num[distinct] = distinct;
                    nam[distinct] = names[j];
                    distinct++;
                } else {
                    boolean found = false;
                    for (int k = 0; k < j; k++) {
                        if (names[j].equals(names[k])) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        num[distinct] = distinct;
                        nam[distinct] = names[j];
                        distinct++;
                    }
                }
            }

            boolean[][] adj = new boolean[distinct][distinct];
            int home = 0;

            String a = "";
            String last = "";

            //connect adj boolean array

            for (int j = 0; j < m; j++) {
                a = names[j];
                if (j == 0) {
                    last = a;
                    continue;
                }

                if (find(nam, last) == num[0]) {
                    home = find(nam, a);
                }

                int aIndex = 0;
                int bIndex = 0;
                
                for (int k = 0; k < distinct; k++) {
                    if (nam[k].equals(a)) {
                        aIndex = k;
                    }
                    if (nam[k].equals(last)) {
                        bIndex = k;
                    }
                }

                adj[aIndex][bIndex] = true;
                adj[bIndex][aIndex] = true;

                last = a;
            }

            //find the longest path from home with dfs

            int max = 0;

            Stack <Integer> stack = new Stack <Integer> ();
            boolean[] visited = new boolean[distinct];
            int[] dist = new int[distinct];
            stack.push(home);

            while (!stack.isEmpty()) {
                int c = stack.pop();
                if (!visited[c]) {
                    visited[c] = true;
                    for (int j = 0; j < distinct; j++) {
                        if (adj[c][j]) {
                            if (!visited[j]) {
                                stack.push(j);
                                dist[j] = dist[c] + 1;
                                if (dist[j] > max) max = dist[j];
                            }
                        }
                    }
                }
            }

            System.out.println((2 * (distinct - 1) - 2 * max) * 10);
        }
    }
}