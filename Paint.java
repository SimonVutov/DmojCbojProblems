import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/cbojr3p4
public class Paint
{
    public static Scanner s = new Scanner(System.in);
    public class cell {
        public int value = 0;
        public int x = 0;
        public int y = 0;
    }
    public static void main(String[] args)
    {
        Queue<cell> q = new LinkedList<>();
        int a = s.nextInt();
        int b = s.nextInt();
        boolean[][] searched = new boolean[b][a];
        cell[][] arr = new cell[b][a];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                arr[j][i] = new Paint().new cell();
                arr[j][i].value = s.nextInt();
                arr[j][i].x = j + 1;
                arr[j][i].y = i + 1;
            }
        }
        int X = s.nextInt();
        int Y = s.nextInt();
        int C = s.nextInt();
        int T = s.nextInt();
        q.add(arr[Y-1][X-1]);
        while (!q.isEmpty()){
            cell c = q.poll();
            int startColor = c.value;
            if (searched[c.x-1][c.y-1]) continue;
            searched[c.x-1][c.y-1] = true;
            if (c.y > 1) if (Math.abs(arr[c.x-1][c.y-2].value - startColor) < T) q.add(arr[c.x-1][c.y-2]); //add below
            if (c.y < a) if (Math.abs(arr[c.x-1][c.y].value - startColor) < T) q.add(arr[c.x-1][c.y]); //add above
            if (c.x > 1) if (Math.abs(arr[c.x-2][c.y-1].value - startColor) < T) q.add(arr[c.x-2][c.y-1]); //add left
            if (c.x < b) if (Math.abs(arr[c.x][c.y-1].value - startColor) < T) q.add(arr[c.x][c.y-1]); //add right
            c.value = C;
        }

        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                System.out.print(arr[j][i].value + " ");
            }
            System.out.println();
        }
    }
}