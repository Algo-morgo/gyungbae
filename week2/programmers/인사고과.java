import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        int targetSum = target[0] + target[1];
        
        //태도 점수 내림차순, 평가 점수 오름차순 정렬
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) {
                    return -1; 
                } else if(o1[0] == o2[0]) {
                    if(o1[1] > o2[1]) {
                        return 1;
                    } else if(o1[1] == o2[1]) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return 1;
                }
            }
        });
        
        int answer = 1; //1등부터 카운팅
        int maxEvaluation = 0;
        for(int employee = 0; employee < scores.length; employee++) {
            //원호가 인센티브를 받을 수 있나 확인
            if(target[0] < scores[employee][0] && target[1] < scores[employee][1]) {
                return -1;
            }
            
            //성과금을 받을 수 있는 직원만 고려
            //태도 점수는 이미 내림차순으로 정렬된 상태, 평가 점수만 비교
            if(maxEvaluation <= scores[employee][1]) {
                if(targetSum < scores[employee][0] + scores[employee][1]) {
                    answer++;
                }
                
                maxEvaluation = scores[employee][1];
            }
        }
        
        return answer;        
    }
}