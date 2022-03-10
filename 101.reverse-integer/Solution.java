class Solution {
    public int reverse(int x) {
        if(x==0) return 0;
        long y=Math.abs((long)x);
        int intLength = (int)Math.floor(Math.log(y)/Math.log(10));
        long ans=0;
        for (int i = intLength; i >=0; i--) {
            ans+=(y%10)*Math.pow(10, i);
            y/=10;
        }
        if(ans>Integer.MAX_VALUE)return 0;
        return (int)ans*(x/Math.abs(x));
    }
}