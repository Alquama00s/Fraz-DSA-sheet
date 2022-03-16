import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    int[][] dp;
    String in;
    HashSet<String> dictionary;

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode",
                Arrays.stream(new String[] { "eet", "l", "leet" }).collect(Collectors.toList())));
    }

    int recurseCheck(int l, int h) {
        //System.out.println(l + " " + h);
        if (dp[l][h] != -1) {
            return dp[l][h];
        }
        int ans = 0;
        if (dictionary.contains(in.substring(l, h + 1))) {
            ans = 2;
        }
        for (int i = l; i < h && ans < 2; i++) {
            ans = recurseCheck(l, i) + recurseCheck(i + 1, h);
        }
        if(ans==2)ans=1;
        else ans=0;
        return dp[l][h] = ans;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        in = s;
        dictionary = new HashSet<>(wordDict);
        /*
         * for (int i = 0; i < s.length(); i++) {
         * dp[i][i] = dictionary.contains(s.substring(i, i + 1));
         * }
         * for (int k = 1; k < s.length(); k++) {
         * for (int l = 0; l + k < s.length(); l++) {
         * dp[l][l + k] = (dp[l + 1][l + k] && dp[l][l + k - 1])
         * || dictionary.contains(s.substring(l, l + k + 1));
         * }
         * }
         * // for (int i = 0; i < dp.length; i++) {
         * // for (int j = 0; j < dp.length; j++) {
         * // System.out.print(dp[i][j] + " ");
         * // }
         * // System.out.println();
         * // }
         * 
         * boolean ans = dp[0][dp.length - 1];
         * for (int i = 0; i < dp.length - 1 && !ans; i++) {
         * ans = dp[0][i] && dp[i + 1][dp.length - 1];
         * }
         */
        int ans = recurseCheck(0, s.length() - 1);
        /*
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
        if (ans > 0) {
            return true;
        }
        return false;
    }
}