package week2;

import java.util.*;

public class GCD {
    public static int gcdNaive(int a, int b) {
        int current_gcd = 1;
        for(int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    public static int gcdFast(int a, int b) {
        int smallest = a > b ? a : b;

        for (int d = smallest; d > 1; d--) {
            if (a % d == 0 && b % d == 0) {
                return d;
            }
        }
        return 1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcdFast(a, b));
    }
}
