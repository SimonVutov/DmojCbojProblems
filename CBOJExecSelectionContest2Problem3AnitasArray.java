import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CBOJExecSelectionContest2Problem3AnitasArray {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        float x = s.nextFloat();
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) arr[i] = s.nextFloat();

        float LargestNum = 0;
        for (int i =  0; i < n; i++) {
            int currentSum = 0;
            int j = i;
            while (currentSum < x && j < n) {
                if (currentSum + arr[j] < x) currentSum += arr[j];
                j++;
            }
            LargestNum = Math.max(LargestNum, currentSum);
        }

        if (LargestNum == 0) System.out.println("-1");
        else System.out.println(String.format("%.0f", LargestNum));
    }
}