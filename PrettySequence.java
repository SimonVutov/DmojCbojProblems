import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class PrettySequence {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int V = s.nextInt();
        int totalSum = 1;
        System.out.print(1 + " ");
        while (totalSum < V){
            int multiple = 2;
            int lastNum = 1;
            System.out.println("totalSum: " + totalSum);
            while ((V - totalSum - lastNum * multiple) % (lastNum * multiple) != 0) //while the (V - totalSum - lastNum*multiple) % lastNum * multiple != 0
            {
                multiple++;
            }
            lastNum = lastNum * multiple;
            totalSum += lastNum;
            System.out.print(lastNum + " ");
        }
    }
}