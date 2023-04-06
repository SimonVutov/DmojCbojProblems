import java.io.*;
import java.util.*;

public class CCC20S3EasySearchingforStrings {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String needle = s.nextLine();
        String haystack = s.nextLine();

        int n = needle.length();
        int[] needleFreq = new int[26];

        // Calculate frequency of each character in needle
        for (int i = 0; i < n; i++) {
            needleFreq[needle.charAt(i) - 'a']++;
        }

        Set<String> uniqueSubstrings = new HashSet<>();

        int[] windowFreq = new int[26];

        // Slide the window over the haystack
        for (int i = 0; i < haystack.length() - n + 1; i++) {
            // Update frequency array for current window
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    windowFreq[haystack.charAt(j) - 'a']++;
                }
            } else {
                windowFreq[haystack.charAt(i - 1) - 'a']--;
                windowFreq[haystack.charAt(i + n - 1) - 'a']++;
            }

            // Check if frequency arrays match
            boolean match = true;
            for (int j = 0; j < 26; j++) {
                if (windowFreq[j] != needleFreq[j]) {
                    match = false;
                    break;
                }
            }

            // If there's a match, add substring to set
            if (match) {
                uniqueSubstrings.add(haystack.substring(i, i + n));
            }
        }

        System.out.println(uniqueSubstrings.size());
    }
}
