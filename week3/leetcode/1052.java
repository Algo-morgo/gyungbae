class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int right = left + minutes - 1;
        int max = 0;
        for(int minute = left; minute <= right; minute++) {
            if(grumpy[minute] == 0) {
                continue;
            }

            max += customers[minute];
        }

        int tmp = max;
        while(right < customers.length - 1) {
            if(grumpy[left] == 1) {
                tmp -= customers[left];
            }
            left++;
            right++;

            if(grumpy[right] == 1) {
                tmp += customers[right];
            }

            max = Math.max(max, tmp);
        }

        int answer = 0;
        for(int minute = 0; minute < customers.length; minute++) {
            if(grumpy[minute] == 1) {
                continue;
            }

            answer += customers[minute];
        }
        
        return answer + max;
    }
}