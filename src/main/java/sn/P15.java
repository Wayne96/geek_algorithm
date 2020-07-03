package sn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) return list;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int target = -nums[i];
            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                if (target == nums[m] + nums[n]) {
                    list.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    while (m < n && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    while (m < n && nums[n] == nums[n - 1]) {
                        n--;
                    }
                    m++;
                    n--;
                } else if (nums[m] + nums[n] < target) {
                    m++;
                } else {
                    n--;
                }

            }
        }
        return list;
    }


}
