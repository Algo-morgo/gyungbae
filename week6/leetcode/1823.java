class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> friendList = new ArrayList<>();
        for(int num = 1; num <= n; num++) {
            friendList.add(num);
        }

        int idx = 0;
        while(friendList.size() > 1) {
            idx = (idx + k - 1) % friendList.size();
            friendList.remove(idx);
        }

        return friendList.get(0);
    }
}

