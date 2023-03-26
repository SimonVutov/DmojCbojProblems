import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://cboj.ca/problem/cbojr3p1
public class CBOJWinterContestProblem1CyclicIsomers {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int x = s.nextInt();
        s.nextLine();
        int [] a = new int [x];
        for (int i = 0; i < x; i++) a[i] = s.nextInt();
        //System.out.println(Arrays.toString(a));

        int n = x;

        for (int i = 1; i <= x; i++){
            boolean good = true;
            for (int j = 1; j <= x/i - 1; j++){
                if (x%i == 0) {
                    //System.out.println(i + " " + j + "           " + (i*j - i) + " " + (i*j) + "               " + Arrays.toString(Arrays.copyOfRange(a, i*j-i, i*j) ) + " " + Arrays.toString(Arrays.copyOfRange(a, i*j, i*j+i)));
                    if (Arrays.equals(Arrays.copyOfRange(a, i*j-i, i*j), (Arrays.copyOfRange(a, i*j, i*j+i)))) {
                        //System.out.println(Arrays.toString(Arrays.copyOfRange(a, i*j-i, i*j) ) + " " + Arrays.toString(Arrays.copyOfRange(a, i*j, i*j+i)));
                        
                    } else {
                        good = false;
                    }
                }
            }
            if (good && x%i == 0) {
                n = i;
                break;
            }
        }

        System.out.println(n);
    }
}