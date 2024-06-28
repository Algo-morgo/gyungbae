class Solution {
    boolean check(int peopleCnt, int[] stones, int k) {
        int count = 0;
        for(int idx = 0; idx < stones.length; idx++) {
            if(stones[idx] < peopleCnt) {
                count++;
                if(count >= k) {
                    return false;
                }
                continue;
            }
            
            count = 0;
        }
        
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = Integer.MAX_VALUE;
        int answer = 0;
        while(min <= max) {
            int mid = (max + min) / 2; 
            
            if(check(mid, stones, k)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
}