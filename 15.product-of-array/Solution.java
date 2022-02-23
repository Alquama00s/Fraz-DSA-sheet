class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix_answer=new int[nums.length];
        int temp,temp2;
        prefix_answer[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix_answer[i]=prefix_answer[i-1]*nums[i];
        }
        
        //using nums as suffix to do it in o(1) space
        for(int i=nums.length-2;i>=0;i--){
            nums[i]*=nums[i+1];
        }
        temp = prefix_answer[0];
        prefix_answer[0]=nums[1];
        for(int i=1;i<nums.length-1;i++){
            temp2=prefix_answer[i];
            prefix_answer[i]=temp*nums[i+1];
            temp=temp2;
        }
        prefix_answer[nums.length-1]=temp;
        
        return prefix_answer;
    }
}


