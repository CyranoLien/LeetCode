package leetcode.local;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Method1 is brute force and Method2 is based on hash table */

public class Num1_TwoSum {
    public int[] method1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] method2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int[] answ;
        int target = 9;

        Num1_TwoSum solution = new Num1_TwoSum();
        answ = solution.method2(nums, target);

        System.out.println(Arrays.toString(answ));
    }
}
