class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        String ans = "", tempAns = "";
        char a, b;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 && j >= 0) {
            a = b = '0';
            if (i < num1.length())
                a = num1.charAt(i);
            if (j < num2.length())
                b = num2.charAt(j);
            tempAns = "" + ((int) a + (int) b + carry - 48 * 2);
            if (tempAns.length() > 1)
                carry = 1;
            else
                carry = 0;
            ans += tempAns.charAt(tempAns.length()-1);
            i--;
            j--;
        }
        while (i >= 0) {
            a = '0';
            if (i < num1.length())
                a = num1.charAt(i);
            tempAns = "" + ((int) a + carry - 48);
            if (tempAns.length() > 1)
                carry = 1;
            else
                carry = 0;
            ans += tempAns.charAt(tempAns.length()-1);
            i--;
        }
        while (j >= 0) {
            b = '0';
            if (j < num2.length())
                b = num2.charAt(j);
            tempAns = "" + ((int) b + carry - 48);
            if (tempAns.length() > 1)
                carry = 1;
            else
                carry = 0;
            ans += tempAns.charAt(tempAns.length()-1);
            j--;
        }
        if (carry == 1) {
            ans += '1';
        }
        return new StringBuilder(ans).reverse().toString();

    }
}