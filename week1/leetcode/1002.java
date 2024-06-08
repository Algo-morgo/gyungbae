public class Solution {
    public List<String> commonChars(String[] words) {
        List<String> resultList = new ArrayList<>();

        if(words.length == 1) {
            for(char ch : words[0].toCharArray()) {
                resultList.add(String.valueOf(ch));
            }
            return resultList;
        }

        int[][] charCntArr = new int[words.length][26];
        for(int wordIdx = 0; wordIdx < words.length; wordIdx++) {
            String word = words[wordIdx];
            for(int charIdx = 0; charIdx < word.length(); charIdx++) {
                charCntArr[wordIdx][word.charAt(charIdx) - 'a']++;
            }
        }

        List<Integer> onceList = new ArrayList<>();
        List<Integer> duplicateList = new ArrayList<>();
        for(int cntIdx = 0; cntIdx < 26; cntIdx++) {
            if(charCntArr[0][cntIdx] == 1) {
                onceList.add(cntIdx);
            }

            if(charCntArr[0][cntIdx] > 1) {
                duplicateList.add(cntIdx);
            }
        }

        for(int onceIdx : onceList) {
            boolean containedAll = true;
            for(int wordIdx = 1; wordIdx < words.length; wordIdx++) {
                if(charCntArr[wordIdx][onceIdx] < 1) {
                    containedAll = false;
                    break;
                }
            }

            if(containedAll) {
                resultList.add(String.valueOf((char)(onceIdx + 'a')));
            }
        }

        loop: for(int duplicateIdx : duplicateList) {
            int containedTimes = charCntArr[0][duplicateIdx];
            for(int wordIdx = 1; wordIdx < words.length; wordIdx++) {
                int checkCnt = charCntArr[wordIdx][duplicateIdx];

                if(checkCnt == 0) {
                    continue loop;
                }

                containedTimes = Math.min(containedTimes, checkCnt);
            }

            while(containedTimes > 0) {
                resultList.add(String.valueOf((char)(duplicateIdx + 'a')));
                containedTimes--;
            }
        }

        return resultList;
    }
}
