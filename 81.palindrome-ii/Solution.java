class Solution {
    public boolean validPalindrome(String s) {
        int cnt = 0;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        int tempI = i, tempJ = j;
        i++;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        if (i >= j) {
            return true;
        }
        i = tempI;
        j = tempJ;
        j++;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        if (i >= j) {
            return true;
        }

        return false;
    }
}