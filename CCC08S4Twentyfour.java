import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC08S4Twentyfour {
    public static Scanner s = new Scanner(System.in);
    public static double[] check (double[] arr) {
        ArrayList<Double> allOutcomes = new ArrayList<Double>();

        if (arr.length == 1) {
            allOutcomes.add(arr[0]);
            return allOutcomes.stream().mapToDouble(i -> i).toArray();
        }

        for (int i = 0; i < arr.length; i++) {
            double a = arr[i];
            double[] p = new double[arr.length - 1];

            for (int j = 0; j < arr.length; j++) {
                if (j < i) p[j] = arr[j];
                else if (j > i) p[j - 1] = arr[j];
            }

            for (Double k : check(p)) {
                allOutcomes.add(a + k);
                allOutcomes.add(a - k);
                allOutcomes.add(a * k);
                allOutcomes.add(k - a);
                
                if (k != 0) allOutcomes.add(a / k);
                if (a != 0) allOutcomes.add(k / a);
            }
        }

        return allOutcomes.stream().mapToDouble(i -> i).toArray();
    }

    public static void main(String[] args) {
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            double[] nums = new double[4];
            for (int j = 0; j < 4; j++) nums[j] = s.nextInt();
            double[] allOutcomes = check(nums);
            double best = 0;
            for (double j : allOutcomes) if (j > best && j <= 24 && j % 1 == 0) best = j;

            System.out.println(Math.round(best));
        }
    }
}