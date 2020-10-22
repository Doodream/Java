public class BlackjackCard extends Card {
    // 블랙잭게임에서의 카드의 가치
    public final int value;

    // 생성자 : 인수 suitNumber, rankNumber

    public BlackjackCard(int suitNumber, int rankNumber) {
        // 부모클래스의 생성자 기능을 받고
        super(suitNumber, rankNumber);
        // value 값의 지정을 해준다.
        if (this.getRank().equals("Ace")) {
            this.value = 11;
        } else if (this.getRank().equals(("Jack")) || this.getRank().equals(("King")) || this.getRank().equals(("Queen"))) {
            this.value = 10;
        } else if (this.getRank().equals(("2"))) {
            this.value = 2;
        } else if (this.getRank().equals(("3"))) {
            this.value = 3;
        } else if (this.getRank().equals(("4"))) {
            this.value = 4;
        } else if (this.getRank().equals(("5"))) {
            this.value = 5;
        } else if (this.getRank().equals(("6"))) {
            this.value = 6;
        } else if (this.getRank().equals(("7"))) {
            this.value = 7;
        } else if (this.getRank().equals(("8"))) {
            this.value = 8;
        } else if (this.getRank().equals(("9"))) {
            this.value = 9;
        } else {
            System.out.println("숫자값이 Ace, Jack, King, Queen, 2~9값이 아닙니다.");
            this.value = -1;
        }
    }

    // 블랙잭카드의 value getter
    public int getValue() {
        return this.value;
    }

    // 블랙카드는 1혹은 11모두 있을 수 있으므로 Ace인지 확인하는 메소드
    public boolean isAce() {
        if (this.getRank().equals("Ace") || this.getRank().equals("11")) {
            return true;
        } else {
            return false;
        }
    }
}

