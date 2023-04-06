import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC01S4Cookies {
    public static Scanner s = new Scanner(System.in);
    public static d(int x, int y, int x1, int y1)
    {
        return Math.sqrt( (Math.pow(x - x1, 2) + Math.pow(y - y1, 2)) );
    }
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int[][] l = new int[n][2];

        for (int i = 0; i < n; i++) {
            l[i][0] = s.nextInt();
            l[i][1] = s.nextInt();
        }

        double max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    
                }
            }
        }

        System.out.println(String.format("%.2f", max));
    }
}