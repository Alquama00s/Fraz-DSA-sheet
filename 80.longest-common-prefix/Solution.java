class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        char temp;
        boolean run = true;
        int i=0;
        while(run){
            if(i<strs[0].length())
            temp=strs[0].charAt(i);
                else break;
            for(int j=1;j<strs.length;j++){
                if(!(i<strs[j].length()&& temp==strs[j].charAt(i))){
                    run=false;
                }
            }
            if(run)ans+=temp;
            i++;
        }
        return ans;
    }
}