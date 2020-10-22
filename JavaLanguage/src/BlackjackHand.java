import java.util.ArrayList;

// Deck 상속
public class BlackjackHand <T extends BlackjackCard> extends Deck<T> {

    // 손에 갖고 있는 카드들의 가치를 반환
    public int getValue(){
        // Ace 카드가 있는가?
        boolean isAce = false;
        // 핸드의 총가치
        int totalValue = 0;
        // 핸드의 카드들에서 카드를 하나씩 꺼내어 계산
        for (BlackjackCard card: this.cards) {
            // 이카드가 Ace인가?
            isAce = (card).isAce();
            // 이카드의 가치는?
            int value = (card).getValue();
            totalValue += value;
        }
        // 핸드에 에이스카드가 있고 총가치의 합이 21이 넘으면 핸드의 에이스는 1의 값을 가지므로
        if (isAce == true && totalValue > 21){
            totalValue -= 10;
        }
        return totalValue;
    }
    // 파산했는가?
    public boolean isBusted(){
        boolean busted = false;
        // 핸드의 값이 21이 넘으면 파산
        if (getValue() > 21){
            busted = true;
        }
        return busted;
    }
    // 블랙잭인가?
    public boolean isBlackjack(){
        boolean isBlackjack = false;
        // 핸드에 카드가 2개밖에 업고 가치가 21이면 블랙잭
        if (this.cards.size() == 2 && getValue() == 21){
            isBlackjack = true;
        }

        return isBlackjack;
    }
}

