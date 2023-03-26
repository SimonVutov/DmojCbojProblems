import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class CCC19S3ArithmeticSquare {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        Integer[][] n = new Integer[3][3];
        for (int i = 0; i < 3; i++){
            String line = s.nextLine();  
            String[] words = line.split(" ");
            for (int j = 0; j < 3; j++){
                if (!words[j].equals("X")) n[i][j] = Integer.parseInt(words[j]);
                else n[i][j] = null;
            }
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (n[i][0] != null && n[i][1] != null) n[i][2] = n[i][1] - n[i][0] + n[i][1]; //left right
                else if (n[i][1] != null && n[i][2] != null) n[i][0] = n[i][1] - (n[i][2] - n[i][1]);
                else if (n[i][0] != null && n[i][2] != null) n[i][1] = (n[i][2] + n[i][0])/2;

                if (n[0][i] != null && n[1][i] != null) n[2][i] = n[1][i] - n[0][i] + n[1][i]; //up done
                else if (n[1][i] != null && n[2][i] != null) n[0][i] = n[1][i] - (n[2][i] - n[1][i]);
                else if (n[0][i] != null && n[2][i] != null) n[1][i] = (n[2][i] + n[0][i])/2;
            }
        }

        int done = 0;
        int[][] spots = new int[2][3];
        //for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (n[i][j] == null) { spots[done][0] = i; spots[done][1] = j; spots[done][2] = n[i][j]; done++; }
        //if (done == 2){

//        }

        boolean needsFilling = false;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (n[i][j] == null) needsFilling = true;
        
        if(needsFilling){
            if (n[0][2] == null) n[0][2] = n[2][0];
            else if (n[2][0] == null) n[2][0] = n[0][2];
            else if (n[2][2] == null) n[2][2] = n[0][0];
            else if (n[0][0] == null) n[0][0] = n[2][2];

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    if (n[i][0] != null && n[i][1] != null) n[i][2] = n[i][1] - n[i][0] + n[i][1]; //left right
                    else if (n[i][1] != null && n[i][2] != null) n[i][0] = n[i][1] - (n[i][2] - n[i][1]);
                    else if (n[i][0] != null && n[i][2] != null) n[i][1] = (n[i][2] + n[i][0])/2;
    
                    if (n[0][i] != null && n[1][i] != null) n[2][i] = n[1][i] - n[0][i] + n[1][i]; //up done
                    else if (n[1][i] != null && n[2][i] != null) n[0][i] = n[1][i] - (n[2][i] - n[1][i]);
                    else if (n[0][i] != null && n[2][i] != null) n[1][i] = (n[2][i] + n[0][i])/2;
                }
            }
        }

        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (n[i][j] == null) needsFilling = true;
        else needsFilling = false;

        int singleNum = 0;
        if (needsFilling) {
            boolean fillUp = false;
            int[] numsLeftToRight = new int[3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (n[j][i] != null) { numsLeftToRight[i] = n[j][i]; singleNum = n[j][i]; };
                }
            }
            if ((numsLeftToRight[0] < numsLeftToRight[1] && numsLeftToRight[1] < numsLeftToRight[2]) || (numsLeftToRight[0] > numsLeftToRight[1] && numsLeftToRight[1] > numsLeftToRight[2])) fillUp = true;
            else fillUp = false;

            if (fillUp) {
                for (int i = 0; i < 3; i++) { //left right fill
                    if (n[0][i] != null) { n[1][i] = n[0][i]; n[2][i] = n[0][i]; }
                    else if (n[1][i] != null) { n[0][i] = n[1][i]; n[2][i] = n[1][i]; }
                    else if (n[2][i] != null) { n[0][i] = n[2][i]; n[1][i] = n[2][i]; }
                }
            } else {
                for (int i = 0; i < 3; i++) { //left right fill
                    if (n[i][0] != null) { n[i][1] = n[i][0]; n[i][2] = n[i][0]; }
                    else if (n[i][1] != null) { n[i][0] = n[i][1]; n[i][2] = n[i][1]; }
                    else if (n[i][2] != null) { n[i][0] = n[i][2]; n[i][1] = n[i][2]; }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (n[j][i] == null) n[j][i] = singleNum;
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }
}