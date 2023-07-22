import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CBOJExecSelectionContest2Problem1Vowels {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int input = s.nextInt();
        for (int i = 0; i < input; i++) {
            String currentName = s.next();
            int vowelCount = 0;
            for (int j = 0; j < currentName.length(); j++) {
                if (currentName.charAt(j) == 'a' || currentName.charAt(j) == 'e' || currentName.charAt(j) == 'i' || currentName.charAt(j) == 'o' || currentName.charAt(j) == 'u' || currentName.charAt(j) == 'A' || currentName.charAt(j) == 'E' || currentName.charAt(j) == 'I' || currentName.charAt(j) == 'O' || currentName.charAt(j) == 'U') {
                    vowelCount++;
                }
            }
            if (vowelCount <= 2) {
                System.out.println(currentName);
            }
        }
    }
}