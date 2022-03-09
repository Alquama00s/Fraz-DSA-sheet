import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0,temp=0,startI=0;
        HashMap<Character,Integer> lastOcurr = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(lastOcurr.containsKey(s.charAt(i)) && lastOcurr.get(s.charAt(i))>=startI ){
                ans=Math.max(ans, temp);
                startI=lastOcurr.get(s.charAt(i))+1;
                temp=i-lastOcurr.get(s.charAt(i));
                lastOcurr.put(s.charAt(i),i);
            }else{
                lastOcurr.put(s.charAt(i),i);
                temp++;
            }
        }
        ans=Math.max(ans,temp);
        return ans;
    }
}