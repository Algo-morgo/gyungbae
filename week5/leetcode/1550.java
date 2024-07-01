class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        boolean result = false;
        for(int num : arr) {
            if(num % 2 == 0) {
                count = 0;
            } else {
                count++;
                if(count == 3) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
}