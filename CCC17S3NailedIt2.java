import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC17S3NailedIt2 {
    public static Scanner s = new Scanner(System.in);

    public static int[] count(int[] arr) {
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int N = s.nextInt();
        int[] arr = new int[N];
        
    }
}