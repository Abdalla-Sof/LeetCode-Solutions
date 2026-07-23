import java.util.Scanner;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        if (x < 0) {
            return false;
        }

        int original = x;
        int rev = 0;

        while (x != 0) {

            int digit = x % 10;

            rev = rev * 10 + digit;

            x = x / 10;
        }

        return original == rev;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int x = sc.nextInt();

        boolean result = isPalindrome(x);

        System.out.println(result);

        sc.close();
    }
}