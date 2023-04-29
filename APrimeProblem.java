import java.util.*;

public class APrimeProblem {
    public static int countPrimes(int a, int b) {
        // Create a boolean array, with indices representing the numbers from a to b.
        boolean[] isPrime = new boolean[b - a + 1];
    
        // Initialize all values to true, since we assume all numbers are prime until proven otherwise.
        Arrays.fill(isPrime, true);
    
        // 1 is not a prime number, so mark it as composite.
        if (a == 1) {
            isPrime[0] = false;
            a++;
        }
    
        // Find all primes between 2 and sqrt(b), and mark their multiples as composite.
        for (int i = 2; i <= Math.sqrt(b); i++) {
            int j = Math.max(i*i, ((a+i-1)/i)*i);
            while (j <= b) {
                isPrime[j-a] = false;
                j += i;
            }
        }
    
        // Count the number of primes between a and b.
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }
    
        return count;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(countPrimes(a, b));
        }
    }
}
