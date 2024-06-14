class Solution {
    public int solution(int[] money) {
        //첫 집을 터는 경우(마지막 집 X)
        int[] dp1 = new int[money.length];
        dp1[0] = dp1[1] = money[0];
        
        //마지막 집을 터는 경우(첫 집 X)
        int[] dp2 = new int[money.length];
        dp2[1] = money[1];
        
        //현재 집을 털었을 때, 털지 않았을 때 비교
        for(int moneyIdx = 2; moneyIdx < money.length; moneyIdx++) {
            dp1[moneyIdx] = Math.max(dp1[moneyIdx - 2] + money[moneyIdx], dp1[moneyIdx - 1]);
            dp2[moneyIdx] = Math.max(dp2[moneyIdx - 2] + money[moneyIdx], dp2[moneyIdx - 1]);
        }
        
        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}