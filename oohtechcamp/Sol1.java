package oohtechcamp;

public class Sol1 {
    public static void main(String[] args) {
        System.out.println(factorial(30));
    }

    public static long factorial(long n) {
        if (n <= 1) return 1;

        return n * factorial(n - 1);
    }
}
