public class Card implements Comparable<Card>{
    // 상수들, 바뀔 필요가 없기에 final로 정의하였고 getter, setter 함수가 없어도 된다. (상수기 떄문에)
    public final int suitNumber;
    public final int rankNumber;

    // 생성자 인수 : 카드 종류, 카드 랭크
    public Card(int suitNumber, int rankNumber) {
        this.suitNumber = suitNumber;
        this.rankNumber = rankNumber;

    }

    @Override
    public int compareTo(Card o) {
        if(suitNumber == o.suitNumber){
            return rankNumber - o.rankNumber;
        }
        return suitNumber - o.suitNumber;

    }

    // suitNumber의 getter
    // 현재카드의 suitNumber를 문자열출력의 모양으로 바꾼다.
    public String getSuit() {
        String suit = null;
        switch (this.suitNumber) {
            case 1: {
                suit = "Clubs";
                break;
            }
            case 2: {
                suit = "Hearts";
                break;
            }
            case 3: {
                suit = "Diamonds";
                break;
            }
            case 4: {
                suit = "Spaces";
                break;
            }
            default: {
                System.out.println("1,2,3,4 중 하나의 값만 입력하세요.");
                break;
            }

        }
        return suit;
    }

    // suitRank의 getter
    // 현재카드의 suitRank를 문자열출력의 모양으로 바꾼다.
    public String getRank() {
        String rank = null;
        switch (this.rankNumber) {
            case 1: {
                rank = "Ace";
                break;
            }
            case 2: {
                rank = "2";
                break;
            }
            case 3: {
                rank = "3";
                break;
            }
            case 4: {
                rank = "4";
                break;
            }
            case 5: {
                rank = "5";
                break;
            }
            case 6: {
                rank = "6";
                break;
            }
            case 7: {
                rank = "7";
                break;
            }
            case 8: {
                rank = "8";
                break;
            }
            case 9: {
                rank = "9";
                break;
            }
            case 10: {
                rank = "10";
                break;
            }
            case 11: {
                rank = "Jack";
                break;
            }
            case 12: {
                rank = "Queen";
                break;
            }
            case 13: {
                rank = "King";
                break;
            }
            default: {
                System.out.println("1 ~ 13 중 하나의 값만 입력하세요.");
                break;
            }
        }
        return rank;
    }
    //String 함수의 toString 함수의 오버라이드
    @Override
    public String toString(){
        return this.getRank() + " of " + this.getSuit();
    }
}
