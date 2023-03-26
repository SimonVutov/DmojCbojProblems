import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class PrettySequence3 {
    public static Scanner s = new Scanner(System.in);

    public static Integer find(int V){
        Stack<Integer> nums = new Stack<Integer>();
        nums.push(1);
        nums.push(V - 1);
        boolean good = false;

        if (V == 1){
            return 1;
        }
        if (V == 2){
            return -1;
        }
        if (V == 3){
            return 2;
        }
        if (V == 4){
            return 2;
        }
        if (V == 5){
            return 2;
        }
        if (V == 6){
            return 2;
        }

        while (true){
            Integer a = nums.pop();
            Integer b = nums.peek();
            boolean printed = false;
            for (int i = b*2; i < a/2; i+=b){
                good = true;
                if (((a-i) % i == 0) && (i % b == 0)){
                    nums.push(i);
                    nums.push(a-i);
                    printed = true;
                    break;
                }
            }
            if (!printed) nums.push(a);
            System.out.println("        " + nums);
            if (!printed){
                if (good){
                    return nums.size();
                }
                else{
                    return -69;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        //System.out.println(find(s.nextInt()));
        for (int i = 1; i < 1000; i++) System.out.println(i + " " + find(i));
    }
}