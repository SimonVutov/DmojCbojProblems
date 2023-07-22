import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCCHK15S2MatchingProblem {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        double a = s.nextInt();
        double b = s.nextInt();
        String as = s.next();
        String bs = s.next();
        String madeA = as;
        String madeB = bs;

        while (madeA.length() != madeB.length()) {
            if (madeA.length() < madeB.length()) madeA += as;
            else madeB += bs;
        }

        double count = 0;
        for (int i = 0; i < madeA.length(); i++) {
            if (madeA.charAt(i) == madeB.charAt(i)) {
                count++;
            }
        }

        System.out.println(count * ((as.length() * a) / madeA.length()));
    }
}