class Solution {
    public int heightChecker(int[] heights) {
        int[] arrangedArr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arrangedArr);

        int answer = 0;
        for(int heightIdx = 0; heightIdx < heights.length; heightIdx++) {
            if(heights[heightIdx] != arrangedArr[heightIdx]) 
                answer++;
        }

        return answer;
    }
}