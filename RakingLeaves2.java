import java.util.Scanner;
import java.io.*;
import java.util.*;

public class RakingLeaves2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int x = s.nextInt();
        int y = s.nextInt();
        int[] z = new int[x];
        long total = 0;
        long max = 0;
        for (int i = 0; i < x; i++) z[i] = s.nextInt();
        for(int i = 0; i < y; i++) total += z[i];
        for (int i = y; i < x; i++){
            max = Math.max(max, total);
            total += z[i];
            total -= z[i - y];
        }
        max = Math.max(max, total);
        System.out.println(max);
    }
}