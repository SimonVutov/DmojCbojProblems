import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CCC03S3FloorPlan {
    public static Scanner s = new Scanner(System.in);
    public static int p, r, c;
    public static 
    public static void main(String[] args)
    {
        p = s.nextInt();
        r = s.nextInt();
        c = s.nextInt();

        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = s.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int[][] belongsMap = new int[r][c];

        for (char[] ds : map) {
            for (char d : ds) {
                
            }
        }
    }
}