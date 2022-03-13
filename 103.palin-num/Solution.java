class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(101));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        //reverse the last half of number and compare with first half of orignal
        int numOfDigits = 1 + (int) Math.floor(Math.log(x) / Math.log(10));
        int firstHalf = (int) (x / Math.pow(10, Math.ceil((double)numOfDigits/2)));//get the first half of no in case of odd length leave the middle digit
        numOfDigits/=2;
        long secondHalfRev = 0;
        for (int i = numOfDigits - 1; i >= 0; i--) {
            secondHalfRev += (x % 10) * Math.pow(10, i);
            x /= 10;
        }
        return (secondHalfRev == firstHalf);

    }
}