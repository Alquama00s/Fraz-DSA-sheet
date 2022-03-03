class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int j = time.length-1;
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        freq.put(time[j]%60,1);
        j--;
        int ans=0;
        while(j>=0){
            //if ( k%60 + l%60 ) % 60 ==0 then k,l belongs to soln
            
            
            if(freq.containsKey((60-(time[j]%60))%60)){
                ans+=freq.get((60-(time[j]%60))%60);
            }
            if(freq.containsKey(time[j]%60)){
                freq.put((time[j]%60),freq.get(time[j]%60)+1);
            }else{
                freq.put((time[j]%60),1);
            }
            j--;
        }
        return ans;
    }
}