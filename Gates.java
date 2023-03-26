import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://dmoj.ca/problem/ccc15s3
public class Gates {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int m = s.nextInt();
        int[] gates = new int[m];
        for(int i = 0; i < m; i++) gates[i] = s.nextInt();
        int[] landedPlanes = new int[n];
        int landedPlane = 0;
        outerloop:
        for(int i = 0; i < m; i++) {
            int checkThisIndex = gates[i] - 1;
            boolean done = false;
            
            while (!done){
                if (checkThisIndex < 0){
                    done = true;
                    break outerloop;
                } else if (landedPlanes[checkThisIndex] == 0){
                    landedPlanes[checkThisIndex] = gates[i];
                    landedPlane++;
                    done = true;
                } else {
                    checkThisIndex--;
                }
            }
        }
        System.out.println(landedPlane);
    }
}