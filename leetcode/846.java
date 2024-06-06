class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        
        if(groupSize == 1)
            return true;

        Arrays.sort(hand);

        boolean[] arranged = new boolean[hand.length];
        for(int cardIdx = 0; cardIdx < hand.length; cardIdx++) {
            if(!arranged[cardIdx]) {
                int currentNum = hand[cardIdx];
                arranged[cardIdx] = true;
                int arrangeCnt = 1;
                for(int checkIdx = 0; checkIdx < hand.length; checkIdx++) {
                    if(arranged[checkIdx])
                        continue;
                    
                    if(hand[checkIdx] == currentNum + 1) {
                        arranged[checkIdx] = true;
                        arrangeCnt++;
                        if(arrangeCnt == groupSize)
                            break;
                        
                        currentNum = hand[checkIdx];
                    }
                }

                if(arrangeCnt != groupSize)
                    return false;
            }
        }

        return true;
    }
}