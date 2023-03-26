import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/cbojrxp1
public class Networking {
    public static Scanner s = new Scanner(System.in);
    public class node {
        public LinkedList<Integer> l = new LinkedList<Integer>();
    }
    public static double distance (int x, int y, int x2, int y2){
        return Math.sqrt((y2 - y) * (y2 - y) + (x2 - x) * (x2 - x));
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int[][] t= new int[a][2];
        for (int i = 0; i < a; i++){
            int b = s.nextInt();
            int c = s.nextInt();
            t[i][0] = b;
            t[i][1] = c;
        }
        Queue<node> q = new LinkedList<>();
    }
}