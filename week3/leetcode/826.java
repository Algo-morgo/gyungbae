class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDifficulty = 0;
        for (int diff: difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }
        
        //난이도 별 이득 최댓값 저장
        int[] bestProfit = new int[maxDifficulty + 1];
        for (int jobIdx = 0; jobIdx < profit.length; jobIdx++) {
            bestProfit[difficulty[jobIdx]] = Math.max(bestProfit[difficulty[jobIdx]], profit[jobIdx]);
        }

        //난이도 순 최대 이득 갱신
        int maxProfit = 0;
        for (int profitIdx = 0; profitIdx < bestProfit.length; profitIdx++) {
            if (bestProfit[profitIdx] > maxProfit) {
                maxProfit = bestProfit[profitIdx];
            }
            bestProfit[profitIdx] = maxProfit;
        }

        int answer = 0;
        for (int ability: worker) {
            if (ability > maxDifficulty) {
                answer += bestProfit[maxDifficulty];
            } else {
                answer += bestProfit[ability];
            }
        }
        return answer;
    }
}