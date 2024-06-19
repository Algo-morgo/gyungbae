class Solution {
    boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquetCnt = 0;
        int flowerCnt = 0;
        
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowerCnt++;
                if (flowerCnt == k) {
                    bouquetCnt++;
                    flowerCnt = 0;
                }
            } else {
                flowerCnt = 0;
            }
            
            if (bouquetCnt >= m) {
                return true;
            }
        }
        
        return false;
    }
    

    public int minDays(int[] bloomDay, int m, int k) {
        int flowerCnt = bloomDay.length;
        if (m * k > flowerCnt) {
            return -1;
        }

        int low = 1;
        int high = 0;
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}