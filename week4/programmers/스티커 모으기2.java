class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int stickerCnt = sticker.length;

        if (stickerCnt == 1) {
            return sticker[0];    
        }

        int [] dp = new int[stickerCnt];

        // 첫 번째 스티커O
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for (int stickerIdx = 2; stickerIdx < stickerCnt - 1; stickerIdx++) {
            dp[stickerIdx] = Math.max(dp[stickerIdx - 2] + sticker[stickerIdx], dp[stickerIdx - 1]);
        }
        answer = dp[stickerCnt - 2];

        // 첫 번째 스티커X
        dp[0] = 0;
        dp[1] = sticker[1];
        for (int stickerIdx = 2; stickerIdx < stickerCnt; stickerIdx++) {
            dp[stickerIdx] = Math.max(dp[stickerIdx - 2] + sticker[stickerIdx], dp[stickerIdx - 1]);
        }
        answer = Math.max(answer, dp[stickerCnt - 1]);
        return answer;
    }
}