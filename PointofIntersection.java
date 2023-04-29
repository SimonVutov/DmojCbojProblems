import java.util.Scanner;

public class PointofIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double l = scanner.nextDouble();
        double r = scanner.nextDouble();

        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        double[] b = new double[m+1];
        for (int i = 0; i <= m; i++) {
            b[i] = scanner.nextInt();
        }

        double mid, f1, f2, eps = 1e-7;
        while (r - l > eps) {
            mid = (l + r) / 2;
            f1 = f2 = 0;
            for (int i = n; i >= 0; i--) {
                f1 = f1 * mid + a[i];
            }
            for (int i = m; i >= 0; i--) {
                f2 = f2 * mid + b[i];
            }
            if (f1 < f2) {
                l = mid;
            } else {
                r = mid;
            }
        }

        System.out.printf("%.8f %.8f", l, r);
    }
}
