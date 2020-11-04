package Programmers;

class VisitedLength {
    public int solution(String dirs) {

        int answer = 1;
        int[][] field = new int[10][10];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }

        char[] dirsToChar = dirs.toCharArray();

        int x = 4;
        int y = 4;
        field[x][y] = 1;
        for (int i = 0; i < dirsToChar.length; i++) {
            char command = dirsToChar[i];
            if (command == 'U') {
                if(x + 1 >= 0 && x < 10 && y >= 0 && y < 10){
                    if(field[x + 1][y] == 0) answer += 1;
                    field[x += 1][y] = 1;
                }

            }
            if (command == 'D') {
                if(x - 1 >= 0 && x < 10 && y >= 0 && y < 10){
                    if(field[x - 1][y] == 0) answer += 1;
                    field[x += -1][y] = 1;
                }

            }
            if (command == 'R') {
                if(x >= 0 && x < 10 && y + 1 >= 0 && y < 10){
                    if(field[x][y + 1] == 0) answer += 1;
                    field[x][y += 1] = 1;
                }

            }
            if (command == 'L') {
                if(x >= 0 && x < 10 && y - 1>= 0 && y < 10){
                    if(field[x][y - 1] == 0) answer += 1;
                    field[x][y += -1] = 1;
                }

            }
        }
        return answer;
    }


}