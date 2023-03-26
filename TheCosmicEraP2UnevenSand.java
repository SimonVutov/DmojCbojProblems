import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class TheCosmicEraP2UnevenSand {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        long x = 1000000000;
        long y = 500000000;
        System.out.println(x);
        String n = s.nextLine();
        while(n != "OK"){
            if(n.equals("FLOATS")){
                x = x - y;
                y = Math.max(y/2, 1);
            }
            else if(n.equals("SINKS")){
                x = x + y;
                y = Math.max(y/2, 1);
            }
            System.out.println(x);
            System.out.flush();
            n = s.nextLine();
        }
    }
}