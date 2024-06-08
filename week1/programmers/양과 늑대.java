import java.util.*;

class Solution {
    ArrayList<Integer>[] childNodeList;
    int[] infoArr;
    int answer;
    
    void dfs(int currentIdx, int sheepCnt, int wolfCnt, List<Integer> nextNodeList) {
        if(infoArr[currentIdx] == 0) {
            sheepCnt++;
            answer = Math.max(answer, sheepCnt);
        }
        else {
            wolfCnt++;
            if(wolfCnt >= sheepCnt)
                return;
        }
        
        //현재 노드 방문 처리, 방문 예정 리스트에 현재 노드의 자식 노드 추가
        List<Integer> newList = new ArrayList<>();
        newList.addAll(nextNodeList);
        newList.remove(Integer.valueOf(currentIdx));
        
        if(childNodeList[currentIdx] != null) {
            for(int child : childNodeList[currentIdx]) {
                newList.add(child);
            }
        }
            
        for(int nextNode : newList) {
            dfs(nextNode, sheepCnt, wolfCnt, newList);
        }     
    }
    
    public int solution(int[] info, int[][] edges) {
        infoArr = info;
        childNodeList = new ArrayList[info.length];
        //자식 노드 저장
        for(int[] edgeArr : edges) {
            int parent = edgeArr[0];
            int child = edgeArr[1];
            if(childNodeList[parent] == null) 
                childNodeList[parent] = new ArrayList<>();
            childNodeList[parent].add(child);
        }
        
        List<Integer> nextNodeList = new ArrayList<>();
        nextNodeList.add(0);
        dfs(0, 0, 0, nextNodeList);
        return answer;
    }
}