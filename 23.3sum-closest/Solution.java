import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[] { 1, 2, 0, 1, 1 }, 2));
    }

    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0]+nums[1]+nums[2];
        if(nums.length>3){
            int i,j;
            int tempSum;
            Arrays.sort(nums);
            for (int j2 = 0; j2 < nums.length-2; j2++) {
                i=j2+1;
                j=nums.length-1;
                while (i<j) {
                    tempSum=(nums[i]+nums[j]+nums[j2]);
                    if(tempSum==target)return tempSum;
                    if(Math.abs(target-tempSum)<Math.abs(ans-target)){
                        ans=tempSum;
                    }
                    if(tempSum>target){
                        j--;
                    }else{
                        i++;
                    }
                    
                }
            }
        }
        return ans;
    }
}