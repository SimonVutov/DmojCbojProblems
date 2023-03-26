import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/graph3
public class GraphTheoryShortestPath {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        boolean[][] searched = new boolean[a][a];
        int xStart = s.nextInt();
        int yStart = s.nextInt();
        int xEnd = s.nextInt();
        int yEnd = s.nextInt();

        int[][] moveOptions = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        int[][] arr = new int[a][a];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{xStart, yStart, 0});

        while (!q.isEmpty()){
            int[] n = q.poll();

            if (searched[n[0] - 1][n[1] - 1]) continue;

            arr[n[0] - 1][n[1] - 1] = n[2];

            if (n[0] == xEnd && n[1] == yEnd) {
                break;
            }

            for(int[] i : moveOptions){
                int x = n[0] + i[0];
                int y = n[1] + i[1];
                if (x > 0 && x <= a && y > 0 && y <= a && !searched[x-1][y-1]){
                    q.add(new int[]{x, y, n[2] + 1});
                }
            }
            searched[n[0] - 1][n[1] - 1] = true;
        }

        System.out.println(arr[xEnd - 1][yEnd - 1]);
    }
}