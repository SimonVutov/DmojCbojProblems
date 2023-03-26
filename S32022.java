import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

public class S32022 {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        s.nextLine();
        String str = s.nextLine();
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) ch[i] = str.charAt(i);
        int counter = 0;
        int counter2 = 0;

        for(int i = 1; i < 2 * n; i++){
            if (ch[i] == 'U' && ch[i - 1] == 'U') counter++;
            if (ch[i] == 'I' && ch[i - 1] == 'I') counter2++;
        }

        if (str.charAt(0) == 'U') counter++;

        if (counter2 > counter) System.out.println(counter2);
        else System.out.println(counter);
    }   
}