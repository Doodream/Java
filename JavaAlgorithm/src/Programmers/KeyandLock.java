package Programmers;

import java.util.*;

// 자물쇠와 열쇠
// 이 문제는 lock을 key.length - 1만큼 위아래 좌우를 확장시켜서 key를 돌려보며 하나씩 대조하면서 찾아야한다.

class KeyandLock {


    public int[][] leftRotation(int[][] key, int count) {
        int row;
        int col;
        int[][] answer = key.clone();
        for (int i = 0; i < count; i++) {
            for (row = 0; row < key.length; row++) {
                for (col = 0; col < key.length; col++) {
                    answer[row][col] = key[col][key.length - 1 - row];
                }
            }
        }

        return answer;
    }

//    public int[][] moveDirect(int[][] key, int count){
//
//    }

    public int[][] move(int[][] key, String direction, int count) {
        int row;
        int col;
        int dx = 0;
        int dy = 0;
        if (direction.equals("U")) {
            dx = 0;
            dy = -1;
        }
        if (direction.equals("D")) {
            dx = 0;
            dy = 1;
        }
        if (direction.equals("R")) {
            dx = -1;
            dy = 0;
        }
        if (direction.equals("L")) {
            dx = 1;
            dy = 0;
        }

        int[][] answer = key.clone();
        for (int i = 0; i < count; i++) {
            for (row = 0; row < key.length; row++) {
                for (col = 0; col < key.length; col++) {
                    int rowN = row + dx;
                    int colN = col + dy;

                    if(rowN < key.length && rowN >= 0 && colN < key.length && colN >= 0) answer[row][col] = key[rowN][colN];
                    else answer[row][col] = 0;
                }
            }
        }

        return answer;

    }

//    public boolean recuriveFind(int key[][], int keyclone[][]){
//        String[] direction = {"U", "D", "R", "L"};
//
//    }

    public boolean solution(int[][] key, int[][] lock) {
        int[][] keyClone = lock.clone();
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if(lock[i][j] == 0) keyClone[i][j] = 1;
                else keyClone[i][j] = 0;
            }
        }
        // 회전방향 돌리면서 구분
        for (int i = 0; i < 4; i++) {
            // 이동방향 설정해서 몇번 이동하느냐
            for (int j = 0; j < 4; j++) {

            }
        }
        boolean answer = true;
        return answer;
    }
}