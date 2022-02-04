package arrays;

public class TrappingRainwater {

    public static int calculateTrappingWaterVolume(int[] height) {
        int result = 0;
        int p1 = 0;
        int p2 = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (p1 < p2) {
            if (height[p1] <= height[p2]) {
                if (maxLeft > height[p1]) {
                    result += maxLeft - height[p1];
                } else {
                    maxLeft = height[p1];
                }
                p1++;
            } else {
                if (maxRight > height[p2]) {
                    result += maxRight - height[p2];
                } else {
                    maxRight = height[p2];
                }
                p2--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        int[] numbers1 = {5, 0, 3, 0, 0, 0, 2, 3, 4, 2, 1};
        System.out.println(calculateTrappingWaterVolume(numbers));
        System.out.println(calculateTrappingWaterVolume(numbers1));
    }
}
