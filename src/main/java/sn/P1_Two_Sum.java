package sn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Wendell
 * @Date 2020-6-30  11:01:10
 */
public class P1 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 5, 7};
        int b = 9;
        System.out.println(Arrays.toString(twoSum(a, b)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(target - nums[i])) {
                return new int[]{i, container.get(target - nums[i])};
            }
            container.put(nums[i], i);
        }
        return null;
    }
}
