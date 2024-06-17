class Solution {
    class Node {
        int idx;
        String name;
        Node referralNode;
            
        public Node (int memberIdx, String name) {
            this.idx = memberIdx;
            this.name = name;
        }
    }
    Node[] nodeArr;
    
    int memberCnt;
    void addMember(String[] enroll) {
        for(int memberIdx = 0; memberIdx < memberCnt; memberIdx++) {
            nodeArr[memberIdx] = new Node(memberIdx, enroll[memberIdx]);
        }
    }
    
    int sellerCnt;
    void addReferral(String[] referral) {
        for(int memberIdx = 0; memberIdx < memberCnt; memberIdx++) {
            if(referral[memberIdx].equals("-")) {
                continue;
            }
            
            for(Node node : nodeArr) {
                if(node.name.equals(referral[memberIdx])) {
                    nodeArr[memberIdx].referralNode = node;
                    break;
                }
            }
        }
    }
    
    int[] result;
    public void sendProfit(String[] seller, int[] amount) {        
        for(int sellerIdx = 0; sellerIdx < sellerCnt; sellerIdx++) {
            int currentIdx = 0;
            for(Node node : nodeArr) {
                if(node.name.equals(seller[sellerIdx])) {
                    currentIdx = node.idx;
                    break;
                }
            }
            
            int profit = amount[sellerIdx] * 100;
            int send = (int) profit / 10;
            
            if(nodeArr[currentIdx].referralNode == null) {
                result[currentIdx] += profit - send;
                continue;
            }
            
            while(true) {
                result[currentIdx] += (profit - send);
                profit = send;
                
                if(profit < 1) {
                    break;
                }
                
                send = (int) profit / 10;
                currentIdx = nodeArr[currentIdx].referralNode.idx;
                
                if(nodeArr[currentIdx].referralNode == null) {
                    result[currentIdx] += (profit - send);
                    break;
                }
            }
            
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        memberCnt = enroll.length;
        sellerCnt = seller.length;
        
        nodeArr = new Node[memberCnt];
        addMember(enroll);
        addReferral(referral);
        
        result = new int[memberCnt];
        sendProfit(seller, amount);
        
        return result;
    }
}