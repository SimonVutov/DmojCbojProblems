import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

class TheAlmightyAcorn {
    //class where you input two stirngs and it seeing if the second is part of the first + 1
    public static Boolean input1 (String x, String y) { //x is the first string, y is the second string, y can be partial of x+1
        System.out.println("checking: " + x + " " + y);
        boolean good = true;
        for (int i = 0; i < y.length(); i++) {
            if (!(Character.valueOf(y.charAt(i)).equals(Character.valueOf(Integer.toString( (Integer.parseInt(x) + 1) ).charAt(i))) )) { good = false; System.out.println("failed at: " + i);}
            System.out.println("checking: " + i);
        }
        return good;
    }

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        String n = s.nextLine();
        int smallestNumberLength = 0; //fix issue where starts and ends might not be fully written, with loops, and end checking better
        outerloop:
        for(int i = 1; i <= n.length(); i++) { //loop through check length 1s, 2s, 3s, to n.length()s
            boolean failed = false;
            int checkingThisNumber = 0;
            while(!failed){ //continue checking this one that is i long, and the next thats i long
                System.out.println("checking: " + checkingThisNumber + "checkingThisNumber " + i  + "i " + " ------");
                if (checkingThisNumber * i + i > n.length() && input1(n.substring(checkingThisNumber * i - i, checkingThisNumber * i), n.substring(checkingThisNumber * i, n.length()))) {
                    System.out.println("succeeded at: " + checkingThisNumber * i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + 2 * i);
                    smallestNumberLength = i;
                    break outerloop;
                } else if (checkingThisNumber * i + 2 * i > n.length() && input1(n.substring(checkingThisNumber * i, checkingThisNumber * i + 1), n.substring(checkingThisNumber * i + 1, n.length()))) { // && n.substring(checkingThisNumber * i, checkingThisNumber * i + i).equals(n.substring(checkingThisNumber * i + i, checkingThisNumber * i + 2 * i))
                    System.out.println("succeeded at: " + checkingThisNumber * i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + 2 * i);
                    smallestNumberLength = i;
                    break outerloop;
                } else if (checkingThisNumber * i + 2 * i > n.length()){
                    failed = true;
                } else if (!n.substring(checkingThisNumber * i, checkingThisNumber * i + i).equals(Integer.toString( (Integer.parseInt(n.substring(checkingThisNumber * i + i, checkingThisNumber * i + 2 * i)) - 1) ) )) {
                    System.out.println("failed at: " + checkingThisNumber * i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + 2 * i);
                    System.out.println(n.substring(checkingThisNumber * i, checkingThisNumber * i + i) + " " + n.substring(checkingThisNumber * i + i, checkingThisNumber * i + 2 * i));
                    failed = true;
                }
                System.out.println("checking: " + checkingThisNumber * i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + i + " " + checkingThisNumber * i + 2 * i);
                System.out.println(n.substring(checkingThisNumber * i, checkingThisNumber * i + i) + " " + n.substring(checkingThisNumber * i + i, checkingThisNumber * i + 2 * i));
                checkingThisNumber++;
            }
        }

        System.out.println(smallestNumberLength);
    }
}