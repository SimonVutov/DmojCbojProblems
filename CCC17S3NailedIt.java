import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC17S3NailedIt{
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nectInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++ ) { 
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);

        
    }
}