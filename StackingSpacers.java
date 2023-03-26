import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/cbojr3p3
public class StackingSpacers {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        
        int[][] arr = new int[a][2];
        for(int i = 0; i < a; i++){
            arr[i][0] = s.nextInt();
        }

        Queue<int[]> q = new LinkedList<int[]>();

        for (int[] i : arr) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            int[] n = q.poll();
            if (n[0] == b) {
                System.out.println(n[1] + 1);
                return;
            }
            if (n[0] > b) continue;
            boolean founditself = false;
            for (int[] j : arr){
                if (j[0] == n[0] && !founditself) { founditself = true; continue; }
                int[] m = new int[2];
                m[0] = n[0] + j[0];
                if (m[0] > b) continue;
                m[1] = n[1] + 1;
                q.add(m);
            }
        }

        System.out.println(-1);
    }
}