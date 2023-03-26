import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://cboj.ca/problem/wacalmightyacorn
public class TheAlmightyAcorn3 {
    public static Scanner s = new Scanner(System.in);
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
        System.out.println(answer(n));
    }
}