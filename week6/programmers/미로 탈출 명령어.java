import java.util.*;

class Solution {
    static class Info {
        int row, col, count;
        String path;

        public Info(int row, int col, int count, String path) {
            this.row = row;
            this.col = col;
            this.count = count;
            this.path = path;
        }
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] deltaRow = {1, -1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};
        char[] direction = {'d', 'u', 'l', 'r'};

        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparing(info -> info.path));
        boolean[][][] visited = new boolean[n][m][k + 1]; //좌표별 이동 횟수 고려

        visited[x - 1][y - 1][0] = true;
        queue.add(new Info(x - 1, y - 1, 0, "")); // 행, 열, 이동 횟수, 경로

        while (!queue.isEmpty()) {
            Info current = queue.poll();
            int currentRow = current.row;
            int currentCol = current.col;
            int currentCnt = current.count;
            String path = current.path;

            int moveCnt = k - currentCnt;
            int distance = Math.abs(currentRow - (r - 1)) + Math.abs(currentCol - (c - 1));

            // 이동 횟수 - 거리 홀수면 불가능(원래 자리로 돌아오려면 짝수 이동 필요)
            if (distance > moveCnt || (moveCnt - distance) % 2 != 0) {
                continue;
            }

            if (currentRow == (r - 1) && currentCol == (c - 1) && currentCnt == k) {
                return path;
            }

            for (int deltaIdx = 0; deltaIdx < 4; deltaIdx++) {
                int nextRow = currentRow + deltaRow[deltaIdx];
                int nextCol = currentCol + deltaCol[deltaIdx];
                int nextCnt = currentCnt + 1;

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol][nextCnt]) {
                    continue;
                }

                visited[nextRow][nextCol][nextCnt] = true;
                queue.add(new Info(nextRow, nextCol, nextCnt, path + direction[deltaIdx]));
            }
        }

        return "impossible";
    }
}