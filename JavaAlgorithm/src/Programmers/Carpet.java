package Programmers;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        // 전체 박스의 칸수는 갈색 칸수 + 노란색 칸수
        int totalBox = brown + yellow;
        int[] answer= new int[2];
        // 짧은 길이의 변은 최소 2
        int shortLength = 2;
        while (true) {
            // 짧은 길이를 늘려가면서 긴변을 구하고 갈색 칸수와 노란색 칸수가 맞는지 확인
            int longLength = totalBox / shortLength;
            // 갈색칸수는 아래와 같은 조건으로 구할수있다., 노란색은 아래와 같다.
            if((longLength * 2 + shortLength * 2 - 4) == brown && (longLength - 2) * (shortLength - 2) == yellow){
                answer[0] = longLength;
                answer[1] = shortLength;
                // 조건이 맞으면 리턴
                return answer;
            }
            // 아니면 짧은길이를 늘리면서 다시
            shortLength++;
        }
    }

    public static void main(String[] args) {
        Carpet carpet = new Carpet();

        int[] rectangle = carpet.solution(8, 1);
        for (int num:rectangle) {
            System.out.println(num);
        }
    }
}
