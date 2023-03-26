import java.util.*;

public class MaximumSocialDistance2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int lo = 0;
        int hi = a[n-1] - a[0];
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int lastPos = 0;
            int cnt = 1;
            for (int i = 1; i < n && cnt < m; i++) {
                if (a[i] - a[lastPos] >= mid) {
                    lastPos = i;
                    cnt++;
                }
            }
            if (cnt >= m) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
