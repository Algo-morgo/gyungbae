class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0; 
        int stationIdx = 0;
        int currentIdx = 1; //w는 자연수, 1부터 시작
        while (currentIdx <= n) {   //배열 전체 순회
            if (stationIdx < stations.length && currentIdx >= stations[stationIdx] - w) {   //currentIdx가 기지국 범위 내라면
                currentIdx = stations[stationIdx] + w + 1;  //건설된 기지국 다음 idx로 이동
                stationIdx++;
                continue;
            }
            
            currentIdx += 2 * w + 1;    //범위 밖이면 기지국 건설, 범위만큼 이동
            answer++;
        }

        return answer;
    }
}