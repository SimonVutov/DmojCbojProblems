import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CCC08S3Maze {
    public static Scanner s = new Scanner(System.in);
    public class intersection {
        public intersection parent;
        public char ch;
        public int r = 0;
        public int c = 0;
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int[] answer = new int[a];
        for (int i = 0; i < a; i++){
            int r = s.nextInt();
            int c = s.nextInt();
            if (r == 1 && c == 1){
                answer[i] = 1;
                char temp = s.next().charAt(0);
                continue;
            }

            intersection[][] arr = new intersection[r][c];

            for (int j = 0; j < r; j++){
                String line = s.next();
                for (int k = 0; k < c; k++){
                    arr[j][k] = new CCC08S3Maze().new intersection();
                    arr[j][k].ch = line.charAt(k);
                    arr[j][k].r = j;
                    arr[j][k].c = k;
                }
            }

            Queue<intersection> q = new LinkedList<>();
            boolean[][] visited = new boolean[r][c];

            q.add(arr[0][0]);

            outerloop:
            while (!q.isEmpty()) {
                intersection x = q.poll();

                if (x.r == r-1 && x.c == c-1) break outerloop;

                visited[x.r][x.c] = true;

                int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

                for (int[] d : direction){
                    int newR = x.r + d[0];
                    int newC = x.c + d[1];

                    if (newR < 0 || newR >= r || newC < 0 || newC >= c) continue;
                    if (visited[newR][newC]) continue;
                    if (arr[newR][newC].ch == '*') continue;
                    if (x.ch == '|' && d[1] != 0) continue;
                    if (x.ch == '-' && d[0] != 0) continue;
                    
                    q.add(arr[newR][newC]);
                    arr[newR][newC].parent = x;
                }
            }
            int length = 1;
            //create new intersection to store the current intersection
            intersection at = new CCC08S3Maze().new intersection();
            at = arr[r-1][c-1];
            boolean good = false;
            
            secondLoop:
            while (at.r != 0 || at.c != 0){
                length++;
                at = arr[at.r][at.c].parent;
                if (at == null) {
                    break secondLoop;
                }
                good = true;
            }

            if (good) answer[i] = length;
            else answer[i] = -1;
            
        }

        for (int i = 0; i < a; i++){
            System.out.println(answer[i]);
        }
    }
}