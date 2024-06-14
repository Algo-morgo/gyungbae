import java.util.*;

class Solution {
    List<List<Integer>> adjList;
    int[] distanceArr;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        
        adjList = new ArrayList<>();
        for(int areaIdx=0; areaIdx <= n; areaIdx++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] road:roads){
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }
        
        dijkstra(n, destination);
        
        int[] answer = new int[sources.length];
        for(int sourceIdx=0; sourceIdx < sources.length; sourceIdx++){
            if (distanceArr[sources[sourceIdx]] < Integer.MAX_VALUE){
                answer[sourceIdx] = distanceArr[sources[sourceIdx]];
            } else {
                answer[sourceIdx] = -1;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int n, int destination){
        distanceArr = new int[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        
        //도착지점에서 출발
        distanceArr[destination] = 0;
        queue.add(destination);
        
        while(!queue.isEmpty()){
            int currentArea = queue.poll();
            
            for(int areaIdx = 0; areaIdx < adjList.get(currentArea).size(); areaIdx++){
                //최솟값 갱신
                int nextArea = adjList.get(currentArea).get(areaIdx);
                if(distanceArr[currentArea] + 1 < distanceArr[nextArea]){
                    distanceArr[nextArea] = distanceArr[currentArea]+1;
                    queue.add(nextArea);
                }
            }
        }
    }
}