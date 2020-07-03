package Util;

public class Loop {

    public static void main(String[] args) {
        Loop p = new Loop();
        System.out.println(p.findRepeatNumber(new int[]{1, 2, 1}));

    }


    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // double loop
    public void doubleLoop(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
            for (int j = i + 1; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            break;
        }
    }

    public void tribeLoop(int[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            System.out.print(a[i] + " ");
            for (int j = i + 1; j < a.length - 1; j++) {
                System.out.print(a[j] + " ");
                for (int k = j + 1; k < a.length; k++) {
                    System.out.print(a[k] + " ");
                }
                break;
            }
            break;
        }
    }

    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

}
