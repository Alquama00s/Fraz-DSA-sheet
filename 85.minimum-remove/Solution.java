import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minRemoveToMakeValid(
            "))(("
            ));
    }

    public String minRemoveToMakeValid(String s) {
        StringBuffer st = new StringBuffer();
        int openBracesCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    openBracesCount++;
                } else {
                    if(openBracesCount==0)continue;
                    openBracesCount--;
                }
            }
            st.append(s.charAt(i));

        }
        s=st.toString();
        int i=s.length()-1;
        while (openBracesCount>0) {
            if(s.charAt(i)=='('){
                st.delete(i, i+1);
                openBracesCount--;
            }
            i--;
        }
        return st.toString();
    }
}