import java.util.*;

class Solution {
    int[][] adjMatrix;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        adjMatrix = new int[n + 1][n + 1];

        for (int areaIdx = 0; areaIdx < fares.length; areaIdx++) {
            int from = fares[areaIdx][0];
            int to = fares[areaIdx][1];
            int cost = fares[areaIdx][2];
            adjMatrix[from][to] = cost;
            adjMatrix[to][from] = cost;
        }

        int[] together = dijkstra(n, s);
        int minCost = Integer.MAX_VALUE;

        for (int areaIdx = 1; areaIdx <= n; areaIdx++) {
            int[] alone = dijkstra(n, areaIdx);
            int cost = together[areaIdx] + alone[a] + alone[b];
            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    public int[] dijkstra(int areaCnt, int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        boolean[] visited = new boolean[areaCnt + 1];
        int[] distanceArr = new int[areaCnt + 1];
        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        distanceArr[start] = 0;
        
        queue.add(new int[] {start, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentArea = current[0];
            int currentDist = current[1];

            if (visited[currentArea]) continue;
            visited[currentArea] = true;

            for (int areaIdx = 1; areaIdx <= areaCnt; areaIdx++) {
                if (adjMatrix[currentArea][areaIdx] != 0 && !visited[areaIdx]) {
                    int nextDist = currentDist + adjMatrix[currentArea][areaIdx];
                    
                    if (nextDist < distanceArr[areaIdx]) {
                        distanceArr[areaIdx] = nextDist;
                        queue.add(new int[]{areaIdx, nextDist});
                    }
                }
            }
        }

        return distanceArr;
    }
}