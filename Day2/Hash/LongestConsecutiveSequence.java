package Hash;


import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums1));

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2));

        int[] nums3 = {1, 2, 3, 4};
        System.out.println(longestConsecutive(nums3));

        int[] nums4 = {4, 3, 2, 1};
        System.out.println(longestConsecutive(nums4));

        int[] nums5 = {1, 1, 1};
        System.out.println(longestConsecutive(nums5));

        int[] nums6 = {};
        System.out.println(longestConsecutive(nums6));
    }
}


