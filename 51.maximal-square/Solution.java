
class Solution {
    public static void main(String[] args) {
        /*
         * System.out.println(new Solution().maximalSquare(new char[][] { { '1', '0',
         * '1', '0', '0' },
         * { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0',
         * '1', '0' } }));
         */
        System.out.println(new Solution().maximalSquare(new char[][] { { '1','1' }, { '1','1' }}));

    }

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, cols = matrix[0].length;
        int prev = 0, ans = 0, prev1 = 0;
        int[] dp = new int[cols];
        for (int i = 0; i < row; i++) {
            prev=dp[0];
            dp[0] = matrix[i][0] == '1' ? 1 : 0;
            ans = Math.max(ans, dp[0]);
            System.out.print(dp[0]+" ");
            for (int j = 1; j < cols; j++) {
                prev1 = dp[j];
                if (matrix[i][j] == '1') {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
                } else {
                    dp[j] = 0;
                }
                prev = prev1;
                ans = Math.max(ans, dp[j]);
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return ans*ans;
    }
}