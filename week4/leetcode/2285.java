class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] adjCnt = new int[n + 1];
        for(int[] road : roads) {
            adjCnt[road[0]]++;
            adjCnt[road[1]]++;
        }

        Arrays.sort(adjCnt);
        long answer = 0;
        for(int city = n; city >= 1; city--) {
            answer += (adjCnt[city] * (long)city);
        }

        return answer;
    }
}