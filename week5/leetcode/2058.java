if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        List<Integer> criticalPoints = new ArrayList<>();
        ListNode prevNode = head;
        ListNode curNode = head.next;
        int index = 1; 
        
        while (curNode.next != null) {
            if ((curNode.val > prevNode.val && curNode.val > curNode.next.val) || 
                (curNode.val < prevNode.val && curNode.val < curNode.next.val)) {
                criticalPoints.add(index);
            }
            prevNode = curNode;
            curNode = curNode.next;
            index++;
        }
        
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }
        
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        
        for (int idx = 1; idx < criticalPoints.size(); idx++) {
            minDistance = Math.min(minDistance, criticalPoints.get(idx) - criticalPoints.get(idx - 1));
        }
        
        return new int[]{minDistance, maxDistance};