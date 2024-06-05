import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int[] sequenceV1 = Arrays.copyOf(sequence, sequence.length);
        int[] sequenceV2 = Arrays.copyOf(sequence, sequence.length);
        
        for(int numIdx = 0; numIdx < sequence.length; numIdx++) {
            if(numIdx %2 == 0)
                sequenceV1[numIdx] *= -1;
            else
                sequenceV2[numIdx] *= -1;
        }
        
        long[] v1DP = new long[sequence.length];
        long[] v2DP = new long[sequence.length];
        
        v1DP[0] = sequenceV1[0];
        v2DP[0] = sequenceV2[0];
        
        long answer = Math.max(v1DP[0], v2DP[0]);
        
        for(int numIdx = 1; numIdx < sequence.length; numIdx++) {
            //이전까지의 최댓값 + 현재값, 현재값을 비교
            v1DP[numIdx] = Math.max(v1DP[numIdx - 1] + sequenceV1[numIdx], sequenceV1[numIdx]);
            v2DP[numIdx] = Math.max(v2DP[numIdx - 1] + sequenceV2[numIdx], sequenceV2[numIdx]);
            
            answer = Math.max(answer, Math.max(v1DP[numIdx], v2DP[numIdx]));
        }
           
        return answer;
    }
}