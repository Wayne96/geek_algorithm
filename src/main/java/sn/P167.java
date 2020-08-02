package sn;

public class P167 {
    public int[] twoSum(int[] numbers, int target) {
        // 二分查找
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start, end};
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }
}
