class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    public int maxProfit(int[] prices) {
        int max1 = 0, max2 = 0;
        int curr = 0;
        boolean toggle = false;
        for (int i = 1; i < prices.length; i++) {
            curr += (prices[i] - prices[i - 1]);
            if (curr < 0) {
                toggle=!toggle;
                curr = 0;
            }
            if (toggle) {
                max1=Math.max(max1, curr);
            } else {
                max2=Math.max(max2, curr);
            }
        }
        System.out.println(max1 + " " + max2);
        return max1 + max2;
    }
}