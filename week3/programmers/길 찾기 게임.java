import java.util.*;

class Solution {
    class Node {
        int idx;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
    
    void makeTree(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        }
    }
    
    int[][] result;
    int currentIdx;
    //root >> left >> right
    void preOrder(Node node) {
        if(node != null) {
            result[0][currentIdx++] = node.idx;
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    //left >> right >> root
    void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            result[1][currentIdx++] = node.idx;
        }
    }
    
    
    public int[][] solution(int[][] nodeinfo) {        
        Node[] nodeArr = new Node[nodeinfo.length];
        for(int nodeIdx = 0; nodeIdx < nodeinfo.length; nodeIdx++) {
            nodeArr[nodeIdx] = new Node(nodeIdx + 1, nodeinfo[nodeIdx][0], nodeinfo[nodeIdx][1]);
        }
        
        Arrays.sort(nodeArr, (o1, o2) -> {
           if(o1.y == o2.y) {
               return o1.x - o2.x;
           } else {
               return o2.y - o1.y;
           }
        });
        
        //트리 생성
        Node root = nodeArr[0];
        for(int nodeIdx = 1; nodeIdx < nodeArr.length; nodeIdx++) {
            makeTree(root, nodeArr[nodeIdx]);
        }
        
        result = new int[2][nodeArr.length];
        currentIdx = 0;
        preOrder(root);
        currentIdx = 0;
        postOrder(root);
        return result;
    }
}