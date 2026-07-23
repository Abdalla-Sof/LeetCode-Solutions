public class Main {

    // Function to find the maximum area
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate current area
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;

            // Update maximum area
            if (area > maxArea) {
                maxArea = area;
            }

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Example input
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Call the function
        int result = maxArea(height);

        // Print the answer
        System.out.println("Maximum Water Area = " + result);
    }
}