class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    int[] numbers;
    void recurse(int i,List<Integer> temp){
        if(i==numbers.length){
        ans.add(new ArrayList<Integer>(temp));
        return;
        }
        recurse(i+1,new ArrayList<Integer>(temp));
        temp.add(numbers[i]);
        recurse(i+1,new ArrayList<Integer>(temp));
            
    }
    public List<List<Integer>> subsets(int[] nums) {
        numbers=nums;
        recurse(0,new ArrayList<>());
        return ans;
    }
}