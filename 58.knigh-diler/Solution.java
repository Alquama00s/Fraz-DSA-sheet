import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().knightDialer(8));
    }

    public int[][] dp, model = new int[4][3];
    final int mod = 1000000007;

    public int traversals(int curr, int n) {
        switch (curr) {
            case 0:
                return (int) (((long) dp[6][n] + dp[4][n]) % mod);
            case 1:
                return (int) (((long) dp[6][n] + dp[8][n]) % mod);
            case 2:
                return (int) (((long) dp[7][n] + dp[9][n]) % mod);
            case 3:
                return (int) (((long) dp[4][n] + dp[8][n]) % mod);
            case 4:
                return (int) (((long) dp[3][n] + dp[9][n] + dp[0][n]) % mod);
            case 5:
                return 0;
            case 6:
                return (int) (((long) dp[1][n] + dp[7][n] + dp[0][n]) % mod);
            case 7:
                return (int) (((long) dp[2][n] + dp[6][n]) % mod);
            case 8:
                return (int) (((long) dp[1][n] + dp[3][n]) % mod);
            case 9:
                return (int) (((long) dp[2][n] + dp[4][n]) % mod);
            default:
                return 0;
        }
    }

    public int knightDialer(int n) {
        dp = new int[10][n];
        for (int i = 0; i < 10; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[j][i] = traversals(j, i - 1);
            }

        }

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum = (int) (((long) sum + dp[i][n - 1]) % mod);
        }
       
        return sum;
    }

}