// Md Istiaq Ahmed


import java.util.Scanner;

public class PrimeNumClock {
    public static void main(String[] args) {
        // Array to store the values
        int[] values = {8000000, 10000000, 12000000, 14000000, 16000000, 18000000};

        // Perform calculations for algorithm
        long[][] executionTimes = new long[3][values.length];

        for (int i = 0; i < values.length; i++) {
            int n = values[i];

            // Program 22.5
            long startTime = System.currentTimeMillis();
            findPrimeNumbers22_5(n);
            long endTime = System.currentTimeMillis();
            executionTimes[0][i] = endTime - startTime;

            // Program 22.6
            startTime = System.currentTimeMillis();
            findPrimeNumbers22_6(n);
            endTime = System.currentTimeMillis();
            executionTimes[1][i] = endTime - startTime;

            // Program 22.7
            startTime = System.currentTimeMillis();
            findPrimeNumbers22_7(n);
            endTime = System.currentTimeMillis();
            executionTimes[2][i] = endTime - startTime;
        }

        // Print the table header
        System.out.println("Algorithm\t8000000\t10000000\t12000000\t14000000\t16000000\t18000000");
        System.out.println("--------------------------------------------------------------");

        // Print the execution times
        String[] algorithms = {"Listing 22.5", "Listing 22.6", "Listing 22.7"};
        for (int i = 0; i < algorithms.length; i++) {
            System.out.print(algorithms[i] + "\t");
            for (int j = 0; j < values.length; j++) {
                System.out.print(executionTimes[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void findPrimeNumbers22_5(int n) {
        final int NUMBER_PER_LINE = 10;
        int count = 0;
        int number = 2;

        while (number <= n) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= (int) (Math.sqrt(number)); divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
            number++;
        }
    }

    public static void findPrimeNumbers22_6(int n) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        final int NUMBER_PER_LINE = 10;
        int count = 0;
        int number = 2;
        int squareRoot = 1;

        while (number <= n) {
            boolean isPrime = true;
            if (squareRoot * squareRoot < number) squareRoot++;

            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                list.add(number);
            }
            number++;
        }
    }

    public static void findPrimeNumbers22_7(int n) {
        boolean[] primes = new boolean[n + 1];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false;
                }
            }
        }
    }
}
