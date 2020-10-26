import java.util.*;

public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> finishDay = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        //각 progresses[i]를 speed[i]만큼 지나가게 한후 100이 달성 되면 몇일 걸리는 지
        //finishDay[i]에 저장
        for (int i = 0; i < progresses.length; i++) {
            // 작업한지 몇일이 지났냐?
            // 처음부터 1일이 지남
            int day = 1;
            // progresses[i]가 speeds[i]의 속도로 100이 넘을떄까지 증가시기고 넘으면 끝낸다.
            while (true) {
                progresses[i] += speeds[i];
                if (progresses[i] < 100) {
                    day++;
                } else {
                    finishDay.add(day);
                    break;
                }
            }
        }
        // progresses의 남은 일수들
        System.out.println(finishDay);

        // 배포할 갯수 , 처음에는 아무리 적어도 배포할 갯수는 1개 이상이므로 count = 1
        int count = 1;
        // 첫 progresses의 남은 일수
        int tmp = finishDay.get(0);
        // 두번째 progresses의 남은 일수 부터 tmp와 비교한다.
        for (int i = 1; i < finishDay.size(); i++) {
            // 남은 일수가 progresses[0]보다 클 경우 progresses[0]은 배포가된다.
            // 그리고 tmp는 progreses[0]보다 남은 일수가 많은 progress의 남은 일수가 된다.
            // 그리고 남은일수가 적은 것은 배포가 되므로 count = 0으로 초기화 된다.
            if (tmp < finishDay.get(i)) {
                answerList.add(count);
                tmp = finishDay.get(i);
                count = 0;
            }

            // tmp가 크던 말던 배포가능한 count횟수는 늘어난다.
            // tmp가 finishDay.get(i) 보다 작으면 대체된 tmp의 count는 1이 되어야 하므로 초기화의 의미
            // tmp가 finishDay.get(i) 보다 크거나 같으면 배포할 count는 늘어난다.
            count++;
        }
        // 반복문이 끝나고 배포해야할 갯수가 남았다면 배포한다.
        // 매우 중요하다. 마지막프로그램이 남았다면 배포해야한다.
        if (count > 0) answerList.add(count);

        // answer 옮겨 닮기
        System.out.println(answerList);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
            //System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        FunctionDev functionDev = new FunctionDev();
        int[] progresses = {99, 1, 55, 1, 1, 0};
        int[] speeds = {1, 30, 5, 1, 1, 1};
        System.out.println(functionDev.solution(progresses, speeds));
    }
}
