import java.util.*;

public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> finishDay = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        //남은 일 수 계산
        for (int i = 0; i <progresses.length ; i++) {
            int day = 0;
            while(true){
                if(progresses[i] >= 100) {
                    finishDay.add(day);
                    break;
                }
                progresses[i] += speeds[i];
                day++;
            }
        }
        // 배포 가능한 count 처음에는 배포가능한 갯수가 1이다.
        int releaseCount = 1;
        // 첫 개발의 남은 날
        int tmp = finishDay.get(0);
        // 개발의 남은 날이 더 큰 것이 나오면 배포하고 다음턴, 아니면 배포가능한 개발갯수 증가
        for (int i = 1; i < finishDay.size(); i++) {
            if(tmp < finishDay.get(i)){
                answerList.add(releaseCount);
                releaseCount = 0;
                tmp = finishDay.get(i);
            }
            releaseCount ++;
        }
        // 배포안된 개발이 존재한다면 배포
        if(releaseCount > 0) answerList.add(releaseCount);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        System.out.println(finishDay);
        System.out.println(answerList);
        return answer;
    }

    public static void main(String[] args) {
        FunctionDev functionDev = new FunctionDev();
        int[] progresses = {99, 1, 55, 1, 1, 0};
        int[] speeds = {1, 30, 5, 1, 1, 1};
        System.out.println(functionDev.solution(progresses, speeds));
    }
}
