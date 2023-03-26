import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/graph4
public class GraphTheoryWeightedGraph2 {
    public static Scanner s = new Scanner(System.in);
    public class Vector2 {
        public int x;
        public int y;
        public Vector2(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public class path {
        public int value;
        public boolean[][] visited;
        public int x;
        public int y;

        public path(){
            this.x = 0;
            this.y = 0;
            this.value = 0;
        }

        public path(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        s.nextLine();
        int[][] arr = new int[a][b];
        for(int i = 0; i < a; i++){
            String line = s.nextLine();
            for(int j = 0; j < b; j++){
                arr[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        PriorityQueue<path> pq = new PriorityQueue<path>(new Comparator<path>() {
            @Override
            public int compare(path o1, path o2) {
                return o1.value - o2.value;
            }
        });

        path p = new GraphTheoryWeightedGraph2().new path(0, 0, 0);
        p.visited = new boolean[a][b];
        pq.add(p);

        while (!pq.isEmpty()){
            path c = pq.poll();
            c.visited[c.x][c.y] = true;

            if (c.x == a-1 && c.y == b-1){
                System.out.println(Math.max(1000 - c.value, 0));
                break;
            }

            if (c.x > 0){ //go left
                if (!c.visited[c.x - 1][c.y]) {
                    path nPath = new GraphTheoryWeightedGraph2().new path(c.x-1, c.y, c.value);
                    nPath.visited = c.visited;
                    nPath.value = c.value + arr[c.x-1][c.y];
                    nPath.x = c.x-1;
                    nPath.y = c.y;
                    pq.add(nPath);
                }
            }
            if (c.x < a - 1){ //go right
                if (!c.visited[c.x + 1][c.y]) {
                    path nPath = new GraphTheoryWeightedGraph2().new path(c.x+1, c.y, c.value);
                    nPath.visited = c.visited;
                    nPath.value = c.value + arr[c.x+1][c.y];
                    nPath.x = c.x+1;
                    nPath.y = c.y;
                    pq.add(nPath);
                }
            }
            if (c.y > 0){ //go down
                if (!c.visited[c.x][c.y - 1]) {
                    path nPath = new GraphTheoryWeightedGraph2().new path(c.x, c.y-1, c.value);
                    nPath.visited = c.visited;
                    nPath.value = c.value + arr[c.x][c.y-1];
                    nPath.x = c.x;
                    nPath.y = c.y-1;
                    pq.add(nPath);
                }
            }
            if (c.y < b - 1){ //go up
                if (!c.visited[c.x][c.y + 1]) {
                    path nPath = new GraphTheoryWeightedGraph2().new path(c.x, c.y+1, c.value);
                    nPath.visited = c.visited;
                    nPath.value = c.value + arr[c.x][c.y+1];
                    nPath.x = c.x;
                    nPath.y = c.y+1;
                    pq.add(nPath);
                }
            }
        }
    }
}