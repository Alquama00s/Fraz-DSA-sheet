class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr(
                "mississippi",
                "issip"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int k = 0;
        int ans = -1;
        boolean found = false;
        int j = needle.length() - 1;

        while (k + j < haystack.length() && !found) {
            if (haystack.charAt(k) == needle.charAt(0) && needle.charAt(j) == haystack.charAt(k + j)) {
                found = true;
                ans=k;
                for (int l = 1; l < j; l++) {
                    if (needle.charAt(l) != haystack.charAt(k + l)) {
                        found = false;
                        ans=-1;
                        break;
                    }
                }
            }
            k++;
        }
        
        return ans;
    }

}