import java.util.Scanner;

public class PublicServiceAnnouncement {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int q = s.nextInt();
        long[] arr = new long[n];
        long prev = 0;
        for (int i = 0; i < n; i++) {
            long x = s.nextLong();
            arr[i] = prev + x;
            prev += x;
        }
        for (int i = 0; i < q; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (a == 1) System.out.println(arr[b - 1]);
            else
            System.out.println(arr[b - 1] - arr[a - 2]);
        }
    }
}
