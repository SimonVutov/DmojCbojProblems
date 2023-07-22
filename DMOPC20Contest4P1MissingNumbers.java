import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DMOPC20Contest4P1MissingNumbers {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            long N = s.nextLong();
            long S = s.nextLong();

            double actualSum = ((double)(N) + 1.0) / 2.0 * N;
            double sumOfTwoNum = actualSum - S;
            double largeOne = 0;
            if (sumOfTwoNum > N) largeOne = N;
            else largeOne = sumOfTwoNum - 1;
            double smallOne = sumOfTwoNum - largeOne;

            System.out.println(Math.max(Math.round((largeOne - smallOne) / 2), 0));
        }
    }
}