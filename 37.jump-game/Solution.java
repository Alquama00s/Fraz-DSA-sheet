import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int maxR=nums[0];
        for(int i=1;i<nums.length && maxR<nums.length-1;i++){
            if(i<=maxR){
                maxR=Math.max(maxR,i+nums[i]);
            }else{
                break;
            }
        }
        if(maxR>=nums.length-1){
            return true;
        }
        return false;
    }
}