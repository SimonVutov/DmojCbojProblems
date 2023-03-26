import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://cboj.ca/problem/wacalmightyacorn
public class TheAlmightyAcorn4 {
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
            else if (i < 10000) indexCounter+=4;
        }
        return indexCounter;
    }
    public static Boolean CheckFrontStringy (String x, String y) { //starts in 9 100 101 (100 9) true
        for (int i = 0; i < y.length(); i++) {
            if (minnusOne(x).charAt(x.length() - 1 - i) != y.charAt(y.length() - 1 - i)) return false;
        }
        return true;
    }
    public static Boolean CheckBackStringy (String x, String y) { //ends in 99 100 10 (100 10) true
        for (int i = 0; i < Math.min(y.length(), x.length()); i++) {
            if (addOne(x).charAt(i) != y.charAt(i)) return false;
        }
        return true;
    }
    public static String st (String x, int length, int indexi, int offsetj){
        return(x.substring(offsetj + indexi * length, offsetj + (indexi + 1) * length));
    }
    public static int l (String x, String y) { // -1 for left and 1 for right is larger
        if (x.length() > y.length()) return -1;
        else if (x.length() < y.length())return 1;
        int i = 0;
        while (true){
            if (Character.getNumericValue(x.charAt(i)) > Character.getNumericValue(y.charAt(i))) return -1;
            else if (Character.getNumericValue(x.charAt(i)) < Character.getNumericValue(y.charAt(i))) return 1;
            else i++;
        }
    }
    public static int CheckIntsThisLong (String x, int length){
        boolean print = false;
        if(print)System.out.println("Checking with " + x + " " + length + " ");
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < Math.min(length, x.length() - length + 1); j++) {
            int substringLength = length;
            boolean goodInThisCase = true;
            if(print)System.out.println("      check starting " + x.substring(j, j + substringLength) + " " + x.substring(0, j));
            if (!CheckFrontStringy(x.substring(j, j + substringLength), x.substring(0, j))) goodInThisCase = false;
            int i = 0;
            int ends = 0;
            innerloop:
            while (true) { //while loop to check each consecutive pair of numbers of length substringLength
                if (j + (i + 1) * substringLength > x.length()) {
                    if(print)System.out.print("      -/-" + st(x, substringLength, i - 1, j) + " " + st(x, substringLength, i, j));
                    if (!CheckBackStringy(st(x, substringLength, i - 1, j), st(x, substringLength, i, j))) goodInThisCase = false;
                    ends = 1;
                    if (addOne(st(x, substringLength, i, j)).length() > substringLength) substringLength++; 
                    break innerloop;
                } else if (j + (i + 1) * substringLength + substringLength > x.length()) { break innerloop; }
                else {
                    if(print)System.out.print("      -|-" + st(x, substringLength, i, j) + " " + st(x, substringLength, i + 1, j));
                    if (!CheckBackStringy(st(x, substringLength, i, j), st(x, substringLength, i + 1, j))) goodInThisCase = false;
                    if (addOne(st(x, substringLength, i + 1, j)).length() > substringLength) substringLength++;
                }
                if (j + (i + 1) * substringLength + substringLength >= x.length()) break innerloop;
                i++;
            } if(print)System.out.println();
            
            if(print)System.out.println("     check ending " + x.substring(j + (i + ends) * substringLength, j + (i + ends) * substringLength + substringLength) + " " + x.substring(j + (i + ends) * substringLength + substringLength, x.length()));
            if (!CheckBackStringy(x.substring(j + (i + ends) * substringLength, j + (i + ends) * substringLength + substringLength), x.substring(j + (i + ends) * substringLength + substringLength, x.length()))) goodInThisCase = false;
            if(print)System.out.println(goodInThisCase + " adding " + j);
            if (goodInThisCase) list.add(j);
        }
        String submission = null;
        for (Integer integer : list) {
            if(print)System.out.println("     " + integer);
            if (submission == null) submission = Integer.toString(integer);
            if (l(x.substring(integer, integer + length), submission) == -1) submission = Integer.toString(integer);
        }

        if (submission.length() <x.length()){
            if(print)System.out.println("returning " + submission);
            if (submission == null) return -1;
            else return Integer.parseInt(submission);
        } else return getAnswer2(x);
        
    }
    public static int getAnswer(String n){
        int i = 1;
        while(CheckIntsThisLong(n, i) == -1 && i < n.length()) {
            //System.out.println("this time it is " + CheckIntsThisLong(n, i));
            if (CheckIntsThisLong(n, i) != -1) break;
            //System.out.println("Checked with " + n + " n i " + i + " " + CheckIntsThisLong(n, i));
            i++;
        }
        //System.out.println(n.substring(CheckIntsThisLong(n, i), CheckIntsThisLong(n, i) + i) + " - " + CheckIntsThisLong(n, i));
        return NumToIndex(n.substring(CheckIntsThisLong(n, i), CheckIntsThisLong(n, i) + i)) - CheckIntsThisLong(n, i);
    }
    public static int getAnswer2(String x){
        int len = x.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < x.length(); i++) { // 3 4 5 6 7 loops 5 times
            for (int j = 1; j <= i; j++) { // 67 345 loops 1,2,3,4 times
                if (len - i - j >= 0){
                    //System.out.println(" info " + i + " " + j + " " + len + " len - i - j " + (len - i - j) + " len - i " + (len - i) + " len - i + j " + (len - i + j) + " ");
                    String y = x.substring(i, x.length()) + x.substring(0, i);
                    String left = y.substring(len - i - j, len - i);
                    String right = y.substring(len - i, len - i + j);
                    //System.out.println(" " + y + " |" + left + " |" + right);
                    if (left.equals(right) && len > 2) {
                        //System.out.println(x.substring(i, x.length()-1) + x.substring(0, i));
                        String a = x.substring(i, x.length()-1) + x.substring(0, i);
                        list.add((Integer.parseInt( a + Integer.toString(j))));
                    }else if (x.charAt(x.length() - 1) != '0') {
                        list.add((Integer.parseInt(y + Integer.toString(j))));
                    }
                } 
            }
        }
        if (list.isEmpty()) return 2147483647;
        //System.out.println("smallest " + Collections.min(list));
        System.out.println(Integer.parseInt( Integer.toString(Collections.min(list)).substring(0, x.length()) ) + " + " + Integer.parseInt( Integer.toString(Collections.min(list)).substring(x.length(), x.length() + 1) ));
        return NumToIndex(Integer.toString(Integer.parseInt( Integer.toString(Collections.min(list)).substring(0, x.length()) ) + Integer.parseInt( Integer.toString(Collections.min(list)).substring(x.length(), x.length() + 1) ))) - 1;
    }
    public static void main(String[] args)
    {
        String n = s.nextLine();
        String answer = getAnswer(n);

        System.out.println(answer);
        //for (int i = 1; i < 110; i++) System.out.println(i + " " + Math.min(getAnswer(Integer.toString(i)), getAnswer2(Integer.toString(i))) + " 1||| " + getAnswer(Integer.toString(i)) + " 2||| " + getAnswer2(Integer.toString(i)));
    }
}