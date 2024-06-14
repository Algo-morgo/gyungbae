//더 작은 풍선은 1번만 터트릴 수 있다
//인접한 풍선 번호가 모두 더 작다면 남을 수 없다

class Solution {
    public int solution(int[] a) {
        if(a.length == 1 || a.length == 2) 
            return a.length;
        
        int[] leftMinArr = new int[a.length]; //인덱스 기준 왼쪽 최소값
        int[] rightMinArr = new int[a.length]; //인덱스 기준 오른쪽 원소의 최소값
        int leftMin = a[0]; //왼쪽 값 중 최소값
        int rightMin = a[a.length - 1]; //오른쪽 값 중 최소값
        
        //왼쪽 최소값 저장
        for(int balloonIdx = 1; balloonIdx < a.length - 1; balloonIdx++) {
            if(leftMin > a[balloonIdx]) 
                leftMin = a[balloonIdx];
            leftMinArr[balloonIdx] = leftMin;
        }
        
        //오른쪽 최소값 저장
        for(int balloonIdx = a.length - 2; balloonIdx > 0; balloonIdx--) {
            if(rightMin > a[balloonIdx]) 
                rightMin = a[balloonIdx];
            rightMinArr[balloonIdx] = rightMin;
        }
        
        int answer = 2; 
        for(int balloonIdx = 1; balloonIdx <= a.length - 2; balloonIdx++) {
            if(a[balloonIdx] > leftMinArr[balloonIdx] && a[balloonIdx] > rightMinArr[balloonIdx]) 
                continue;
            
            answer++;
        }
        return answer;
    }
}
