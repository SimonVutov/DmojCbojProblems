import java.io.*;
import java.util.*;

public class ECOO2016R2P1PalindromePanic {
    public static Scanner s = new Scanner(System.in);
    public static boolean check(String string, int index) {
        int leftCheck = index - 1;
        int rightCheck = index + 1;

        while (leftCheck >= 0 && rightCheck < string.length()) {
            if (string.charAt(leftCheck) != string.charAt(rightCheck)) {
                return false;
            } else {
                leftCheck--;
                rightCheck++;
            }
        }

        return true;
    }
    public static boolean checkLeftRight(String string, int left, int right) {
        while (left >= 0 && right < string.length()) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            } else {
                left--;
                right++;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] ans = new int[10];
        for (int m = 0; m < 1; m++) {
            String str = s.nextLine();
            double length = str.length();
            int leftCheck = (int)Math.floor(length / 2d);
            int rightCheck = (int)Math.ceil(length / 2d);

            innerloop:
            while (leftCheck >= 0 && rightCheck < str.length()) {
                if (checkLeftRight(str, leftCheck, leftCheck + 1)) {
                    ans[m] = str.length() - 2*(leftCheck) - 1;
                    break innerloop;

                } else if (checkLeftRight(str, rightCheck - 1, rightCheck)) {
                    ans[m] = str.length() - 2*(str.length() - rightCheck - 1);
                    break innerloop;

                } else if (check(str, leftCheck)) {
                    if (checkLeftRight(str, leftCheck - 1, leftCheck)) {
                        ans[m] = str.length() - 2*(leftCheck) - 2;
                    } else ans[m] = str.length() - 2*(leftCheck) - 1;
                    break innerloop;

                } else if (check(str, rightCheck)) {
                    if (checkLeftRight(str, rightCheck - 1, rightCheck)) {
                        ans[m] = str.length() - 2*(str.length() - rightCheck - 1);
                    } else ans[m] = str.length() - 2*(str.length() - rightCheck - 1) + 1;
                    break innerloop;
                } 
                leftCheck--;
                rightCheck++;
            }
        }
        for (int i = 0; i < 1; i++) {
            System.out.println(ans[i]);
        }
    }
}
