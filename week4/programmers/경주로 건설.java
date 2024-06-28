import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int size;
    int[][] input;
    
    int[] deltaRow = {-1, 1, 0, 0};
    int[] deltaCol = {0, 0, -1, 1};
    void bfs() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        //한 위치에서 4가지 방향에 대한 최솟값을 찾아야 한다.
        int[][][] costArr = new int[size][size][4];
        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Arrays.fill(costArr[row][col], Integer.MAX_VALUE);
            }
        }
        
        for (int direction = 0; direction < 4; direction++) {
            costArr[0][0][direction] = 0;
        }
        
        queue.offer(new int[]{0, 0, 0, -1});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];
            int direction = current[3];
            
            if (row == size - 1 && col == size - 1) {
                answer = Math.min(answer, cost);
                continue;
            }
            
            for (int deltaIdx = 0; deltaIdx < 4; deltaIdx++) {
                int nextRow = row + deltaRow[deltaIdx];
                int nextCol = col + deltaCol[deltaIdx];
                
                if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size || input[nextRow][nextCol] == 1) {
                    continue;
                }
                
                int nextCost = cost + 100;
                if (direction != -1 && direction != deltaIdx) {
                    nextCost += 500;
                }
                
                if (nextCost < costArr[nextRow][nextCol][deltaIdx]) {
                    costArr[nextRow][nextCol][deltaIdx] = nextCost;
                    queue.offer(new int[]{nextRow, nextCol, nextCost, deltaIdx});
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        input = board;
        size = board.length;
        
        bfs();
        return answer;
    }
}