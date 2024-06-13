class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;

        for(int value : arr1) {
            max = Math.max(max, value);
        }

        int[] count = new int[max + 1];
        for(int value : arr1) {
            count[value]++;
        }

        int[] newArr = new int[arr1.length];
        int index = 0;
        for(int value : arr2) {
            while(count[value] > 0) {
                newArr[index++] = value;
                count[value]--;
            }
        }

        for(int cntIdx = 0; cntIdx <= max; cntIdx++) {
            while(count[cntIdx] > 0) {
                newArr[index++] = cntIdx;
                count[cntIdx]--;
            }
        }

        return newArr;
    }
}