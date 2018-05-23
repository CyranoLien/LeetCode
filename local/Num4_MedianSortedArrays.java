package leetcode.local;

public class Num4_MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length, y = nums2.length;

        int[] nums = new int[x + y];
        int i = 0, j = 0, k;
        for (k = 0; k < x + y; k++) {
            if (i < x && j < y) {
                nums[k] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
            }

            else if (i == x) {
                nums[k] = nums2[j++];
            }

            else if (j == y) {
                nums[k] = nums1[i++];
            }
        }
        return  (k % 2 != 0) ? nums[(k - 1) / 2] : (double) (nums[k / 2] + nums[k / 2 - 1]) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };

        Num4_MedianSortedArrays answ = new Num4_MedianSortedArrays();
        System.out.println(answ.findMedianSortedArrays(nums1, nums2));
    }
}
