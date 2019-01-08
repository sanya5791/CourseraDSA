package week2;

import java.util.Scanner;

public class Fibonacci {
    public static long calcFibNaive(int n) {
        if (n <= 1)
            return n;

        return calcFibNaive(n - 1) + calcFibNaive(n - 2);
    }

    public static long calcFibFast(int n) {
        if (n <= 1)
            return n;

        long[] fibs = new long[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        return fibs[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calcFibFast(n));
    }
}
