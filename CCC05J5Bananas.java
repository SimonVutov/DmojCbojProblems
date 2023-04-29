import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CCC05J5Bananas {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            String stri = s.nextLine();
            if (stri.equals("X")) return;
            innerloop:
            while (true) {
                if (stri.indexOf("ANA") == -1 && stri.indexOf("BAS") == -1) break innerloop;
                stri = stri.replace("ANA", "A");
                stri = stri.replace("BAS", "A");
            }
            if (stri.equals("A")) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}