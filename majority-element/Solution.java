class Solution {
    public int majorityElement(int[] nums) {
        int count =0,num = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num)count++;
            else{
                count--;
               
            }
            if(count==0){num=nums[i];
                        count=1;
                        }
        
            }
        return num;
    }
}