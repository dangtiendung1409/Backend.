package demo2;

import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen n: ");
        int n = input.nextInt();
        int fibo = fibonacci(n);
        System.out.println("So Fibonacci tai vi tri thu " + n + " la: " + fibo);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}