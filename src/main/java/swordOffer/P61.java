package swordOffer;

import java.util.Arrays;

public class P61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            } else {
                if (nums[i] + 1 != nums[i + 1]) {
                    c = nums[i + 1] - nums[i] - 1;
                    if (count >= c && c >= 0) {
                        count = count - c;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P61 p = new P61();
        int[] a = {0, 0, 2, 2, 5};
        System.out.println(p.isStraight(a));
    }
}
