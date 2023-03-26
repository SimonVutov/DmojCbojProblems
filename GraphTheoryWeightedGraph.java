import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTheoryWeightedGraph
{
    public static Scanner s = new Scanner(System.in);
    public class cell {
        public int value = 0;
        public int x = 0;
        public int y = 0;
    }
    public class aPath {
        boolean[][] searched = new boolean[b][a];
        public int value = 1000;
        public int x = 1;
        public int y = 1;
    }
    public static int a = s.nextInt();
    public static int b = s.nextInt();
    public static void main(String[] args)
    {
        Queue<aPath> q = new LinkedList<>();

        cell[][] arr = new cell[b][a];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                arr[j][i] = new GraphTheoryWeightedGraph().new cell();
                arr[j][i].value = s.nextInt();
                arr[j][i].x = j + 1;
                arr[j][i].y = i + 1;
            }
        }

        q.add(new GraphTheoryWeightedGraph().new aPath());

        while (!q.isEmpty()){
            aPath c = q.poll();
            c.value -= arr[c.x-1][c.y-1].value;

            System.out.println(c.x + " " + c.y + " " + c.value + " \n \n");

            if (c.x > 1){ //go left
                System.out.println("left" + " " + c.x + " " + c.y);
                if (!c.searched[c.x-2][c.y-1]) {
                    System.out.println("-");
                    c.searched[c.x-2][c.y-1] = true;
                    aPath nPath = new GraphTheoryWeightedGraph().new aPath();
                    nPath = c;
                    nPath.x--;
                    q.add(nPath);
                    System.out.println(nPath.value + " " + nPath.x + " " + nPath.y);
                }
            }
            if (c.x < b){ //go right
                System.out.println("right" + " " + c.x + " " + c.y);
                if (!c.searched[c.x][c.y-1]) {
                    System.out.println("-");
                    c.searched[c.x][c.y-1] = true;
                    aPath nPath = new GraphTheoryWeightedGraph().new aPath();
                    nPath = c;
                    nPath.x++;
                    q.add(nPath);
                    System.out.println(nPath.value + " " + nPath.x + " " + nPath.y);
                }
            }
            if (c.y > 1){ //go down
                System.out.println("down" + " " + c.x + " " + c.y);
                if (!c.searched[c.x-1][c.y-2]) {
                    System.out.println("-");
                    c.searched[c.x-1][c.y-2] = true;
                    aPath nPath = new GraphTheoryWeightedGraph().new aPath();
                    nPath = c;
                    nPath.y--;
                    q.add(nPath);
                    System.out.println(nPath.value + " " + nPath.x + " " + nPath.y);
                }
            }
            if (c.y < a){ //go up
                System.out.println("up" + " " + c.x + " " + c.y);
                if (!c.searched[c.x-1][c.y]) {
                    System.out.println("-");
                    c.searched[c.x-1][c.y] = true;
                    aPath nPath = new GraphTheoryWeightedGraph().new aPath();
                    nPath = c;
                    nPath.y++;
                    q.add(nPath);
                    System.out.println(nPath.value + " " + nPath.x + " " + nPath.y);
                }
            }
        }
    }
}