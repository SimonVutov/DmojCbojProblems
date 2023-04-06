import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC00S5SheepandCoyotes {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        double[] arr = new double[2*n];
        double minY = Double.MAX_VALUE;
        for (int i = 0; i < 2*n; i++) {
            arr[i] = s.nextDouble();
            if (i%2 == 1) if (arr[i] < minY) minY = arr[i];
        }
        for (int i = 0; i < 2*n; i+=2)
            if (arr[i+1] == minY)
                System.out.println("The sheep at (" + String.format("%.2f", arr[i]) + ", "
                + String.format("%.2f", arr[i+1]) + ") might be eaten.");
    }
}