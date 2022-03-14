class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
        int max1=0,max2=0;//max1>=max2;
        int curr=0;
        for(int i=1;i<prices.length;i++){
            curr+=(prices[i]-prices[i-1]);
            if(curr<0)curr=0;
            if(curr>max1){
                max2=max1;
                max1=curr;
            }else if(curr>max2){
                max2=curr;
            }
            System.out.println(curr);
        }
        return max1+max2;
    }
}