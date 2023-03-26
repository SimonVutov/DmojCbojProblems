import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class TheGenevaConfection {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int k = s.nextInt();
        String[] arr = new String[k];
        
        for (int i = 0; i < k; i++){
            int m = s.nextInt();

            Stack st = new Stack();
            Stack bn = new Stack();

            for (int j = 0; j < m; j++){
                int n = s.nextInt();
                st.add(n);
            }

            while((int)st.peek() != 1) bn.add(st.pop()); //move all but 1 to bn

            for(int j = 1; j <= m; j++){
                if (!st.isEmpty()) if ((int)st.peek() == j) { st.pop(); continue; }
                if (!bn.isEmpty()) if ((int)bn.peek() == j) { bn.pop(); continue; }
                
                if (bn.contains(j)){
                    arr[i] = "N";
                    break;
                }

                if (st.contains(j)){
                    while((int)st.peek() != j){
                        bn.add(st.pop());
                    }
                    st.pop(); //then take it off
                }
            }
        }

        for (int i = 0; i < k; i++){
            if (arr[i] == null) System.out.println("Y");
            else System.out.println("N");
        }
    }
}