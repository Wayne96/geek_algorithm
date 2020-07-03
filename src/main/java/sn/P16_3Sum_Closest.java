package sn;

import java.util.Arrays;

/**
 * 三数之和最近的那个数
 *
 * @author Wendell
 * @Date 2020-6-24  11:17:16
 */
public class P16_3Sum_Closest {

    public static void main(String[] args) {
        P16_3Sum_Closest p = new P16_3Sum_Closest();
        //[1,2,4,8,16,32,64,128]
        //82
        int[] a = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(p.myFast(a, 82));
    }


    public int _no_skip_duplicate_elem_threeSumClosest(int[] nums, int target) {
        // initial result
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            int next = i + 1;
            int last = nums.length - 1;
            while (next < last) {
                int sum = nums[i] + nums[next] + nums[last];
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    last--;
                }
                if (sum < target) {
                    next++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public int _skip_duplicate_elem_threeSumClosest(int[] nums, int target) {
        // initial result
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int next = i + 1;
            int last = nums.length - 1;
            while (next < last) {
                int sum = nums[i] + nums[next] + nums[last];
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    last--;
                    while (last > next && nums[last] == nums[last + 1]) {
                        last--;
                    }

                }
                if (sum < target) {
                    next++;
                    while (next < last && nums[next] == nums[next - 1]) {
                        next++;
                    }
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public int fast(int[] nums, int target) {
        int delta = Integer.MAX_VALUE;//delta record Math.abs(3sum - target)
        int threeSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int twoSumTarget = target - nums[i];
            int low = nums[i + 1] + nums[i + 2];
            int high = nums[nums.length - 1] + nums[nums.length - 2];
            if (twoSumTarget == low || twoSumTarget == high) return target;
            else if (twoSumTarget < low) {// if twoTarget can't be reached, and even smaller than all the cases
                if (low - twoSumTarget < delta) {
                    threeSum = low + nums[i];
                    delta = low - twoSumTarget;
                }
            } else if (twoSumTarget > high) {// if twoTarget can't be reached, and even larger than all the cases
                if (twoSumTarget - high < delta) {
                    threeSum = high + nums[i];
                    delta = twoSumTarget - high;
                }
            } else {
                int start = i + 1;        //O(n) two pointers to scan the array
                int end = nums.length - 1;
                while (start < end) {
                    int twoSum = nums[start] + nums[end];
                    if (twoSum == twoSumTarget) return target;
                    else if (twoSum < twoSumTarget) {
                        if (twoSumTarget - twoSum < delta) {
                            delta = twoSumTarget - twoSum;
                            threeSum = twoSum + nums[i];
                        }
                        start++;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                    } else {
                        if (twoSum - twoSumTarget < delta) {
                            delta = twoSum - twoSumTarget;
                            threeSum = twoSum + nums[i];
                        }
                        end--;
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    }
                }
            }
        }
        return threeSum;
    }


    public int myFast(int[] nums, int target) {
        int abs = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int sum = nums[1] + nums[0] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int next = i + 1;
            int end = nums.length - 1;
            int twoSumTarget = target - nums[i];
            int twoSumSmallest = nums[next] + nums[next + 1];
            int towSumBiggest = nums[end] + nums[end - 1];
            if (twoSumSmallest == twoSumTarget || towSumBiggest == twoSumTarget) {
                return target;
            }
            if (twoSumTarget < twoSumSmallest) {
                int tempAbs = Math.abs(twoSumSmallest + nums[i] - target);
                if (tempAbs < abs) {
                    abs = tempAbs;
                    sum = twoSumSmallest + nums[i];
                }
            } else if (twoSumTarget > towSumBiggest) {
                int tempAbs = Math.abs(towSumBiggest + nums[i] - target);
                if (tempAbs < abs) {
                    abs = tempAbs;
                    sum = towSumBiggest + nums[i];
                }
            } else {
                while (next < end) {
                    int twoSum = nums[next] + nums[end];
                    if (twoSum == twoSumTarget) {
                        return target;
                    }
                    if (twoSum < twoSumTarget) {
                        next++;
                        while (next < end && nums[next] == nums[next - 1]) {
                            next++;
                        }
                    }

                    if (twoSum > twoSumTarget) {
                        end--;
                        while (next < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    }

                    if (Math.abs(twoSum + nums[i] - target) < abs) {
                        sum = twoSum + nums[i];
                        abs = Math.abs(twoSum + nums[i] - target);
                    }
                }
            }
        }
        return sum;
    }

}
