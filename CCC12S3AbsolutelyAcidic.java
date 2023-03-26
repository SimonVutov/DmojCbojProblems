import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class CCC12S3AbsolutelyAcidic {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int n = s.nextInt();
        int[] x = new int[1000];

        for (int i = 0; i < n; i++){
            int y = s.nextInt();
            x[y]++;
        }

        int popularCount = 0;
        int secondPopularCount = 0;

        for (int i = 0; i < 1000; i++){
            if (x[i] > popularCount){
                secondPopularCount = popularCount;
                popularCount = x[i];
            }
            if (secondPopularCount < x[i] && x[i] < popularCount){
                secondPopularCount = x[i];
            }
        }

        int smallestPopularNum = 0;
        int smallestSecondPopularNum = 0;
        int largestPopularNum = 0;
        int largestSecondPopularNum = 0;

        for (int i = 0; i < 1000; i++){
            if (x[i] == secondPopularCount){
                if (smallestSecondPopularNum == 0){
                    smallestSecondPopularNum = i;
                }
                largestSecondPopularNum = i;
            }

            if (x[i] == popularCount){
                if (smallestPopularNum == 0){
                    smallestPopularNum = i;
                }
                largestPopularNum = i;
            }
        }
        System.out.println(Math.max(Math.abs(smallestSecondPopularNum - largestPopularNum), Math.abs(largestSecondPopularNum - smallestPopularNum)));
    }
}