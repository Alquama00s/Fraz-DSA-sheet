import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        int ind;
        
        for(int i=0;i<nums.length;i++){
            ind=Collections.binarySearch(arr,nums[i]);
            if(ind<0)ind=-(ind+1);
            if(ind==arr.size())arr.add(nums[i]);
            else arr.set(ind,nums[i]);
        }
        
        return arr.size();
        
    }
}