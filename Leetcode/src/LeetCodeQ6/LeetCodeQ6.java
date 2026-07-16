import java.util.Scanner;

public class LeetCodeQ6 {

    public static String convert(String s, int numRows) {

        // Edge cases
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Build zigzag rows
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction at first and last row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        // Input number of rows
        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        // Convert and print result
        String ans = convert(s, numRows);

        System.out.println("Converted String: " + ans);

        sc.close();
    }
}