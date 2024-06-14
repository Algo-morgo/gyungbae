class Solution {
    public int minIncrementForUnique(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);

        for (int numIdx = 1; numIdx < nums.length; numIdx++) {
            if (nums[numIdx] <= nums[numIdx - 1]) {
                int gap = nums[numIdx - 1] + 1 - nums[numIdx];
                answer += gap;
                
                nums[numIdx] = nums[numIdx - 1] + 1;
            }
        }

        return answer;
    }
}