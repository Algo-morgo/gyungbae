class Solution {
    public void sortColors(int[] nums) {
        int[] countArr = new int[3];

        for(int num : nums) {
            countArr[num]++;
        }

        int index = 0;
        for(int cntIdx = 0; cntIdx < 3; cntIdx++) {
            while(countArr[cntIdx] > 0) {
                 nums[index++] = cntIdx;
                countArr[cntIdx]--;
            }
        }
    }
}