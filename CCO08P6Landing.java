import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;
//https://dmoj.ca/problem/cco08p6
//january 13 2023

public static class tree{
    int x;
    int y;
}

public class CCO08P6Landing {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        tree[] trees = new tree[n];

        for (int i = 0; i < n; i++){
            trees[i] = new tree();
            trees[i].x = s.nextInt();
            trees[i].y = s.nextInt();
        }

        
    }   
}