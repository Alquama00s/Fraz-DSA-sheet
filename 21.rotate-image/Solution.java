class Solution {
    public void rotate(int[][] matrix) {
        int minLength = 0, maxLength = matrix.length - 1;
        int i = 0, j = maxLength, temp, temp1;

        /**
         * making for pointer initialised at corners of the matrix
         * and the swapping all of them
         * 
         */
        while (minLength < maxLength) {

            for (int it = minLength; it < maxLength; it++) {
                temp = matrix[i][maxLength];//p2
                matrix[i][maxLength] = matrix[minLength][i];//p1
                temp1 = matrix[maxLength][j];//p3
                matrix[maxLength][j] = temp;
                temp = matrix[j][minLength];//p4
                matrix[j][minLength] = temp1;
                matrix[minLength][i] = temp;
                i++;
                j--;
            }
            minLength++;
            maxLength--;
            i = minLength;
            j = maxLength;
        }
    }
}