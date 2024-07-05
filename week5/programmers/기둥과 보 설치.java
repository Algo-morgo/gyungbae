class Solution {
    boolean[][] pillar;
    boolean[][] bo;
    
    boolean canDelete(int n) {    
        for(int row = 0; row <= n; row++) { 
            for(int col = 0; col <= n; col++) { 
                if(pillar[row][col] && checkPillar(row, col) == false) {    //기둥 불가능
                    return false;
                }  else if(bo[row][col] && checkBo(row, col) == false){   //보 불가능
                    return false; 
                } 
            }
        }
        return true;
    }

    boolean checkBo(int row, int col) {
        if(col > 0 && pillar[row][col - 1] || pillar[row + 1][col - 1]) {
            return true; // 한쪽 끝에 기둥이 있는 경우
        } else if(row > 0 && bo[row - 1][col] && bo[row + 1][col]) {
            return true; //양쪽 끝이 보와 동시에 연결되어 있는 경우
        }
        
        return false;
    }
    

    
    boolean checkPillar(int row, int col) {
        if(col == 0) {  //바닥에 설치하는 경우
            return true;
        } else if(col > 0 && pillar[row][col - 1]) {    //아래 기둥이 있는 경우
            return true;
        } else if(row > 0 && bo[row - 1][col] || bo[row][col]) {
            return true;
        } 
        
        return false;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 1][n + 1];
        bo = new boolean[n + 1][n + 1];
        
        int count = 0;
        for(int buildIdx = 0; buildIdx < build_frame.length; buildIdx++) {
            int x = build_frame[buildIdx][0];
            int y = build_frame[buildIdx][1];
            int type = build_frame[buildIdx][2];
            int action = build_frame[buildIdx][3];
            
            if(type == 0) { 
                if(action == 1) { //기둥 설치
                    if(checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }  
                } else { //기둥 삭제
                    pillar[x][y] = false;
                    if(canDelete(n) == false) {
                        pillar[x][y] = true;   
                    } 
                    else count--;
                }
            } else { 
                if(action == 1) {
                    if(checkBo(x, y)) { //보 설치
                        bo[x][y] = true;
                        count++;
                    } 
                } else { //보 삭제
                    bo[x][y] = false;
                    if(canDelete(n) == false) {
                        bo[x][y] = true;
                    }
                    else {
                        count--;
                    }
                }
            }
        }
        
        int[][] result = new int[count][3];
        int idx = 0;
        for(int row = 0; row <= n; row++) {
            for(int col = 0; col <= n; col++) {
                if(pillar[row][col]) {
                    result[idx][0] = row;
                    result[idx][1] = col; 
                    result[idx++][2] = 0;
                }
                if(bo[row][col]) {
                    result[idx][0] = row;
                    result[idx][1] = col;
                    result[idx++][2] = 1;
                }
            }
        }
        return result;
    } 
}