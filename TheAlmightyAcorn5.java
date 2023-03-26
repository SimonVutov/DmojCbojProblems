import java.util.Scanner;
import java.io.*;
import java.util.*;

//https://cboj.ca/problem/wacalmightyacorn
public class TheAlmightyAcorn5 {
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
        if (x.equals("1")) return "";
        while (true) {
            int last = Integer.parseInt(Character.toString(x.charAt(x.length() - 1)));
            if (last == 0) {
                return minnusOne(x.substring(0, x.length() - 1)) + "9";
            } else {
                return x.substring(0, x.length() - 1) + Integer.toString(last - 1);
            }
        }
    }
    public static boolean compareFromFront (String x, String y) {
        if (Integer.parseInt(x) == 0) return false;
        String z = addOne(x);
        for (int i = 0; i < y.length(); i++) {
            if (z.charAt(i) != y.charAt(i)) return false;
        }
        return true;
    }
    public static boolean compareFromEnd (String x, String y) {
        String z = minnusOne(y);
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(x.length() - 1 - i) != z.charAt(z.length() - 1 - i)) return false;
        }
        return true;
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
    public static String NumToAnswer (String n) {
        if (n.equals("0")) return "11";
        if (n.length() == 1) return n;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> offsets = new ArrayList<String>();
        outerLoop:
        for (int i = 0; i < n.length(); i++) { //i starting digit lengths
            boolean done = false;
            for (int j = 0; j < i; j++) { //j starting offsets
                boolean good = true;
                int lengthIncreased = 0;
                int start = 0;
                int end = 0;
                String x = n.substring(0, j);
                String y = "";
                boolean firstTime = true;
                for (int k = 0; k < n.length(); k += i + lengthIncreased) { //k all positions with that start length and offset
                    if (addOne(n.substring(start, end)).length() > i + lengthIncreased) lengthIncreased++;
                    start = k + j;
                    end = k + i + j + lengthIncreased;
                    if (start < 0) start = 0;
                    if (end < 0) end = 0;
                    if (start > n.length()) start = n.length() - 1;
                    if (end > n.length()) end = n.length();
                    y = n.substring(start, end);
                    System.out.print(" | _" + x + " _" + y + " _" + addOne(x) + " _" + minnusOne(y));
                    if (!firstTime) {
                        if (compareFromFront(x, y)) {
                        } else { good = false; System.out.print("f"); }
                    } else {
                        if (compareFromEnd(x, y)) {
                        } else { good = false; System.out.print("f"); }
                        firstTime = false;
                    }
                    x = y;
                }
                System.out.println();
                if (good) {
                    done = true;
                    list.add(n.substring(0 + j, Math.min(i + j, n.length())));
                    System.out.println("added " + n.substring(0 + j, Math.min(i + j, n.length())) + " " + j + " " + i);
                    offsets.add(Integer.toString(j));
                }
            }
            if (done) break outerLoop;
        }

        System.out.println(list);

        while (list.size() > 1) {
            for (int i = 0; i < list.get(0).length() - 1; i++) {
                if (Integer.parseInt(Character.toString(list.get(0).charAt(i))) < Integer.parseInt(Character.toString(list.get(1).charAt(i)))) {
                    list.remove(1);
                    offsets.remove(1);
                    break;
                } else if (Integer.parseInt(Character.toString(list.get(0).charAt(i))) > Integer.parseInt(Character.toString(list.get(1).charAt(i)))) {
                    list.remove(0);
                    offsets.remove(0);
                    break;
                }
            }
        }

        String answer = "";
        int offset = 0;
        if (!list.isEmpty()) {
            answer = list.get(0);
            offset = Integer.parseInt(offsets.get(0));
        }
        else { 
            answer = n;
            offset = 0;
        }
        System.out.println(answer + " " + offset);
        while (Character.toString(answer.charAt(0)).equals("0")) {
            answer = answer.substring(1, answer.length()) + "0";
        }
        return Integer.toString(((NumToIndex(answer) - offset)));
    }
    public static int answer(String n){
        String [] nums = new String[10000];
        boolean done = false;
        int counter = 1;
        int lastNum = 0;
        while (!done) {
            nums[counter - 1] = Integer.toString(counter);
            String a = Arrays.toString(nums);
            a = a.replaceAll(", ", "");
            if (a.indexOf(n) != -1) {
                done = true;
                lastNum = a.indexOf(n);
                //System.out.println("   " + a);
            }
            //System.out.println(a);
            counter++;
        }
        return lastNum;
    }
    public static void main(String[] args)
    {
        String n = s.nextLine();
        System.out.println(NumToAnswer(n) + " " + answer(n));
    }
}