public class Solution {
    boolean place(int[] position, int m, int minForce) {
        //자기력을 임시로 지정, 지정한 자기력에 맞춰 모든 공을 놓을 수 있는지 확인
        int count = 1; 
        int currentPosition = position[0]; 

        for (int basketIdx = 1; basketIdx < position.length; basketIdx++) {
            if (position[basketIdx] - currentPosition >= minForce) {
                count++;
                currentPosition = position[basketIdx]; 
                if (count >= m) {
                    return true;
                }
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position); 

        int left = 1;   //최소 자기력
        int right = position[position.length - 1] - position[0];    //최대 자기력
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (place(position, m, mid)) {
                result = mid;
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return result;
    }
}
