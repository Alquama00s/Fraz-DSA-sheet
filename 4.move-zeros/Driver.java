class Solution {
    public void moveZeroes(int[] nums) {
        int firstZero=0,nextNonZero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                firstZero=i;
                break;
            }
            nextNonZero=i+1;
        }
        while(nextNonZero <nums.length){
            if(nums[nextNonZero] != 0){
                nums[firstZero]=nums[nextNonZero];
                nums[nextNonZero]=0;
                firstZero++;
            }
            nextNonZero++;
            }    
        }
    }