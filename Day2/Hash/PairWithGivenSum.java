package Hash;


import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] nums, int targetSum) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 45, 6, 10, 8};
        int sum1 = 16;
        System.out.println(hasPairWithSum(nums1, sum1));

        int[] nums2 = {1, 4, 45, 6, 10, 8};
        int sum2 = 13;
        System.out.println(hasPairWithSum(nums2, sum2));

        int[] nums3 = {1, 2, 3, 4, 5};
        int sum3 = 10;
        System.out.println(hasPairWithSum(nums3, sum3));

        int[] nums4 = {1, 2, 3, 4, 5};
        int sum4 = 2;
        System.out.println(hasPairWithSum(nums4, sum4));

        int[] nums5 = {};
        int sum5 = 5;
        System.out.println(hasPairWithSum(nums5, sum5));

        int[] nums6 = {5, 5};
        int sum6 = 10;
        System.out.println(hasPairWithSum(nums6, sum6));
    }
}


