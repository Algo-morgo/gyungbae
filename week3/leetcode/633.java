class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while(a <= b) {
            long sum = a * a + b * b;
            if(sum < c) {
                a++;
            } else if(sum > c) {
                b--;
            } else {
                return true;
            }
        }

        return false;
    }
}