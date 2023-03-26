import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class TheAlmightyAcorn2 {
    public static Scanner s = new Scanner(System.in);
    public static String addOne (String x) {
        if (x.length() == 0) return "1";
        while (true) {
            int last = Integer.parseInt(Character.toString(x.charAt(x.length() - 1)));
            if (last == 9) {
                return addOne(x.substring(0, x.length() - 1)) + "0";
            } else {
                return x.substring(0, x.length() - 1) + Integer.toString(last + 1);
            }
        }
    }
    public static String minnusOne (String x) {
        if (x.length() == 0) return "-1";
        while (true) {
            int last = Integer.parseInt(Character.toString(x.charAt(x.length() - 1)));
            if (last == 0) {
                return minnusOne(x.substring(0, x.length() - 1)) + "9";
            } else {
                return x.substring(0, x.length() - 1) + Integer.toString(last - 1);
            }
        }
    }
    public static int NumToIndex (String x) {
        int y = Integer.parseInt(x);
        int indexCounter = 0;
        for (int i = 0; i < y; i++) {
            if (i < 10) indexCounter++;
            else if (i < 100) indexCounter+=2;
            else if (i < 1000) indexCounter+=3;
        }
        return indexCounter;
    }
    public static Boolean CheckFront (String x, String y) { //starts in 9 100 101 (100 9) true
        String z = Integer.toString( (Integer.parseInt(x) - 1) );
        //System.out.println(z + "checking: " + x + " " + y + " " + y.length() + " " + x.length());
        for (int i = 0; i < y.length(); i++) {
            //System.out.println("checks: " + i + " " + Character.valueOf(y.charAt(i)) + " " + Character.valueOf(z.charAt(i)));
            if (!(Character.valueOf(y.charAt(y.length() - 1 - i)).equals(Character.valueOf(z.charAt(z.length() - 1 - i))) )) {
                //System.out.println("failed at: " + i + " " + Character.valueOf(y.charAt(y.length() - 1 - i)) + " " + Character.valueOf(z.charAt(x.length() - 1 - i)));
                return false;
            }
        }
        return true;
    }
    public static Boolean CheckBack (String x, String y) { //ends in 99 100 10 (100 10) true
        String z = Integer.toString( (Integer.parseInt(x) + 1) );
        //System.out.println(z + "checking: " + x + " " + y + " " + y.length() + " " + x.length());
        for (int i = 0; i < y.length(); i++) {
            //System.out.println("checks: " + i + " " + Character.valueOf(y.charAt(i)) + " " + Character.valueOf(z.charAt(i)));
            if (!(Character.valueOf(y.charAt(i)).equals(Character.valueOf(z.charAt(i))) )) {
                //System.out.println("failed at: " + i + " " + Character.valueOf(y.charAt(i)) + " " + Character.valueOf(z.charAt(i)));
                return false;
            }
        }
        return true;
    }
    public static Boolean CheckFrontStringy (String x, String y) { //starts in 9 100 101 (100 9) true
        for (int i = 0; i < y.length(); i++) {
            if (minnusOne(x).charAt(x.length() - 1 - i) != y.charAt(y.length() - 1 - i)) return false;
        }
        return true;
    }
    public static Boolean CheckBackStringy (String x, String y) { //ends in 99 100 10 (100 10) true
        for (int i = 0; i < y.length(); i++) {
            if (addOne(x).charAt(i) != y.charAt(i)) return false;
        }
        return true;
    }
    public static int CheckIntsThisLong (String x, int length){
        System.out.println("Checking with " + x + " " + length + " ");
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < Math.min(length, x.length() - length + 1); j++) {
            boolean goodInThisCase = true;
            if (j > 0 && j + length < x.length()) System.out.println("      check starting " + x.substring(j, j + length) + " " + x.substring(0, j));
            if (j > 0 && j + length < x.length()) if (!CheckFrontStringy(x.substring(j, j + length), x.substring(0, j))) goodInThisCase = false;
            int i = 0;
            int ends = 0;
            innerloop:
            while (true) {
                if (j + (i + 1) * length > x.length()) {
                    System.out.print("      -/-" + x.substring(j + i * length - length, j + i * length) + " " + x.substring(j + i * length, j + i * length + length));
                    if (!CheckBackStringy(x.substring(j + i * length - length, j + i * length), x.substring(j + i * length, j + i * length + length))) goodInThisCase = false;
                    ends = 1;
                    break innerloop;
                } else if (j + (i + 1) * length + length > x.length()) break innerloop;
                else {
                    System.out.print("      -|-" + x.substring(j + i * length, j + i * length + length) + " " + x.substring(j + (i + 1) * length, j + (i + 1) * length + length));
                    if (!CheckBackStringy(x.substring(j + i * length, j + i * length + length), x.substring(j + (i + 1) * length, j + (i + 1) * length + length))) goodInThisCase = false;
                }
                if (j + (i + 1) * length + length >= x.length()) break innerloop;
                i++;
            } System.out.println();
            
            if (j > 0) System.out.println("     check ending " + x.substring(j + (i + ends) * length, j + (i + ends) * length + length) + " " + x.substring(j + (i + ends) * length + length, x.length()));
            if (j > 0) if (!CheckBackStringy(x.substring(j + (i + ends) * length, j + (i + ends) * length + length), x.substring(j + (i + ends) * length + length, x.length()))) goodInThisCase = false;
            //WHAT IF YOU FIND ANOTHER 2 DIGIT THAT IS SMALLER THAN THE FIRST 2 DIGIT, make arrey and compare yeye
            if (goodInThisCase) list.add(j);
        }
        int submission = -1;
        for (Integer integer : list) {
            if (submission == -1) submission = integer.intValue();
            int numberCurrent = Integer.parseInt(x.substring(integer, integer + length));
            if (numberCurrent > submission) submission = integer;
        }
        System.out.println("returning " + submission);
        return submission;
    }
    public static void main(String[] args)
    {
        String n = s.nextLine();
        int i = 1;
        while(CheckIntsThisLong(n, i) == -1 && i < n.length()) {
            System.out.println("this time it is " + CheckIntsThisLong(n, i));
            if (CheckIntsThisLong(n, i) != -1) break;
            System.out.println("Checked with " + n + " n i " + i + " " + CheckIntsThisLong(n, i));
            i++;
        }
        System.out.println(n.substring(CheckIntsThisLong(n, i), CheckIntsThisLong(n, i) + i) + " - " + CheckIntsThisLong(n, i));
        System.out.println(NumToIndex(n.substring(CheckIntsThisLong(n, i), CheckIntsThisLong(n, i) + i)) - CheckIntsThisLong(n, i));
    }
}