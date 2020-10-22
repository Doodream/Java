public class Pokemon {
    public final String name;
    public final int cp;

    // 포켓몬 생성자 인수 : 이름, 전투력
    public Pokemon(String name, int cp) {
        this.name = name;
        this.cp = cp;
    }

    // String에서 toString이라는 원래 있는 메소드를 오버라이드
    @Override
    public String toString() {
        return name + "(" + cp + ")";
    }
}

