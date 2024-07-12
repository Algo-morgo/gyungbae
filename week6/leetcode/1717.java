class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
  
        char first = 'a';
        char second = 'b';
        int firstScore = x;
        int secondScore = y;
        
        if (x < y) {
            first = 'b';
            second = 'a';
            firstScore = y;
            secondScore = x;
        }

        int answer = 0;
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && ch == second) {
                stack.pop();
                answer += firstScore;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder left = new StringBuilder();
        while (!stack.isEmpty()) {
            left.append(stack.pop());
        }

        s = left.reverse().toString();
        stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second && ch == first) {
                stack.pop();
                answer += secondScore;
            } else {
                stack.push(ch);
            }
        }

        return answer;
    }
}