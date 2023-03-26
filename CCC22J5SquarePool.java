import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CCC22J5SquarePool {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        int[][] t = new int[b][2];
        for (int i = 0; i < b; i++) {
            t[i][1] = s.nextInt();
            t[i][0] = s.nextInt();
        }

        for (int i = a - 1; i >= 0; i--) { //all a sizes
            for (int j = 0; j < a - i; j++) { //all y positions
                for (int k = 0; k < a - i; k++) { // all x positions
                    //if it doesn't hit a tree
                    int xMin = (k + 1);
                    int xMax = (k + 1 + i);
                    int yMin = (j + 1);
                    int yMax = (j + 1 + i);
                    boolean good = true;
                    for (int[] tree : t) {
                        if ((tree[0] <= xMax && tree[0] >= xMin) && (tree[1] <= yMax && tree[1] >= yMin)) {
                            good = false;
                        }
                    }
                    if (good) {
                        System.out.println(i + 1);
                        return;
                    }
                }
            }
        }
    }
}