import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC09S4ShopandShip {
    public static Scanner s = new Scanner(System.in);
    public static class city {
        public int id;
        public ArrayList<Integer> adj = new ArrayList<Integer>();
        public ArrayList<Integer> cost = new ArrayList<Integer>();
        public int shippingCost = Integer.MAX_VALUE;
        boolean[] visited = new boolean[5001];
    }
    
    public static void main(String[] args) {
        int n = s.nextInt();
        int m = s.nextInt();

        city[] citys = new city[n];

        for (int i = 0; i < m; i++) {
            int x = s.nextInt() - 1;
            int y = s.nextInt() - 1;
            int cost = s.nextInt();

            if (citys[x] == null) citys[x] = new city();
            if (citys[y] == null) citys[y] = new city();

            citys[x].id = x;
            citys[x].cost.add(cost);
            citys[x].adj.add(y);

            citys[y].id = y;
            citys[y].cost.add(cost);
            citys[y].adj.add(x);
        }

        int[] shopCost = new int[n];
        Arrays.fill(shopCost, Integer.MAX_VALUE);

        int k = s.nextInt();
        for (int i = 0; i < k; i++) {
            int x = s.nextInt() - 1;
            int cost = s.nextInt();
            shopCost[x] = cost;
        }

        PriorityQueue<city> q = new PriorityQueue<city>(new Comparator<city>() {
            @Override
            public int compare(city a, city b) {
                return b.shippingCost - a.shippingCost;
            }
        });

        int p = s.nextInt() - 1;
        q.add(citys[p]);
        citys[p].shippingCost = 0;

        while (!q.isEmpty()) {
            city c = q.poll();
            //System.out.println(c.id);
            if (c.visited[c.id]) continue;
            c.visited[c.id] = true;
            for (Integer b : c.adj) {
                if (!c.visited[b]) {
                    citys[b].shippingCost = Math.min(citys[b].shippingCost, c.shippingCost + c.cost.get(c.adj.indexOf(b)));
                    citys[b].visited = c.visited;   
                    //System.out.println("Shipping cost to " + (b+1) + " is " + citys[b].shippingCost + " or " + c.shippingCost + " + " + c.cost.get(c.adj.indexOf(b)));
                    q.add(citys[b]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (shopCost[i] != Integer.MAX_VALUE) {
                min = Math.min(min, shopCost[i] + citys[i].shippingCost);
            }
        }
        System.out.println(min);
    }
}