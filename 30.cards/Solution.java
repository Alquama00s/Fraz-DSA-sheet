import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{1,2,3,4,5,6,7,8,9,10}, 3));
    }
    public int maxScore(int[] cardPoints, int k) {
        if(k==cardPoints.length){
            return Arrays.stream(cardPoints).reduce(0,(i,j)->i+j);
        }
        int[] prefix = new int[k+1];
        int[] suffix = new int[k+1];
        prefix[0]=0;
        suffix[k]=0;
        for(int i=1;i<=k;i++){
            prefix[i]=prefix[i-1]+cardPoints[i-1];
        }
        
        for(int j=k-1;j>=0;j--){
            suffix[j]=suffix[j+1]+cardPoints[cardPoints.length-1-(k-j-1)];
        }
        int sum =0;
        for(int i=0;i<=k;i++){
            sum=Math.max(sum,prefix[i]+suffix[i]);
        }
        return sum;
    }
}