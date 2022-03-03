class Solution {
    public int[] countBits(int n) {
        if(n==0)return new int[]{0};
        if(n==1)return new int[]{0,1};
        int k=2,l=1;
        int[] ans=new int[n+1];
        ans[0]=0;
        ans[1]=1;
        for(int i=2;i<=n;i++){
            if(i==k){
                ans[i]=1;
                k*=2;
                l*=2;
            }else{
                ans[i]=ans[l]+ans[i-l];
            }
        }
        return ans;
    }
}