package arrays;

public class MaximumWaterArea {

    public static int calculateSquare(int[] height) {
        int result = 0;
        int p1 = 0;
        int p2 = height.length - 1;

        while (p1 < p2) {
            int min = Math.min(height[p1], height[p2]);
            int square = min * (p2 - p1);
            result = Math.max(result, square);
            if (height[p1] == min) {
                p1++;
            } else {
                p2--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 8, 1, 2, 3, 9};
        System.out.println(calculateSquare(numbers));
    }
}
