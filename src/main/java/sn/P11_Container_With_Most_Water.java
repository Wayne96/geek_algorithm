package sn;

/**
 * Container With Most Water
 * 双指针解法，移动值小的指针
 * 证明为何需要移动小的指针：
 * 设数组为 a，左指针 l，右指针 r，面积为 s，开始时，l = 0,r = a.length-1
 * 情况1：若 a[l] < a[r]，则s = a[l] * (r-l) ; 情况2：若 a[l] >= a[r]，则s = a[r] * (r-l)
 * 假设初始时是情况 1，现在需要让 l(值小的指针)或 r(值大的指针)中的一个或两个进行移动
 * 通过反证来证明为什么要移动小的指针，假设移动大的指针 r
 * 此时计算新值 s1 = min(a[r-1],a[l]) * (r -l - 1)，现在来分析a[r-1] 和 a[l] 大小情况
 * 若 a[r-1] < a[l] ，则 s1 = a[r-1] * (r -l - 1) < s = a[l] * (r-l)
 * 若 a[r-1] >= a[l]，则 s1 = a[l] * (r -l - 1) < s = a[l] * (r-l)
 * 可见，如果我们只移动值大的指针，那么得到的新的s一定比移动前的小！
 * 那么移动值小的指针 l，新得到的 s 就一定比上一次大吗，当然不一定。
 * 但是，当移动小的指针l后，我们必然可以得出上面的结论：即移动大的指针肯定会越来越小。
 * 所以当下一次比较 a[l+1] 和 a[r] 时，只要移动其中小的那个指针即可。
 * 这样根据指针移动将数组遍历一遍，计算每次移动后的s，记录下那个最大的s即可。
 *
 * @author Wedenll
 * @Date 2020-6-25  22:16:38
 */
public class P11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int s = -1;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftH = height[left];
            int rightH = height[right];
            int temp = 0;
            if (leftH > rightH) {
                temp = rightH * (right - left);
                right--;
            }
            if (leftH <= rightH) {
                temp = leftH * (right - left);
                left++;
            }
            s = temp > s ? temp : s;
        }
        return s;
    }
}
