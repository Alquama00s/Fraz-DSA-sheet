class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int index;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums.length)index=nums[i]-nums.length;
            else index=nums[i];
            if(nums[index-1]>nums.length){
                ans.add(index);
            }else{
            nums[index-1]+=nums.length;
            }
        }
        return ans;
    }
}