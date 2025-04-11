package Hash;


import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    public static int[] findTwoSumIndices(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] {numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[] {-1, -1}; // No such pair found
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(findTwoSumIndices(nums1, target1)));

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(findTwoSumIndices(nums2, target2)));

        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println(Arrays.toString(findTwoSumIndices(nums3, target3)));

        int[] nums4 = {1, 2, 3, 4, 5};
        int target4 = 10;
        System.out.println(Arrays.toString(findTwoSumIndices(nums4, target4)));

        int[] nums5 = {1, 5, 9, 12};
        int target5 = 17;
        System.out.println(Arrays.toString(findTwoSumIndices(nums5, target5)));
    }
}



