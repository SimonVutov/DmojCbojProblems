import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//https://cboj.ca/problem/cbojr2p2
public class RakingLeaves {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        if (a < 0 || b < 0) { System.out.println(0); return; }
        int[] arr = new int[a];
        for(int i = 0; i < a; i++){
            if (i > 0)arr[i] = arr[i - 1] + s.nextInt();
            else arr[i] = s.nextInt();
        }
        if (b == 0) { System.out.println(0); return; }
        int max = 0;
        for (int i = 0; i < a - b + 1; i++){
            int n = 0;
            if (i > 0) n = (arr[i + b - 1] - arr[i - 1]);
            else n = (arr[i + b - 1]);
            if (n > max) max = n;
        }
        System.out.println(max);
    }
}