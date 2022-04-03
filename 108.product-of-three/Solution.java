import java.util.*;
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumProduct(new int[]{-100,-98,-1,2,3,4}));   
    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int neg=0;
        while(neg<nums.length-1 && nums[neg]<0){
            neg++;
        }
        neg--; 
        int pos = nums.length-1;
        int por;
        if(neg>0){
            por = Math.max(nums[pos]*nums[pos-1]*nums[pos-2],nums[0]*nums[1]*nums[pos]);
        }else{
            por = nums[pos]*nums[pos-1]*nums[pos-2];
        }    
        return por;
    
    }
}