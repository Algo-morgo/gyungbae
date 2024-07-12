import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String lowStr1 = str1.toLowerCase();
        String lowStr2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        for (int charIdx = 0; charIdx < lowStr1.length() - 1; charIdx++) {
            char first = lowStr1.charAt(charIdx);
            char second = lowStr1.charAt(charIdx + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                list1.add("" + first + second);
            }
        }

        List<String> list2 = new ArrayList<>();
        for (int charIdx = 0; charIdx < lowStr2.length() - 1; charIdx++) {
            char first = lowStr2.charAt(charIdx);
            char second = lowStr2.charAt(charIdx + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                list2.add("" + first + second);
            }
        }

        Map<String, Integer> map1 = new HashMap<>();
        for (String s : list1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (String s : list2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        int intersectionSize = 0;
        int unionSize = 0;

        Set<String> allElements = new HashSet<>(map1.keySet());
        allElements.addAll(map2.keySet());

        for (String key : allElements) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            intersectionSize += Math.min(count1, count2);
            unionSize += Math.max(count1, count2);
        }

        if (unionSize == 0) {
            return 65536;
        }

        return (int) (((double) intersectionSize / unionSize) * 65536);
    }
}
