class Solution {
    public int countSubstrings(String s) {
        int count =0;
        for(int i=0;i<s.length();i++){
            int k=i,j=i;
            while(k>=0&&j<s.length()&&s.charAt(k)==s.charAt(j)){
                count++;
                k--;j++;
            }
        }
        
        for(int i=0;i<s.length();i++){
            int k=i,j=i+1;
            while(k>=0&&j<s.length()&&s.charAt(k)==s.charAt(j)){
                count++;
                k--;j++;
            }
        }
        return count;
    }
}