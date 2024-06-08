public class Solution {
    public int longestPalindrome(String s) {
        int[] lowerCntArr = new int[26];
        int[] upperCntArr = new int[26];

        for(int charIdx = 0; charIdx < s.length(); charIdx++) {
            char currentChar = s.charAt(charIdx);

            if('a' <= currentChar && currentChar <= 'z') {
                lowerCntArr[currentChar - 'a']++;
            }

            else {
                upperCntArr[currentChar - 'A']++;
            }
        }

        boolean evenContained = false;
        int answer = 0;

        for(int count : lowerCntArr) {
            if(count %2 == 0) {
                answer += count;
            } else {
                if(evenContained) {
                    answer += count / 2 * 2;
                } else {
                    evenContained = true;
                    answer += count;
                }
            }
        }

        for(int count : upperCntArr) {
            if(count %2 == 0) {
                answer += count;
            } else {
                if(evenContained) {
                    answer += count / 2 * 2;
                } else {
                    evenContained = true;
                    answer += count;
                }
            }
        }

        return answer;
    }
}