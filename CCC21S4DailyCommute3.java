import java.util.*;

public class CCC21S4DailyCommute3 {
    static Scanner s = new Scanner(System.in);
    public static class station {
        public ArrayList<Integer> to = new ArrayList<>();
    }
    public static void main(String[] args) {
        int N = s.nextInt(); //number of stations
        int W = s.nextInt(); //number of walkways
        int D = s.nextInt(); //number of days

        station[] walkways = new station[N];

        for (int i = 0; i < W; i++) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            if (walkways[b] == null) walkways[b] = new station();
            walkways[b].to.add(a);
        }

        int[] stations = new int[N];
        for (int i = 0; i < N; i++) {
            stations[i] = s.nextInt() - 1;
        }

        int[][] changes = new int[D][2];
        for (int i = 0; i < D; i++) {
            changes[i][0] = s.nextInt() - 1;
            changes[i][1] = s.nextInt() - 1;
        }

        int[] walkDistance = new int[N];
        Arrays.fill(walkDistance, Integer.MAX_VALUE);
        walkDistance[N - 1] = 0;
        boolean[] visited = new boolean[N];
        visited[N - 1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(N - 1);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if (walkways[cur] != null) {
                for (int i : walkways[cur].to) {
                    if (!visited[i]) {
                        visited[i] = true;
                        walkDistance[i] = walkDistance[cur] + 1;
                        q.add(i);
                    }
                }
            }
            if (cur > 0) if (!visited[stations[cur - 1]]) {
                visited[stations[cur - 1]] = true;
                walkDistance[stations[cur - 1]] = walkDistance[cur] + 1;
                q.add(stations[cur - 1]);
            }
        }

        int[] subwayDistance = new int[N];
        for (int i = 0; i < N; i++) {
            subwayDistance[stations[i]] = i;
        }

        System.out.println(Arrays.toString(subwayDistance));
        for (int[] change : changes) {
            int a = change[0];
            int b = change[1];
            int temp = subwayDistance[stations[a]];
            subwayDistance[stations[a]] = subwayDistance[stations[b]];
            subwayDistance[stations[b]] = temp;
            temp = stations[a];
            stations[a] = stations[b];
            stations[b] = temp;
            System.out.println(Arrays.toString(stations));
            System.out.println(Arrays.toString(subwayDistance));
            int minTotal = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (subwayDistance[i] + walkDistance[i] < minTotal) minTotal = subwayDistance[i] + walkDistance[i];
            }
            System.out.println(minTotal);
        }
    }
}
