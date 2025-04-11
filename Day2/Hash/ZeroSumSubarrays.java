package Hash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarrays {

    public static List<List<Integer>> findZeroSumSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        sumMap.put(0, List.of(-1));
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumMap.containsKey(currentSum)) {
                for (int startIndex : sumMap.get(currentSum)) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int k = startIndex + 1; k <= i; k++) {
                        subarray.add(nums[k]);
                    }
                    result.add(subarray);
                }
            }
            sumMap.computeIfAbsent(currentSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, -3, 3, -2, -1};
        System.out.println(findZeroSumSubarrays(nums1));

        int[] nums2 = {4, -2, -3, 4, 1};
        System.out.println(findZeroSumSubarrays(nums2));

        int[] nums3 = {0, 0, 0};
        System.out.println(findZeroSumSubarrays(nums3));

        int[] nums4 = {1, -1, 5, -5};
        System.out.println(findZeroSumSubarrays(nums4));

        int[] nums5 = {1, 2, 3};
        System.out.println(findZeroSumSubarrays(nums5));
    }
}

