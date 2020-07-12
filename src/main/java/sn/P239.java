package sn;

import java.util.ArrayDeque;
import java.util.Arrays;

public class P239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] maxNums = new int[nums.length - k + 1];
        int index = 0;
        // 放角标
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 只放角标为 i-k+1 到 i 范围的角标
            while (!q.isEmpty() && q.getFirst() < i - k + 1) q.pollFirst();
            // 若当前窗口里的i指针的值大 小的元素角标就出栈
            while (!q.isEmpty() && nums[q.getLast()] < nums[i]) q.pollLast();
            // 大元素角标入栈
            q.addLast(i);
            // 前面已经处理完该窗口的最大值 放入数组即可 切记是栈低到栈顶！
            if (i >= k - 1) {
                maxNums[index++] = nums[q.getFirst()];
            }
        }
        return maxNums;
    }

    public int[] _maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];
        if (k == 1) return nums;
        int[] result = new int[nums.length - k + 1];
        int max = -2147483648, j = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) max = nums[i];
        }
        result[j++] = max;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                result[j++] = max;
            } else if (max != nums[i - k]) {
                result[j++] = max;
            } else {
                max = -2147483648;
                for (int m = i - k + 1; m <= i; m++) {
                    if (nums[m] > max) max = nums[m];
                }
                result[j++] = max;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P239 p = new P239();
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(p.maxSlidingWindow(a, 3)));
    }
}
