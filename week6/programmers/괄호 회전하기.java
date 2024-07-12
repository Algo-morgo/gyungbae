import java.util.*;

class Solution {
    StringBuilder sb;
    Map<Character, Character> pair;
    int answer;
    
    void rotate() {
        char first = sb.charAt(0);
        
        sb.deleteCharAt(0);
        sb.append(first);
    }
    
    
    void check(String str) {
        Stack<Character> stack = new Stack<>();
        for(int charIdx = 0; charIdx < str.length(); charIdx++) {
            char bracket = str.charAt(charIdx);
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if(stack.isEmpty()) {
                    return;
                }
                
                if(stack.pop() != pair.get(bracket)) {
                    return;
                }
            }
        }
        
        answer++;
    }
    
    public int solution(String s) {
        if(s.length() % 2 == 1) {
            return 0;
        }
        
        sb = new StringBuilder(s);
        pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        
        answer = 0;
        for(int rotate = 0; rotate < s.length(); rotate++) {
            if(rotate != 0) {
                rotate();
            }
            
            check(sb.toString());
        }
        
        return answer;
    }
}