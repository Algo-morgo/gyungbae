import java.util.*;

class Solution {
    public int[] solution(String s) {
        String str = s.substring(2, s.length() - 2);
        String[] strArr = str.split("},\\{");
        Arrays.sort(strArr, (String o1, String o2) -> o1.length() - o2.length());

        
        List<Integer> list = new ArrayList<>();
        for(String element : strArr) {
            String[] numArr = element.split(",");
            for(String strNum : numArr) {
                 if(!list.contains(Integer.valueOf(strNum))) {
                    list.add(Integer.valueOf(strNum));    
                 }
            }
        }
        
        int[] result = new int[list.size()];
        int idx = 0;
        for(int num : list) {
            result[idx++] = num;
        }
        
        return result;
    }
}