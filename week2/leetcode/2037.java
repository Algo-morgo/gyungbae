class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int answer = 0;
        for(int idx = 0; idx < seats.length; idx++) {
            answer += Math.abs(seats[idx] - students[idx]);
        }

        return answer;
    }
}