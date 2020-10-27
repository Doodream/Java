import java.util.*;

class Paper {
    private int priority;

    public Paper(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}


class Printer {
    // 맨앞의 원소가 뒤에 있는 원소들보다 큰 경우 true 하나라도 큰것이 있는 경우 false;
    public boolean IsPriority(ArrayList<Paper> list) {
        int tmp = list.get(0).getPriority();
        for (int i = 1; i < list.size(); i++) {
            if (tmp < list.get(i).getPriority()) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] priorities, int location) {
        // 기다리는 용지들
        ArrayList<Paper> waitingList = new ArrayList<>();
        // 프린트되는 순서대로 나오는 용지들
        ArrayList<Paper> printList = new ArrayList<>();
        // waitingList를 만들어서 우선순위를 넣는다.
        for (int priority : priorities) {
            waitingList.add(new Paper(priority));
        }
        // 현재페이지
        Paper locationPaper = waitingList.get(location);

        // 기다리는 용지가 없을 때 까지 반복
        while (!waitingList.isEmpty()) {
            // 하나의 if문안에서 돌리면 index 에러날까봐 꽂는 flag
            // 기다리는 용지가 있는경우만 실행
            if (!waitingList.isEmpty()) {
                // 원소가 하나라도 큰것이 있는 경우 맨뒤로
                if (!IsPriority(waitingList)) {
                    waitingList.add(waitingList.get(0));
                } else {
                    // 0번째 원소가 가장 큰원소이면 print
                    printList.add(waitingList.get(0));
                }
                //  waitingList의 첫번째 원소는 출력되든 맨뒤로가든 없어진다.
                waitingList.remove(0);

            }
        }
        for (Paper paper : waitingList) {
            System.out.print(paper.getPriority() + " ");
        }
        System.out.println("");
        for (Paper paper : printList) {
            System.out.print(paper.getPriority() + " ");
        }
        System.out.println("");

        int answer = -1;
        // 현재 페이지를 출력된 페이지에서 찾기
        for (int i = 0; i < printList.size(); i++) {
            if (printList.get(i).equals(locationPaper)) {
                answer = i;
            }
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities = {2, 1, 3, 1, 2};
        int location = 0;
        System.out.println(printer.solution(priorities, location));
    }
}
