class Solution {
    HashSet<List<Integer>> ans = new HashSet<>();
    int tar;
    int[] can;
   public void recurse(int i,int sum,List<Integer> temp){
       if(sum==tar){
          ans.add(temp);
           return;
       }if(sum<tar && i<can.length){
           //dont take curren element and move forward
           recurse(i+1,sum,new ArrayList<Integer>(temp));
           temp.add(can[i]);
           //take current element and remain there
           recurse(i,sum+can[i],new ArrayList<Integer>(temp));
           //take current element and move forward (not required)
           //recurse(i+1,sum+can[i],new ArrayList<Integer>(temp));
       }
   }
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
       can=candidates;
       tar=target;
       recurse(0,0,new ArrayList<Integer>());
       return new ArrayList<List<Integer>>(ans);
   }
}