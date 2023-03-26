import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class Theacorn {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {   
        String n = s.nextLine();
        int index = 1;
        String current = "1";
        while (!current.contains(n)) {
            index++;
            current += Integer.toString(index);
        }
        System.out.println(current.indexOf(n) + 1);
    }
}