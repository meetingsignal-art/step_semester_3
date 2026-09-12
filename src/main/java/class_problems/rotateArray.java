package class_problems;

public class rotateArray {

    public int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;

        k = k % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        return result;
    }
}