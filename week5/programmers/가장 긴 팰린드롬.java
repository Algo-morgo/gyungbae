class Solution
{
    public int solution(String s)
    {
        int maxLength = 0;
        int length = s.length();
        
        for (int currentLength = length; currentLength > 0; currentLength--) {
            for (int startIdx = 0; startIdx <= length - currentLength; startIdx++) {
                boolean flag = true;
                
                for (int leftIdx = 0; leftIdx < currentLength / 2; leftIdx++) {
                    if (s.charAt(startIdx + leftIdx) != s.charAt(startIdx + currentLength - 1 - leftIdx)) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    maxLength = currentLength;
                    return maxLength; 
                }
            }
        }
        
        return maxLength; 
    }
}