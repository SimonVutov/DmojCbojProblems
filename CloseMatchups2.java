import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://cboj.ca/problem/binarysearch2
public class CloseMatchups2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int x = s.nextInt();
        int y = s.nextInt();
        int counter = 0;
        int [] a = new int[1000000];

        for (int i = 0; i < x; i++) a[s.nextInt()]++;

        int dif = 0;
        for (int i : a) if (i != 0) dif++;
        
        int[][] b = new int[dif][2];
        int c = 0;
        int counterwhichone = 0;
        for (int i : a) {
            if (i != 0) { b[c][0] = counterwhichone; b[c][1] = i; c++;}
            counterwhichone++;
        }

        for(int i = 0; i < dif; i++) {
            if (b[i][1] > 1) counter += b[i][1] - 1;
            int matchups = 0;
            for (int j = 0; j < y; j++) {
                if (i + j + 1 < dif && b[i][0] - b[i + j + 1][0] < y) matchups += b[i + 1][1];
            }
            counter+= matchups * b[i][1];
        }

        System.out.println(counter);
    }
}