import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;
//https://dmoj.ca/problem/ccc16s5
//january 11 2023
public class S52016CircleofLife {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int steps = s.nextInt();
        boolean[] arr = new boolean[n];
        ArrayList<boolean[]> allarrs = new ArrayList<boolean[]>();
        s.nextLine();
        String str = s.nextLine();

        for(int i = 0; i < n; i++){
            if (str.charAt(i) == '1') arr[i] = true;
            else arr[i] = false;
        }

        for (int i = 0; i < steps; i++){
            boolean[] arr2 = new boolean[n];
            for (int j = 0; j < n; j++){
                if (j == 0){
                    if (arr[n - 1] == arr[j + 1]) arr2[j] = false;
                    else arr2[j] = true;
                }
                else if (j == n - 1){
                    if (arr[j - 1] == arr[0]) arr2[j] = false;
                    else arr2[j] = true;
                }
                else{
                    if (arr[j - 1] == arr[j + 1]) arr2[j] = false;
                    else arr2[j] = true;
                }
            }
            allarrs.add(arr);
            arr = arr2;

            System.out.print(i + 1 + " ");
            for (int j = 0; j < n; j++){
                if (arr[j]) System.out.print("1");
                else System.out.print("0");
            }
            
            for(int k = 0; k < allarrs.size() - 1; k++){
                if (Arrays.equals(allarrs.get(k), arr)){
                    System.out.print(" " + k);
                }
            }
            System.out.println();
        }
    }   
}