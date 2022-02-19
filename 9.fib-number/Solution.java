class Solution {
    public int fib(int n) {
        int f = 0,s=1,t=0;
        if(n==0)return f;
        if(n==1)return s;
        for(int i=2;i<=n;i++){
            t=f+s;
            f=s;
            s=t;
        }
        return t;
    }
}