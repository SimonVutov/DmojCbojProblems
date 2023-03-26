import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;
//https://dmoj.ca/problem/ccc16s5
//january 11 2023
public class S52016CircleofLife2 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        long steps = s.nextInt();
        boolean[] arr = new boolean[n];
        boolean notfoundloop = true;
        int looplength = 1;
        ArrayList<boolean[]> allarrs = new ArrayList<boolean[]>();
        s.nextLine();
        String str = s.nextLine();

        for(int i = 0; i < n; i++){
            if (str.charAt(i) == '1') arr[i] = true;
            else arr[i] = false;
        }
        allarrs.add(arr);
        int loopstart = 0;
        long answer = 0;

        int currentCheck = 0;
        while (notfoundloop && currentCheck < steps + 1){
            currentCheck++;
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
            arr = arr2;
            allarrs.add(arr);

            //for (int j = 0; j < n; j++){ if (arr[j]) System.out.print("1"); else System.out.print("0"); }
            innerloop:
            for(int k = 0; k < allarrs.size() - 1; k++){
                if (Arrays.equals(allarrs.get(k), arr)){
                    notfoundloop = false;
                    loopstart = k;
                    looplength = allarrs.size() - k;
                    System.out.print(" " + k);
                    break innerloop;
                }
            }
            //System.out.println();
            if (currentCheck == steps) { answer = allarrs.size() - 1; break; }
        }

        ///System.out.println(steps + " " + currentCheck);

        if (steps > loopstart) steps = steps - (long)loopstart;

        if (currentCheck != steps) answer = steps % (long)looplength - 1;
        
        //if (currentCheck != steps) System.out.println(allarrs.size() + " " + looplength + " " + steps + " " + loopstart + " " + answer);
        if (answer > allarrs.size() - 1) answer = answer - (long)allarrs.size();

        for (boolean b : allarrs.get(Math.toIntExact(answer))) { if (b) System.out.print("1"); else System.out.print("0"); }
    }   
}