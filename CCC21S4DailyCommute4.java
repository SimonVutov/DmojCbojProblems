import java.io.*;
import java.util.*;

public class CCC21S4DailyCommute4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static class Station {
        public ArrayList<Integer> to = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int W = nextInt();
        int D = nextInt();
        Station[] walkways = new Station[N];

        for (int i = 0; i < W; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            if (walkways[b] == null)
                walkways[b] = new Station();
            walkways[b].to.add(a);
        }

        int[] train = new int[N];
        int[] stationNum = new int[N];
        for (int i = 0; i < N; i++) {
            stationNum[i] = nextInt() - 1;
            train[stationNum[i]] = i;
        }

        int[] walk = new int[N];
        Arrays.fill(walk, Integer.MAX_VALUE);
        walk[N - 1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(N - 1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (walkways[cur] != null) {
                for (int i : walkways[cur].to) {
                    if (walk[i] == Integer.MAX_VALUE) {
                        walk[i] = walk[cur] + 1;
                        q.add(i);
                    }
                }
            }
        }

        int[] amount = new int[400000];

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            if (walk[i] != Integer.MAX_VALUE && walk[i] != Integer.MIN_VALUE) {
                set.add(train[i] + walk[i]);
                amount[train[i] + walk[i]]++;
            }
        }

        for (int i = 0; i < D; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;

            if (walk[stationNum[a]] != Integer.MAX_VALUE) {
                if (amount[train[stationNum[a]] + walk[stationNum[a]]] == 1) {
                    set.remove(train[stationNum[a]] + walk[stationNum[a]]);
                    amount[train[stationNum[a]] + walk[stationNum[a]]]--;
                } else if (amount[train[stationNum[a]] + walk[stationNum[a]]] > 0)
                    amount[train[stationNum[a]] + walk[stationNum[a]]]--;
            }
            if (walk[stationNum[b]] != Integer.MAX_VALUE) {
                if (amount[train[stationNum[b]] + walk[stationNum[b]]] == 1) {
                    set.remove(train[stationNum[b]] + walk[stationNum[b]]);
                    amount[train[stationNum[b]] + walk[stationNum[b]]]--;
                } else if (amount[train[stationNum[b]] + walk[stationNum[b]]] > 0)
                    amount[train[stationNum[b]] + walk[stationNum[b]]]--;
            }

            int temp = stationNum[a];
            stationNum[a] = stationNum[b];
            stationNum[b] = temp;
            temp = train[stationNum[a]];
            train[stationNum[a]] = train[stationNum[b]];
            train[stationNum[b]] = temp;
            if (walk[stationNum[a]] != Integer.MAX_VALUE) {
                set.add(train[stationNum[a]] + walk[stationNum[a]]);
                amount[train[stationNum[a]] + walk[stationNum[a]]]++;
            }
            if (walk[stationNum[b]] != Integer.MAX_VALUE) {
                set.add(train[stationNum[b]] + walk[stationNum[b]]);
                amount[train[stationNum[b]] + walk[stationNum[b]]]++;
            }
            System.out.println(set.first());
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
