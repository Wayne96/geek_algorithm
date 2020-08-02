package mediun_exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> _fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[n] + nums[m];
                    if (target == sum) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[m]);
                        ans.add(nums[n]);
                        list.add(ans);
                        while (m < n && nums[m] == nums[m + 1]) m++;
                        while (m < n && nums[n] == nums[n - 1]) n--;
                        m++;
                        n--;
                    }
                    if (target < sum) {
                        n--;
                    }
                    if (target > sum) {
                        m++;
                    }

                }
            }
        }
        return list;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> l;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 2] < target) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
                int head = j + 1, end = len - 1;
                while (head < end) {
                    int tempt = nums[i] + nums[j] + nums[head] + nums[end];
                    if (tempt == target) {
                        l = new ArrayList();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[head]);
                        l.add(nums[end]);
                        list.add(l);
                        head++;
                        while (head < end && nums[head] == nums[head - 1]) {
                            head++;
                        }
                    } else if (tempt > target) end--;
                    else head++;
                }
            }
        }
        return list;
    }
}
