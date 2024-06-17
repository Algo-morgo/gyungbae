import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for(String gem : gems) {
            if(!gemSet.contains(gem)) {
                gemSet.add(gem);
            }
        }

        Map<String, Integer> selectMap = new HashMap<>();
        int fromIdx = 0;
        int toIdx = 0;
        
        int minGap = Integer.MAX_VALUE;
        int minFrom = 0;
        int minTo = 0;
        while(toIdx < gems.length) {
            selectMap.put(gems[toIdx], selectMap.get(gems[toIdx]) == null ? 1 : selectMap.get(gems[toIdx]) + 1);
            
            if(selectMap.size() == gemSet.size()) {
                while(true) {
                    if(selectMap.get(gems[fromIdx]) - 1 == 0) {
                        break;
                    }
                    
                    selectMap.replace(gems[fromIdx], selectMap.get(gems[fromIdx]) - 1);
                    fromIdx++;
                }
                
                if(toIdx - fromIdx < minGap) {
                    minFrom = fromIdx;
                    minTo = toIdx;
                    minGap = toIdx - fromIdx;
                }
            }
            
            toIdx++;
        }
            
        return new int[]{minFrom + 1, minTo + 1};
    }
}