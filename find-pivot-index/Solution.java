import java.util.*;
class Solution {
    public int pivotIndex(int[] nums) {
        int ltSum = Arrays.stream(nums).reduce(0,(v,e)->v+e);
        int rtSum=0,ans=-1;
        for (int i = 0; i < nums.length; i++) {
            if(rtSum == ltSum-nums[i]){
                ans=i;
                break;
            }
            ltSum-=nums[i];
            rtSum+=nums[i];
        }
        
        return ans;
    }
}