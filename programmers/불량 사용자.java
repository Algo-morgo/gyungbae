import java.util.*;

class Solution {
    String[] userIdArr;
    String[] bannedIdArr;
    boolean[] visited;
    Set<Set<String>> result = new HashSet<>();
    
    void count(Set<String> set, int depth) {
        if(depth == bannedIdArr.length) {
            result.add(set);
            return;
        }
        
        for(int userIdx = 0; userIdx < userIdArr.length; userIdx++) {
            if(set.contains(userIdArr[userIdx]))
                continue;
            
            if(checkMapped(bannedIdArr[depth], userIdArr[userIdx])) {
                set.add(userIdArr[userIdx]);
                count(new HashSet<>(set), depth + 1);
                set.remove(userIdArr[userIdx]);
            }
        }
    }
    
    boolean checkMapped(String bannedId, String userId) {
        if(userId.length() != bannedId.length()) 
            return false;
        
        boolean mapped = true;
        for(int charIdx = 0; charIdx < userId.length(); charIdx++) {
            if(bannedId.charAt(charIdx) == '*')
                continue;
            
            if(userId.charAt(charIdx) != bannedId.charAt(charIdx)) {
                mapped = false;
                break;
            }
        }
        
        return mapped;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        userIdArr = user_id;
        bannedIdArr = banned_id;
        visited = new boolean[userIdArr.length];
        
        count(new HashSet<>(), 0);
        
        return result.size();
    }
}