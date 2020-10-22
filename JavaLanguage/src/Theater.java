public class Theater {
    private Seat[][] seats;

    private int rowCount, colCount;

    // Theater 생성자 : 행, 열 인수.
    public Theater(int rowCount, int colCount) {
        // 행은 알파벳의 26자리를 넘어가지 못한다.
        if (rowCount > 26) {
            rowCount = 26; // number of alphabets
        }
        // 영화관의 시트 이중 배열을 생성한다.
        seats = new Seat[rowCount][colCount];
        // 해당 시트자리마다 시트객체를 생성한다.
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                seats[i][j] = new Seat();
            }
        }
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    // 시트 예약 메소드 : 이름, 행, 열, 열부터 오름차순으로 가는 자리 갯수
    public boolean reserve(String name, char rowChar, int col, int numSeat) {
        // 행, 열의 수가 맞지 않으면 예약 실패
        if ((col < 0 || col > colCount) || (getRowIndex(rowChar) < 0 || getRowIndex(rowChar) > rowCount)) {
            return false;
            // 예약한 좌석이 하나라도 이미 예약이 되어있다면 예약 실패
        } else {
            for (int i = 0; i < numSeat; i++) {
                // 예약 좌석수가 많아 좌석이 존재하지 않을 경우 예외처리
                try {
                    if (seats[getRowIndex(rowChar)][col + i - 1].isOccupied()) {
                        return false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
            }
            // 예약좌석수 만큼 예약.
            for (int i = 0; i < numSeat; i++) {
                seats[getRowIndex(rowChar)][col + i - 1].reserve(name);
            }
            return true;
        }

    }


    // 해당 이름으로 예약한 좌석을 취소 하고 예약 취소된 좌석수를 반환
    public int cancel(String name) {
        int cancelCount = 0;
        Seat s;
        // 예약한 좌석이 이미 예약이 되어있고 해당이름으로 된 것이 맞다면
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                s = seats[i][j];
                if ((s.isOccupied()) && (s.match(name))) {
                    // 예약취소
                    s.cancel();
                    cancelCount++;
                }
            }
        }

        return cancelCount;
    }
    // 행, 열, 좌석수를 주어주고 해당 좌석만큼 예약한 것을 취소하고 취소된 좌석수를 반환
    public int cancel(char rowChar, int col, int numSeat) {
        // 여기에 코드를 작성하세요
        int cancelCount = 0;
        Seat s;
        for (int j = 0; j < numSeat; j++) {
            // 해당 행, 열에서 좌석 수만큼 예약이 되었는지 확인하고 예약취소
            s = seats[getRowIndex(rowChar)][col + j - 1];
            if (s.isOccupied()) {
                s.cancel();
                cancelCount++;
            }
        }

        return cancelCount;
    }

    // 영화관 전체에서 예약된 좌석수 반환
    public int getNumberOfReservedSeat() {
        int reverseCount = 0;
        Seat s;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                s = seats[i][j];
                if (s.isOccupied()) {
                    reverseCount++;
                }

            }
        }
        return reverseCount;
        // 여기에 코드를 작성하세요
    }

    // 영화관에서 예약된 화면을 출력하는 메소드
    public void printSeatMatrix() {
        // 열 출력
        System.out.print("  ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        // 행 출력
        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                // 해당좌석이 예약이 되었는지 보여주기
                if (s.isOccupied()) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
    // 대문자 알파벳을 asci code를 이용해서 행의 숫자를 반환
    private int getRowIndex(char uppercaseChar) {
        return uppercaseChar - 'A';
    }
}