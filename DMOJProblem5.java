import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class DMOJProblem5 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int Y = s.nextInt();
        int X = s.nextInt();
        int[][] arr = new int[X][Y];
        int sum = 0;
        boolean done = false;

        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                arr[j][i] = s.nextInt();
                sum += arr[j][i];
            }
        }

        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                arr[j][i] = -s.nextInt();
                sum += arr[j][i];
            }
        }

        //doesnt work, need to actually subtract them

        //check if there are negitives above any positives or if there are negitives to the left any positives
        for(int i = 0; i < Y; i++){
            for(int j = 0; j < X; j++){
                if (arr[j][i] < 0){
                    for(int k = 0; k < i; k++){
                        if (arr[j][k] > 0){
                            if (!done) System.out.println("NO");
                            done = true;
                            return;
                        }
                    }
                    for(int k = 0; k < j; k++){
                        if (arr[k][i] > 0){
                            if (!done) System.out.println("NO");
                            done = true;
                            return;
                        }
                    }
                }
            }
        }

        if (sum >= 0 && !done) System.out.println("YES");
        else if (sum < 0 && !done) System.out.println("NO");
    }
}