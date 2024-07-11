class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0;
        long waitTime = 0;
        for(int[] info : customers) {
            int arriveTime = info[0];
            int cookingTime = info[1];

            if(currentTime < arriveTime) {
                currentTime = arriveTime;
            }

            waitTime += currentTime + cookingTime - arriveTime;
            currentTime += cookingTime;
        }

        return waitTime / (double) customers.length;
    }
}