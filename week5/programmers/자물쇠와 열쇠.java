class Solution {
    
    boolean check(int[][] map, int[][] key, int lockSize){
        int keySize = key.length;
        int mapSize = map.length;
        for(int mapRow = 0; mapRow < mapSize - keySize + 1; mapRow++){
            for(int mapCol = 0; mapCol < mapSize - keySize + 1; mapCol++){
                
                //map + key
                for(int keyRow = 0; keyRow < keySize; keyRow++){
                    for(int keyCol = 0; keyCol < keySize; keyCol++){
                        map[mapRow + keyRow][mapCol + keyCol] += key[keyRow][keyCol];
                    } 
                }
                
                // 자물쇠 부분이 전부 1이 됐는지 확인
                boolean flag = true;
                for (int lockRow = keySize - 1; lockRow < keySize - 1 + lockSize; lockRow++) {
                    for (int lockCol = keySize - 1; lockCol < keySize - 1 + lockSize; lockCol++) {
                        if (map[lockRow][lockCol] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }

                if (flag) {
                    return true;
                }
                
                //map 복구 : map - key
                for(int keyRow = 0; keyRow < keySize; keyRow++){
                    for(int keyCol = 0; keyCol < keySize; keyCol++){
                        map[mapRow + keyRow][mapCol + keyCol] -= key[keyRow][keyCol];
                    }
                }
                
            }
        }
        
        return false;
    }
    
    void rotate(int[][] key){
        int size = key.length;
        int[][] temp = new int[size][size];  
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                temp[row][col] = key[size - col - 1][row];
            }
        }
          
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                key[row][col] = temp[row][col];
            }
        }
    }
    
    //자물쇠 확장이 핵심
    public boolean solution(int[][] key, int[][] lock) {
        int keySize = key.length;
        int lockSize = lock.length;
        
        int size = lockSize + keySize * 2 - 2;
        int[][] map = new int[size][size];    
        
        //lock 기입
        for(int row = keySize - 1; row < keySize + lockSize - 1; row++){
            for(int col = keySize - 1; col < keySize + lockSize - 1; col++){
                map[row][col] = lock[row - (keySize - 1)][col - (keySize - 1)];
            }
        }
        
        //돌려가며 확인
        for(int rotateCnt = 0; rotateCnt < 4; rotateCnt++){
            if(check(map, key, lockSize)){
                return true;
            }
            rotate(key); 
        }
        
        return false;
    }
}
