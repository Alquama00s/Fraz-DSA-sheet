class Solution {
    public int numDecodings(String s) {
        if (Integer.parseInt(s.substring(0, 1)) == 0 || (s.length() > 1 && Integer.parseInt(s.substring(1, 2)) == 0)
                && Integer.parseInt(s.substring(0, 2)) > 26)
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (dp.length > 1) {
            if (Integer.parseInt(s.substring(1, 2)) == 0 || Integer.parseInt(s.substring(0, 2)) > 26) {
                dp[1] = 1;
            } else {
                dp[1] = 2;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if (Integer.parseInt(s.substring(i, i + 1)) == 0) {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) == 0
                        || Integer.parseInt(s.substring(i - 1, i + 1)) > 26) {
                    return 0;
                } else
                    dp[i] = dp[i - 2];
            } else if (Integer.parseInt(s.substring(i - 1, i)) == 0
                    || Integer.parseInt(s.substring(i - 1, i + 1)) > 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}