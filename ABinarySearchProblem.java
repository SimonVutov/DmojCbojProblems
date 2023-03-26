import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class ABinarySearchProblem {
    public static Scanner s = new Scanner(System.in);
    public static int binarySearch(int[] a, int x)
    {
        int left = 0;
        int right = a.length;
        int tmp = 0;
        while(right - left > 0){
            int mid = (left + right) / 2;
            if (a[mid] > x) {
                tmp = right;
                right = mid;
                if(tmp == right) return -1;
            }
            else if (a[mid] < x){
                tmp = left;
                left = mid;
                if(tmp == left) return -1;
            }
            else {
                if (mid > 0){
                    while (a[mid - 1] == x) {
                        mid--;
                        if (mid == 0) return mid + 1;
                    }
                    return mid + 1;
                } else return mid + 1;
            }
            
            
        }
        return -1;
    }    
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = s.nextInt();

        int y = s.nextInt();
        int q = -758493;
        int p = 0;
        int lastans = 0;

        for (int i = 0; i < y; i++) {
            p = q;
            q = s.nextInt();
            if (p != q) lastans = binarySearch(a, q);
            System.out.println(lastans);
        }
    }
}