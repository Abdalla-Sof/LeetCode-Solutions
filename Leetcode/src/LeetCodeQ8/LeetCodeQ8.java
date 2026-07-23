import java.util.Scanner;

public class StringToInteger {

    public static int myAtoi(String s) {

        int i = 0;
        int n = s.length();
        int sign = 1;
        int num = 0;

        // Step 1: Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check sign
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        // Step 3: Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Step 4: Overflow check
            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 && digit > 7)) {

                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int result = myAtoi(s);

        System.out.println("Integer value = " + result);

        sc.close();
    }
}