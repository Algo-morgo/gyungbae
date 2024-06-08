class Solution {
    public String solution(int n, int k, String[] cmd) {
        //LinkedList 구현
        Node[] nodeArr = new Node[1000000];

        //Node 생성
        for (int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
            nodeArr[nodeIdx] = new Node();
        }

        //Node 간 연결
        for (int nodeIdx = 1; nodeIdx < n; nodeIdx++) {
            nodeArr[nodeIdx - 1].next = nodeArr[nodeIdx];
            nodeArr[nodeIdx].prev = nodeArr[nodeIdx - 1];
        }

        Stack<Node> deletedStack = new Stack();
        Node selectNode = nodeArr[k];

        for(String command : cmd) {
            if(command.startsWith("D")) {
                int moveCnt = Integer.valueOf(command.substring(2));
                for(int move = 1; move <= moveCnt; move++) {
                    //다음 노드 선택
                    selectNode = selectNode.next;
                }
            }
            else if(command.startsWith("U")) {
                int moveCnt = Integer.valueOf(command.substring(2));
                for(int move = 1; move <= moveCnt; move++) {
                    //이전 노드 선택
                    selectNode = selectNode.prev;
                }
            }
            else if(command.equals("C")) {
                //선택 노드 삭제
                selectNode.removed = true;
                deletedStack.push(selectNode);

                //이전 노드에 다음 노드 연결
                if(selectNode.prev != null)
                    selectNode.prev.next = selectNode.next;

                //마지막 노드가 아닌 경우
                if(selectNode.next != null) {
                    //다음 노드에 이전 노드 연결
                    selectNode.next.prev = selectNode.prev;
                    //다음 노드 선택
                    selectNode = selectNode.next;
                } else {
                    //마지막 노드(이전 노드 선택)
                    selectNode = selectNode.prev;
                }
            }
            else {
                Node restoredNode = deletedStack.pop();
                restoredNode.removed = false;

                if(restoredNode.prev != null) {
                    restoredNode.prev.next = restoredNode;
                }

                if(restoredNode.next != null) {
                    restoredNode.next.prev = restoredNode;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
            if(nodeArr[nodeIdx].removed)
                answer.append("X");
            else
                answer.append("O");
        }

        return answer.toString();
    }

    class Node {

        boolean removed;
        Node prev;
        Node next;
    }
}