import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minRemoveToMakeValid("l(((ee(t(c)o)de)"));
    }

    public String minRemoveToMakeValid(String s) {
        StringBuffer st = new StringBuffer(s);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    st.replace(i, i + 1, "A");
                }
            }
        }
        int i = 0;
        while (!stack.empty()) {
            while (s.charAt(i) != '(') {
                i++;
            }
            st.replace(i, i + 1, "A");
            stack.pop();
            i++;
        }
        return st.toString().replaceAll("A", "");
    }
}