import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

// Java implementation of the approach
class coin {

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int[] coins = {1, 3, 4};
        int[] arr = new int[100000];
        boolean[] arrcomputed = new boolean[100000];
        arr[0] = 1;

        for (int i = 1; i < 10; i++) {
            for (int j : coins) {
                if (i-j >= 0) {
                    arr[i] += arr[i-j];
                    arrcomputed[i] = true;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (arrcomputed[i]) System.out.println(i);
        }
        
    }
}