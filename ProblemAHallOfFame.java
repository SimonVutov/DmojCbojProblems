import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class ProblemAHallOfFame {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int t = s.nextInt();
        //boolean[] ans = new boolean[n];

        for(int i = 0; i < t; i++){
            int n = s.nextInt();
            String st = s.nextLine();

            boolean[] arr = new boolean[n];
            
            for (boolean b : arr) {
                b = false;
            }

            for(int j = 0; j < n; j++){
                if (st.charAt(i) == 'L'){
                    for(int k = 0; k < j; k++){
                        arr[k] = true;
                    }
                }

                if (st.charAt(i) == 'R'){
                    for(int k = j + 1; k < n; k++){
                        arr[k] = true;
                    }
                }
            }
        }
    }
}