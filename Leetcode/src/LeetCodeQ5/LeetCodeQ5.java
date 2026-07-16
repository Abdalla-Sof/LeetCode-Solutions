import java.util.Scanner;

public class LeetCodeQ5 {

    private static int start = 0;
    private static int maxLen = 1;

    public static void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }

            left--;
            right++;
        }
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        start = 0;
        maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            expand(s, i, i);

            // Even-length palindrome
            expand(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(longestPalindrome(s));

        sc.close();
    }
}