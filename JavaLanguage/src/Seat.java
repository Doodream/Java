public class Seat {
    private String name;

    // seat의 예약자 이름 getter
    public String getName() {
        return name;
    }
    // seat의 예약자 이름으로 예약하는 메소드
    public void reserve(String name) {
        this.name = name;
    }

    // seat의 예약을 취소함
    public void cancel() {
        name = null;
    }

    // 해당 seat가 예약이 되었으면 true 아니면 false
    public boolean isOccupied() {
        return name != null;
    }

    // 해당 시트가 checkName으로 예약이 되었나 확인하는 메소드
    public boolean match(String checkName) {
        return name.equals(checkName);
    }
}