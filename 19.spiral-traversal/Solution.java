class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minLength=0,maxLength=matrix[0].length-1;
        int minHeight=0,maxHeight=matrix.length-1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while(minHeight<=maxHeight && minLength<=maxLength){
            for(int i=minLength;i<=maxLength;i++){
                ans.add(matrix[minHeight][i]);
            }
            minHeight++;
            if(minHeight>maxHeight)break;
            for(int i=minHeight;i<=maxHeight;i++){
                ans.add(matrix[i][maxLength]);
            }
            maxLength--;
            if(minLength>maxLength)break;
            for(int i=maxLength;i>=minLength;i--){
                ans.add(matrix[maxHeight][i]);
            }
            maxHeight--;
            if(minHeight>maxHeight)break;
            for(int i=maxHeight;i>=minHeight;i--){
                ans.add(matrix[i][minLength]);
            }
            minLength++;
            
        }
        return ans;
    }
}