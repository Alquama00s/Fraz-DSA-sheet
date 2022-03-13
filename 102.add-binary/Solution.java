class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
    char[] add(char a,char b,char c){
        int _a=Integer.parseInt(""+a);
        int _b=Integer.parseInt(""+b);
        int _c=Integer.parseInt(""+c);
        char add=((_a^_b^_c)+"").charAt(0);
        char car=((_a&(_b|_c))+"").charAt(0);
        return new char[]{add,car};
    }
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j= b.length()-1;
        char ca,cb,cc='0';
        char[] tempAns;
        String ans="";
        while(i>=0||j>=0){
            if(i<0){
                ca='0';
            }else{
                ca=a.charAt(i);
            }
            if(j<0){
                cb='0';
            }else{
                cb=b.charAt(j);
            }
            tempAns=add(ca,cb,cc);
            //System.out.println(tempAns[0]+" "+tempAns[1]);
            ans=(""+tempAns[0])+ans;
            cc=tempAns[1];
            i--;j--;
        }
        ans=(""+cc)+ans;
        return ans;
    }
}