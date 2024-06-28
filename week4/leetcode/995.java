class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int numCnt = nums.length;
        int[] hint = new int[numCnt];
        int flip = 0;   
        int result = 0;
        
        for (int numIdx = 0; numIdx < numCnt; numIdx++) {
            if (numIdx >= k) {  //현재 위치 플립된 상태인지 확인
                flip ^= hint[numIdx - k];
            }
            if (nums[numIdx] == flip) { //현재 위치 플립 필요
                if (numIdx + k > numCnt) {
                    return -1;
                }
                result++;
                flip ^= 1;  //플립 횟수 증가 후 토글
                hint[numIdx] = 1;   //플립 시작 위치 표시
            }
        }
        
        return result;
    }
}