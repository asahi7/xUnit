package xUnit;

import java.util.Scanner;

public class Fibonacci
{

    public int find(int n) throws IllegalArgumentException
    {
        if (n < 1) {
            throw new IllegalArgumentException("Argument for Fibonacci method must be within [1..]");
        }
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        int a = 0, b = 1, result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) throws Exception
    {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(new Fibonacci().find(n));
        }
    }

}
