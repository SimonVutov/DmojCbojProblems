import java.util.Scanner;
import java.io.*;
import java.util.*;

public class BobandBooks {
    public static Scanner s = new Scanner(System.in);
    public static boolean[] visited = new boolean[325];
    public static int minLengthSearch (String goal, String s, int at, int travel, int oldAt) {
        int travell = Math.abs(oldAt - at);
        //System.out.println("travel: " + travel + " travell: " + travell + " oldAt: " + oldAt + " at: " + at);
        int z = Math.min(1, goal.length() - 1);
        if (visited[at]) return 2000000000;
        visited[at] = true;
        //System.out.println("oo  " + goal + " " + s + " " + at + " travel: " + travel);
        int minlength = 2000000000;
        if (at + 1 < s.length()) {
            //System.out.println("/" + Character.toString(s.charAt(at + 1)) + " " + (Character.toString(goal.charAt(0))) + " " + at);
            if (Character.toString(s.charAt(at + 1)).equals(Character.toString(goal.charAt(0)))) {
                System.out.println("yay" + Character.toString(s.charAt(at + 1)) + " " + (Character.toString(goal.charAt(0))));
                if (goal.length() == 1) minlength = travell;
                else minlength = Math.min(minlength, minLengthSearch(goal.substring(z, goal.length()), s, at + 1, travell, at));
            }
        }
        if (at - 1 >= 0) {
            //System.out.println("|" + Character.toString(s.charAt(at - 1)) + " " + (Character.toString(goal.charAt(0))) + " " + at);
            if (Character.toString(s.charAt(at - 1)).equals(Character.toString(goal.charAt(0)))) {
                //System.out.println("yay" + Character.toString(s.charAt(at - 1)) + " " + (Character.toString(goal.charAt(0))));
                if (goal.length() == 1) minlength = travell;
                else minlength = Math.min(minlength, minLengthSearch(goal.substring(z, goal.length()), s, at - 1, travell, at));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (i != at) if (Character.toString(s.charAt(i)).equals(Character.toString(s.charAt(at)))) {
                //System.out.println("-" + Character.toString(s.charAt(i)) + " hehe yeah " + (Character.toString(s.charAt(at))));
                if (goal.length() == 1) minlength = travell;
                else minlength = Math.min(minlength, minLengthSearch(goal, s, i, travell, at));
            }
        }

        return minlength + travell;
    }
    public static void main(String[] args)
    {
        int a = s.nextInt();
        int b = s.nextInt();
        s.nextLine();
        String c = s.nextLine();
        String d = s.nextLine();
        int min = 2000000000;
        for (int i = 0; i < c.length(); i++) {
            if (Character.toString(c.charAt(i)).equals(Character.toString(d.charAt(0)))) {
                min = Math.min(minLengthSearch(d.substring(1, d.length()), c, i, 1, i), min);
            }
        }
        if (min == 2000000000) min = -1;
        System.out.println(min);
    }
}