package arrays;

public class FindFirstAndLastPositionOfElement {

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int firstIndex = findIndex(nums, target, left, right);

        if (firstIndex != -1) {
            int leftIndex = firstIndex;
            int rightIndex = firstIndex;
            int temp;
            if (leftIndex > 0 && nums[leftIndex - 1] == target) {
                temp = findIndex(nums, target, left, firstIndex - 1);
                while (temp != -1) {
                    leftIndex = temp;
                    temp = findIndex(nums, target, left, temp - 1);
                }
            }

            if (rightIndex < nums.length - 1 && nums[rightIndex + 1] == target) {
                temp = findIndex(nums, target, firstIndex + 1, right);
                while (temp != -1) {
                    rightIndex = temp;
                    temp = findIndex(nums, target, temp + 1, right);
                }
            }
            return new int[] {leftIndex, rightIndex};
        }

        return new int[]{-1, -1};
    }

    private static int findIndex(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = Math.round(right + left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,8,8};
        int target = 8;
        int[] result = searchRange(nums, target);
        for (Integer i: result) {
            System.out.println(i);
        }
    }
}
