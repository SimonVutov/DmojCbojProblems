import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC15S4ConvexHull {
    public static Scanner s = new Scanner(System.in);
    public static class route {
        public int to = 0; //b
        public int t = 0; //time taken
        public int h = 0; //damage to hull
    }
    public static class island {
        public ArrayList<route> routes = new ArrayList<route>();
    }
    public static class path {
        int hullLeft = 0;
        int time = 0;
        Set<Integer> visited = new HashSet<>();
        int island = 0;
    }    
    public static void main(String[] args)
    {
        int K = s.nextInt(); //hull thiccness
        int N = s.nextInt(); //amount of islands
        int M = s.nextInt(); //amount of routes

        island[] islands = new island[N];
        for (int i = 0; i < M; i++) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            int t = s.nextInt();
            int h = s.nextInt();

            route r = new route();
            r.to = b;
            r.t = t;
            r.h = h;
            if (islands[a] == null) {
                islands[a] = new island();
            }
            islands[a].routes.add(r);

            route r2 = new route();
            r2.to = a;
            r2.t = t;
            r2.h = h;
            if (islands[b] == null) {
                islands[b] = new island();
            }
            islands[b].routes.add(r2);
        }

        int start = s.nextInt() - 1;
        int end = s.nextInt() - 1;

        PriorityQueue<path> q = new PriorityQueue<path>(new Comparator<path>() {
            @Override
            public int compare(path o1, path o2) {
                return o1.time - o2.time;
            }
        });
        
        path s = new path() {{
            hullLeft = K;
            time = 0;
            island = start;
            visited.add(start);
        }};
        q.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            path p = q.poll();
            if (p.island == end) {
                System.out.println(p.time);
                found = true;
                return;
            }
            for (route r : islands[p.island].routes) {
                if (p.hullLeft - r.h > 0 && !p.visited.contains(r.to)) {
                    path p2 = new path() {{
                        hullLeft = p.hullLeft - r.h;
                        time = p.time + r.t;
                        island = r.to;
                        visited = new HashSet<>();
                    }};
                    p2.visited = new HashSet<>(p.visited);
                    p2.visited.add(r.to);
                    q.add(p2);
                }
            }
        }
        if (!found) {
            System.out.println("-1");
        }
    }
}