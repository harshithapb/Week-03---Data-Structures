package StackQueue;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] findSlidingWindowMaximum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = findSlidingWindowMaximum(nums1, k1);
        System.out.println("Array: " + Arrays.toString(nums1) + ", k: " + k1);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result1));

        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        int[] result2 = findSlidingWindowMaximum(nums2, k2);
        System.out.println("Array: " + Arrays.toString(nums2) + ", k: " + k2);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result2));

        int[] nums3 = {5, 4, 3, 2, 1};
        int k3 = 3;
        int[] result3 = findSlidingWindowMaximum(nums3, k3);
        System.out.println("Array: " + Arrays.toString(nums3) + ", k: " + k3);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result3));

        int[] nums4 = {1};
        int k4 = 1;
        int[] result4 = findSlidingWindowMaximum(nums4, k4);
        System.out.println("Array: " + Arrays.toString(nums4) + ", k: " + k4);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result4));

        int[] nums5 = {1, 3, -1};
        int k5 = 1;
        int[] result5 = findSlidingWindowMaximum(nums5, k5);
        System.out.println("Array: " + Arrays.toString(nums5) + ", k: " + k5);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result5));

        int[] nums6 = {1, 3, -1};
        int k6 = 4;
        int[] result6 = findSlidingWindowMaximum(nums6, k6);
        System.out.println("Array: " + Arrays.toString(nums6) + ", k: " + k6);
        System.out.println("Sliding Window Maximum: " + Arrays.toString(result6));
    }
}

