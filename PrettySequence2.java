import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class PrettySequence2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int V = s.nextInt();
        int totalSum = 1;
        
        int lastNum = 1;
        while (totalSum < V){
            int multiple = 2;
            System.out.println("totalSum: " + totalSum + " lastNum: " + lastNum);
            while ((V - totalSum - lastNum*multiple) % (lastNum*multiple) != 0 && multiple < 20 && !((lastNum*multiple > V/2) || (totalSum + lastNum*multiple == V)) ) //while the (V - totalSum - lastNum*multiple) % lastNum * multiple != 0: multiple++
            {
                System.out.println("newNumTryingToFind: " + lastNum*multiple);
                multiple++;
            }
            lastNum = lastNum * multiple;
            totalSum += lastNum;
            System.out.println(lastNum + " " + multiple + " // " + totalSum);
        }
    }
}