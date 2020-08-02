package swordOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P39 {
    public int _majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (map.get(nums[i]) > half) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("not found");
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3};
        P39 p = new P39();
        System.out.println(p.majorityElement(a));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int half = nums.length / 2;
        int count = 0;
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (count >= half) {
                    return nums[i];
                } else {
                    count = 0;
                }
            }

        }
        return nums[i];
    }
}
