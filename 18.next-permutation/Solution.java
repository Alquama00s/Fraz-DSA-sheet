import java.util.*;

class Solution {
    // shift the peak to left
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        int i = nums.length - 2, temp;
        // find peak
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        i++;
        // if peak is at the peeginning reverse
        if (i == 0) {
            int l = nums.length-1;
            while (i < l) {
                temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l--;
                i++;
            }
            return;
        }
        // find element just greater then elements at i-1
        int minIndex = i;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > nums[i - 1] && nums[j] < nums[i]) {
                minIndex = j;
            }
        }
        //swap and sort
        temp=nums[i-1];
        nums[i-1]=nums[minIndex];
        nums[minIndex]=temp;
        Arrays.sort(nums,i,nums.length);

    }
}
