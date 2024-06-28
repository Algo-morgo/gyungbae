import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int bIdx = A.length - 1;
        for(int aIdx = A.length - 1; aIdx >= 0; aIdx--) {
            if(B[bIdx] > A[aIdx]) {
                answer++;
                bIdx--;
            }
        }
        return answer;
    }
}