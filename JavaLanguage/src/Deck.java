import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;
// 카드들을 모아둔 Deck 클래스 이므로 카드 ArrayList가 존재한다.
public class Deck<T> {
    protected ArrayList<T> cards = new ArrayList<>();
    // 카드리스트를 private으로 설정하여 getter 메소드
    public ArrayList<T> getCards() {
        return this.cards;
    }

    // 카드덱에 카드를 넣는 add 메소드
    public void addCard(T card) {
        this.cards.add(card);
    }

    // 덱안의 카드를 보여주는 print 메소드
    public void print() {
        for (T card : this.cards) {
            //System.out.println(card); <- toString을 오버라이드 하였으므로 같은 역할을 수행한다.
            System.out.println(card.toString());
        }
    }
    // 카드덱 안의 카드들을 랜덤으로 섞는다.
    public void shuffle() {
        Random random = new Random();
        int shuffleTimes = random.nextInt(46);
        for (int i = 0; i < shuffleTimes; i++) {
            int shuffleCard1 = random.nextInt(this.cards.size());
            int shuffleCard2 = random.nextInt(this.cards.size());
            Collections.swap(this.cards, shuffleCard1, shuffleCard2);
        }
        //Collections.shuffle(this.cards); 위 전체 코드와 같은 역할을 수행한다.
    }

    // 덱의 마지막 부분 5장을 가져와서 dealing 한다.
    public Deck deal(int count){
        Deck hand = new Deck();
        for (int i = 0; i < count; i++) {
            hand.addCard(this.cards.get(cards.size() - 1));
            this.cards.remove(this.cards.size() -1);
        }
        return hand;
    }
}
