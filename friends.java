import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
//https://dmoj.ca/problem/ccc07s3
public class friends {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int num = s.nextInt();
        int[][] freinds = new int[num][2];
        for (int i = 0; i < num; i++) {
            freinds[i][0] = s.nextInt();
            freinds[i][1] = s.nextInt();
        }

        //ArrayList<int[]> freinds2 = new ArrayList<String>(); // Create an ArrayList object
        int[][] freindsquerries = new int[9999][2];
        for (int i = 0; i < 9999 - 1; i++) {
            freindsquerries[i][0] = s.nextInt();
            freindsquerries[i][1] = s.nextInt();
            if (freindsquerries[i][0] == 0 && freindsquerries[i][1] == 0) break;
        }
        int querries = 0;
        for (int[] is : freindsquerries) if (is[0] != 0 && is[1] != 0) querries++;
        int[][] freinds2 = new int[querries][2];
        for (int i = 0; i < querries; i++) {
            if (freindsquerries[i][0] != 0 && freindsquerries[i][1] != 0) {
                freinds2[i][0] = freindsquerries[i][0];
                freinds2[i][1] = freindsquerries[i][1];
            }
        }

        for (int i = 0; i < querries; i++) {
            int valueOfConnection = freinds2[i][0]; //0 name, 1 freindsname -- valueconnection is name
            int counter = 0;
            outerloop:
            while (valueOfConnection != freinds2[i][1] && (counter < num)){
                if (valueOfConnection == freinds2[i][0] && counter != 0) {
                    System.out.println("No");
                    break outerloop;
                }
                for (int k = 0; k < num; k++) {
                    if (freinds[k][0] == valueOfConnection) {
                        valueOfConnection = freinds[k][1];
                        counter++;
                        k = num;
                    }
                }
                if (valueOfConnection == freinds2[i][1]) {
                    System.out.println("Yes " + (counter - 1));
                    break outerloop;
                }
            }
        }
    }
}