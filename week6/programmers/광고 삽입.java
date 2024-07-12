class Solution {
    int toSecond(String time) {
        String[] timeArr = time.split(":");
        
        return Integer.parseInt(timeArr[0]) * 3600 
             + Integer.parseInt(timeArr[1]) * 60 
             + Integer.parseInt(timeArr[2]);
    }
    
    // 초 단위를 문자열 시간으로 변환
    String toTime(int second) {
        int hour = second / 3600;
        second %= 3600;
        
        int minute = second / 60;
        second %= 60;
        
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSecond(play_time);
        int advTime = toSecond(adv_time);

        //누적합을 위한 시청 시간 저장
        long[] viewArr = new long[playTime + 1];

        for (String log : logs) {
            String[] timeArr = log.split("-");
            
            int start = toSecond(timeArr[0]);
            int end = toSecond(timeArr[1]);
            
            viewArr[start]++;
            if (end < playTime) {
                viewArr[end]--;
            }
        }

        //시간마다 시청자 수 누적
        for (int time = 1; time <= playTime; time++) {
            viewArr[time] += viewArr[time - 1];
        }
        
        //시간까지 시청 시간 누적
        for (int time = 1; time <= playTime; time++) {
            viewArr[time] += viewArr[time - 1];
        }

        long maxView = viewArr[advTime - 1];
        int maxTime = 0;
        
        //최대 시청자 수 탐색
        for (int time = advTime; time <= playTime; time++) {
            long currentView = viewArr[time] - viewArr[time - advTime];
            
            if (currentView > maxView) {
                maxView = currentView;
                maxTime = time - advTime + 1;
            }
        }

        return toTime(maxTime);
    }
}