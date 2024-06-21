/*
    1. 행의 모든 경우의 수 고려 
    2. 이후 열 탐색 경우의 수
        a. 열이 target과 모두 일치 -> 아무것도 안한다
        b. 열이 target과 반대 -> 뒤집고 카운팅
    c. a도b도아니다 -> return -1
*/

class Solution {
    int rowSize, colSize;
    int[][] beginningArr;
    int[][] targetArr;
    int answer;
    
    void dfs(int currentRow, int currentCnt){
        if(currentRow == rowSize){
            for(int col = 0; col < colSize; col++){
                int result = compareCol(col);
                if(result == -1){
                    return;
                }
                currentCnt += result;
            }
            
            
            answer = Math.min(answer, currentCnt);   
            return;
        }
        
        reverseRow(currentRow); 
        dfs(currentRow + 1, currentCnt+1); 
        reverseRow(currentRow); 
        
        dfs(currentRow + 1, currentCnt); 
    }
    
    int compareCol(int col){
        int check = 0;
        for(int row = 0; row < rowSize; row++){
            if(targetArr[row][col] == beginningArr[row][col]){
                check++; 
            } 
        }
        
        if(check == rowSize) {  //일치
            return 0;
        } else if(check == 0) { //반대
            return 1;
        } else {    //불가능
            return -1;
        }
    }
    
    void reverseRow(int row){
        for(int col = 0; col < colSize; col++){
            beginningArr[row][col] = (beginningArr[row][col] + 1) % 2;
        }
    }
    
    public int solution(int[][] beginning, int[][] target) {
        rowSize = beginning.length;
        colSize = beginning[0].length;
        
        beginningArr = beginning;
        targetArr = target;
        
        answer = Integer.MAX_VALUE;
        dfs(0, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}