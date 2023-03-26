import java.util.Scanner;
import java.io.*;
import java.util.*;

//https://cboj.ca/problem/wacalmightyacorn
public class TheAlmightyAcorn6 { 
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
        if (x.equals("1")) return "0";
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
        String z = addOne(x);
        for (int i = 0; i < y.length(); i++) {
            if (z.charAt(i) != y.charAt(i)) return false;
        }
        return true;
    }
    public static boolean compareFromEnd (String x, String y) {
        if (x.equals("")) return true;
        if (Integer.parseInt(x) == 0 || Integer.parseInt(y) == 0) return false;
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
        for (int i = 0; i < n.length(); i++) {
            boolean done = false;
            for (int j = 0; j < i; j++) {
                boolean good = true;
                int lengthIncreased = 0;
                int start = 0;
                int end = 0;
                String x = n.substring(0, j);
                String y = "";
                boolean firstTime = true;
                int loops = (int) Math.ceil(n.length() / i);
                while ((i + (loops-1)*(i) - j) < n.length()) loops++;
                for (int k = 0; k < loops; k+= 1 + lengthIncreased) {
                    if (addOne(n.substring(start, end)).length() > i + lengthIncreased) lengthIncreased++;
                    start = Math.max(k*(i) - j, 0);
                    end = Math.min(i + k*(i) - j, n.length());
                    y = n.substring(start, end);
                    System.out.print(" |" + y + " ");
                    if (!firstTime) {
                        if (!compareFromFront(x, y)) { good = false; System.out.print("f"); }
                    } else {
                        if (!compareFromEnd(x, y)) { good = false; System.out.print("f"); }
                        if (x.length() == y.length() && x.length() == i) { firstTime = false; System.out.print(x.length() + " " + y.length()); }
                    }
                    x = y;
                }
                System.out.println();
                if (good) {
                    done = true;
                    list.add(n.substring(0 + j, Math.min(i + j, n.length())));
                    offsets.add(Integer.toString(j));
                }
            }
            System.out.println(i);
            System.out.println();
            if (done) break outerLoop;
        }

        System.out.println(list);

        if (list.size() == 0) {
            String x = n;
            for (int i = 0; i < n.length(); i++) {
                System.out.println(x);
                if (x.charAt(0) == '0') continue;
                if (n.charAt(0) == '9' && i == 0) continue;
                list.add(x);
                offsets.add(Integer.toString(i));
                x = x.substring(1) + x.charAt(0);
            }
        }

        // add the 98 is 7980 if empty

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
                } else {
                    list.remove(1);
                    offsets.remove(1);
                    break;
                }
            }
        }
        
        if (list.size() == 0) { list.add(n); offsets.add("0"); }
        String answer = list.get(0);
        int offset = Integer.parseInt(offsets.get(0));
        System.out.println(answer + " " + offset + " " + offsets.size());
        return Integer.toString(((NumToIndex(answer) + offset)));
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
            }
            counter++;
        }
        return lastNum;
    }
    public static void main(String[] args)
    {
        String n = s.nextLine();
        System.out.println(NumToAnswer(n));
        /*
        for (int i = 0; i < 1000; i++) {
            n = Integer.toString(i);
            String x = NumToAnswer(n);
            String y = Integer.toString(answer(n));
            System.out.println(i + " n" + x + " y" + y);
            if (!x.equals(y)) {
                System.out.println("ERROR --------------------------------");
            }
        }*/
        
    }
}