class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[] { 1, 2, 3, 4, 5,6 }));
    }

    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int vol =0;
        while(i<j){
            vol=Math.max(vol, Math.min(height[i], height[j])*(j-i));
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return vol;        
    }
}