class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        //아래, 오른쪽 이동 고려
        int[][][]dp = new int[m][n][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        
        //첫번째 열은 위에서만 올 수 있음 >> 1로 채움
        for(int row = 1; row < m; row++){
            if(cityMap[row][0] != 1) {
                dp[row][0][0] = dp[row - 1][0][0];    
            }
        }
        
        //첫번째 행은 왼쪽에서만 올 수 있음 >> 1로 채움
        for(int col = 1; col < n; col++){
            if(cityMap[0][col] != 1) dp[0][col][1] = dp[0][col - 1][1];
        }

        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                //아래 이동
                if(cityMap[row - 1][col] != 1){
                    if(cityMap[row - 1][col] == 2) {    //신호등이면 아래만
                        dp[row][col][0] = dp[row - 1][col][0];
                    } else {    //아래, 오른쪽 모두 고려
                        dp[row][col][0] = (dp[row - 1][col][0] + dp[row - 1][col][1]) % MOD;
                    } 
                } 
                //오른쪽 이동
                if(cityMap[row][col - 1] != 1){
                    if(cityMap[row][col-1] == 2) {  //신호등이면 오른쪽만
                        dp[row][col][1] = dp[row][col-1][1];
                    } else {    //오른쪽, 아래 모두 고려
                        dp[row][col][1] = (dp[row][col-1][0] + dp[row][col-1][1]) % MOD;
                    } 
                }
            }
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}