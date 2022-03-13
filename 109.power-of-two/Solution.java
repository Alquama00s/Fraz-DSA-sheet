
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(
                16777217));
    }

    public boolean isPowerOfTwo(int n) {
        System.out.println((Math.log(n) / Math.log(2)) + " " + (int) (Math.log(n) / Math.log(2)));
        return ((Math.log(n) / Math.log(2)) - (int) (Math.log(n) / Math.log(2))) < 0.000000000000001d;
    }
}