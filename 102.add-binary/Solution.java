class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        char cc = '0';
        int _a, _b, _c;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 && j >= 0) {
            _a = a.charAt(i) - 48;
            _b = b.charAt(j) - 48;
            _c = cc - 48;
            ans.insert(0,(char) ((_a ^ _b ^ _c) + 48));
            cc = (char) (((_a | _b) & (_b | _c) & (_c | _a)) + 48);
            i--;
            j--;
        }
        while (i >= 0) {
            _a = a.charAt(i) - 48;
            _b = 0;
            _c = cc - 48;
            ans.insert(0,(char) ((_a ^ _b ^ _c) + 48));
            cc = (char) (((_a | _b) & (_b | _c) & (_c | _a)) + 48);
            i--;
        }
        while (j >= 0) {
            _a = 0;
            _b = b.charAt(j)-48;
            _c = cc - 48;
            ans.insert(0,(char) ((_a ^ _b ^ _c) + 48));
            cc = (char) (((_a | _b) & (_b | _c) & (_c | _a)) + 48);
            j--;
        }
        if (cc == '1')
            ans.insert(0,cc);
        return ans.toString();
    }
}