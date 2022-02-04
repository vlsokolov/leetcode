package arrays;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length-1, nums.length - k);
//        return sorted[nums.length - k];
    }

    private static int sort(int[] nums, int start, int end, int elementIndex) {
        if (end > start) {
            int pivot = nums[end];
            int i = start;
            int j = start;
            while (j < end) {
                if (nums[j] < pivot) {
                    swap(nums, i, j);
                    i++;
                }
                j++;
            }
            swap(nums, i, end);
            if (i > elementIndex) {
                sort(nums, start, i-1, elementIndex);
            } else if (i < elementIndex) {
                sort(nums, i + 1, end, elementIndex);
            }
            return nums[elementIndex];
        }
        return nums[elementIndex];
    }

    private static void swap(int[] nums, int i, int j) {
        int number = nums[i];
        nums[i] = nums[j];
        nums[j] = number;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,1,6,4,2};
        int result = findKthLargest(nums, 1);
//        for (Integer i: result) System.out.println(i);
        System.out.println(result);
    }
}
