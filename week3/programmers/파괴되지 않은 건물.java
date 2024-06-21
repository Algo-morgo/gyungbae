import java.util.*;

class Solution {
    //누적합, fromIdx +value, toIdx + 1 -value
    //2차원 배열은 가로, 세로 모두 고려
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        for(int i = 0; i < board.length+1; i++) {
            Arrays.fill(sum[i],0);
        }
            
        
        for(int[] info : skill){
            int fromRow = info[1];
            int fromCol = info[2];
            
            int toRow = info[3];
            int toCol = info[4];
            
            int degree = (info[0] == 1) ? -info[5] : info[5];
            
            sum[fromRow][fromCol] += degree;
            sum[fromRow][toCol+1] += -degree;
            sum[toRow+1][fromCol] += -degree;
            sum[toRow+1][toCol+1] += degree;
        }
        
        // 세로로 누적합
        for(int col = 0; col < board[0].length+1; col++){
            for(int row = 0; row < board.length; row++){
                sum[row+1][col] += sum[row][col];
            }
        }
        
        // 가로로 누적합
        for(int row = 0; row < board.length+1; row++){
            for(int col = 0; col < board[0].length; col++){
                sum[row][col+1] += sum[row][col];
            }
        }
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                board[row][col] += sum[row][col];
                
                if(board[row][col] > 0) {
                    answer++;
                }    
            }
        }
        
        return answer;
    }
}