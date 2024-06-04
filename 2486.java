public class Solution {
    public int appendCharacters(String s, String t) {
        int tIdx = 0;

        for(int charIdx = 0; charIdx < s.length(); charIdx++) {
            if(s.charAt(charIdx) == t.charAt(tIdx)) {
                tIdx++;

                if(tIdx == t.length()) {
                    return 0;
                }
            }
        }

        return t.length() - tIdx;
    }
}
