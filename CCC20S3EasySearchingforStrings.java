import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CCC20S3EasySearchingforStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String needle = br.readLine();
        String haystack = br.readLine();

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
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < i + n; j++) {
                    sb.append(haystack.charAt(j));
                }
                uniqueSubstrings.add(sb.toString());
            }
        }

        System.out.println(uniqueSubstrings.size());
    }
}
