package assignment_problems;

public class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If array is not rotated or has only one element
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare with rightmost element to determine which half contains minimum
            if (nums[mid] > nums[right]) {
                // Minimum must be in right half (excluding mid)
                left = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }
}