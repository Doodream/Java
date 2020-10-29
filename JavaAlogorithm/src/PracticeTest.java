import java.util.ArrayList;
import java.util.Collections;

// 사람 클래스를 만들어서 객체 비교를 한다.
class Person implements Comparable<Person> {
    public static int count = 0;
    private int[] pattern;
    private int patternNum = 0;

    public int getPatternNum() {
        return patternNum;
    }

    // 객체 비교를 통해서 오름차순으로 정렬했다. 맞은 갯수를 비교해서 객체를 정렬한다.
    @Override
    public int compareTo(Person o) {
        if (o.getAnswerCount() < this.getAnswerCount())
            return -1;
        else if (o.getAnswerCount() == this.getAnswerCount())
            return 0;
        else
            return 1;
    }

    private int answerCount = 0;

    public int[] getPattern() {
        return pattern;
    }

    public void setPattern(int[] pattern) {
        this.pattern = pattern;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    // 생성자 사람 고유의 패턴을 받아 저장하고 사람이 생성되면 객체 숫자를 생성한다.
    // 생겨난 순서에 따라 patternNum이 부여된다.
    public Person(int[] pattern) {
        this.pattern = pattern;
        this.count++;
        this.patternNum = count;
    }


}

public class PracticeTest {
    public int[] solution(int[] answers) {
        // 문제에서 주어진 패턴
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 가장 많이 맞춘 패턴을 넣을 리스트
        ArrayList<Integer> answerList = new ArrayList<>();

        // 각각 다른 패턴을 갖는 사람 3명
        Person person1 = new Person(pattern1);
        Person person2 = new Person(pattern2);
        Person person3 = new Person(pattern3);

        // 맞은 갯수를 센다.

        for (int i = 0; i < answers.length; i++) {
            // 패턴의 숫자는 한정되어 있고 문제수는 끝없이 많으니 %로 나눠서 패턴을 돌린다.
            if (person1.getPattern()[i % pattern1.length] == answers[i])
                person1.setAnswerCount(person1.getAnswerCount() + 1);
            if (person2.getPattern()[i % pattern2.length] == answers[i])
                person2.setAnswerCount(person2.getAnswerCount() + 1);
            if (person3.getPattern()[i % pattern3.length] == answers[i])
                person3.setAnswerCount(person3.getAnswerCount() + 1);
        }

        // 객체를 리스트에 담고 맞은 갯수에 따라 정렬시킨다.
        ArrayList<Person> answer = new ArrayList<>();
        answer.add(person1);
        answer.add(person2);
        answer.add(person3);
        Collections.sort(answer);

        // 오름차순 정렬을 통해 가장 많이 맞은 갯수를 가진 사람이 맨앞에 오고 순서대로 정렬된다.
        answerList.add(answer.get(0).getPatternNum());
        // 첫번째와 두번째가 모두 가장 많이 맞은 갯수라면 (같다면) 두번째도 정답리스트에 추가
        if (answer.get(0).getAnswerCount() == answer.get(1).getAnswerCount()) {
            answerList.add(answer.get(1).getPatternNum());
            // 세번째도
            if (answer.get(1).getAnswerCount() == answer.get(2).getAnswerCount()) {
                answerList.add(answer.get(2).getPatternNum());
            }
        }

        // 정답리스트에 있는 것을 반환형에 맞게 변형
        int[] ansArr = new int[answerList.size()];
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = answerList.get(i);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        PracticeTest practiceTest = new PracticeTest();
        int[] answers = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] returns = practiceTest.solution(answers);
        for (int num : returns) {
            System.out.print(num + " ");
        }

    }
}
