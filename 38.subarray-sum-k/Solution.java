class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];
        Arrays.fill(freq,0);
        int pSum=0;//prefix sum,
        freq[0]++;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            pSum+=nums[i];
            ans+=freq[(k+(pSum%k))%k];
            freq[(k+(pSum%k))%k]++;
        }
        return ans;
    }
}