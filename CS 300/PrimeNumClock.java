//Md Istiaq Ahmed

public class PrimeNumClock {

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    
    static long lockPrimes(int limit) {
        long startTime = System.currentTimeMillis();
        for (int i = 2; i < limit; i++) {
            isPrime(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] limits = {8000000, 10000000, 12000000, 14000000, 16000000, 18000000};

        for (int limit : limits) {
            long executionTime = lockPrimes(limit);
            System.out.println("Execution time for limit " + limit + ": " + executionTime + " is  milliseconds");
        }
    }
}
