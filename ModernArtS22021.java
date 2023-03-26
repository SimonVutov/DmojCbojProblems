import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class ModernArtS22021 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args)
    {
        int rows = s.nextInt();
        int cols = s.nextInt();
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];
        int totalC = 0;
        int totalR = 0;
        int k = s.nextInt();
        int total = 0;

        for (int i = 0; i < k; i++){
            String type = s.next();
            int num = s.nextInt();
            if (type.equals("R")){
                if (!row[num - 1]){
                    totalR++;
                    row[num - 1] = true;
                    total += cols - 2 * totalC;
                    //System.out.println("adding");
                } else {
                    totalR--;
                    row[num - 1] = false;
                    total -= cols - 2 * totalC;
                    //System.out.println("subtracting");
                }
            }
            else{
                if (!col[num - 1]){
                    totalC++;
                    col[num - 1] = true;
                    total += rows - 2 * totalR;
                    //System.out.println("c adding");
                } else {
                    totalC--;
                    col[num - 1] = false;
                    total -= rows - 2 * totalR;
                    //System.out.println("c subtracting");
                }
            }
            //System.out.println("total: " + total + " totalC: " + totalC + " totalR: " + totalR + " row: " + Arrays.toString(row) + " col: " + Arrays.toString(col));
        }
        System.out.println(total);
    }
}