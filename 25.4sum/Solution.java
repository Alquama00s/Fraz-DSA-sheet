import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int l=0,m=nums.length-1;
        HashSet<List<Integer>> ans = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                l=j+1;m=nums.length-1;
                while(l<m){
                    if(nums[i]+nums[j]+nums[l]+nums[m]<target){
                        l++;
                    }else if(nums[i]+nums[j]+nums[l]+nums[m]>target){
                        m--;
                    }else{
                        temp.clear();
                        temp.add(nums[i]);
                        temp.add(nums[l]);
                        temp.add(nums[m]);
                        temp.add(nums[j]);
                        ans.add(new ArrayList<Integer>(temp));
                        l++;
                        m--;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(ans);
    }
}