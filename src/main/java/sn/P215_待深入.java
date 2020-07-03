package sn;

import java.util.Arrays;

/**
 * 找出排序后数组第N大的数字
 * 待深入
 */
public class P215_待深入 {

    public static void main(String[] args) {
        P215_待深入 p = new P215_待深入();
        int[] a = {1, 0, 2, 4, 7, 6, 2, 4, 8, 9};
        System.out.println(p.__findKthLargest(a, 2));
        //System.out.println(Arrays.toString(a));
    }


    public int _findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int m = k;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            m--;
            if (m == 0) {
                return nums[k - 1];
            }
        }
        return -1;
    }

    public int __findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }


}
