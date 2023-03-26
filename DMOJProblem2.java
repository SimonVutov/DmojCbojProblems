import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;

class Cereal {
    int c;
    int t;
    public Cereal(int c, int t){
        this.c = c;
        this.t = t;
    }
}

public class DMOJProblem2 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int N = s.nextInt();
        int C = s.nextInt();
        int K = s.nextInt();
        Cereal[] arr = new Cereal[N]; //0 is c, 1 is t

        for(int i = 0; i < N; i++){
            arr[i] = Cereal(s.nextInt(), s.nextInt());
        }

        int canBuy = 0;

        while (C > 0){
            if (C - arr[canBuy].c >= 0){
                C -= arr[canBuy].c;
                canBuy++;
            }
            else break;
        }

        System.out.println(canBuy);
    }
}