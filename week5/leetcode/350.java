class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    int[] numCnt = new int[1001];
    for(int num1 : nums1){
        numCnt[num1]++;
    }
    
    List<Integer> intersectList = new ArrayList<>();
    for(int num2 : nums2){
        if(numCnt[num2] > 0){ 
            intersectList.add(num2);
            numCnt[num2]--;
        }
    }
        
    int[] result = new int[intersectList.size()];
    for (int idx = 0; idx < intersectList.size() ; idx++) {
        result[idx] = intersectList.get(idx);
    }
    return result;
    }
}