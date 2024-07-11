class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for(String operation : logs) {
            if(operation.equals("../")) {
                depth = depth == 0 ? 0 : depth - 1;
            } else if(operation.equals("./")) {
                continue;
            } else {
                depth++;
            }
        }

        return depth;
    }
}