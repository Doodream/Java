package Programmers;

import java.util.*;

public class HIndex {
    public int solution(int[] citations) {
        int N = citations.length;
        int H = 0;

        Arrays.sort(citations);
        // H의 최대값을 구하는 것이므로 N부터 시작한다. H는 본질 적으로 원소의 값을 넘는 갯수를 의미한다.
        for (H = N; H > -1; H--) {
            //원소중 H를 넘는 논문의 수
            int overH = 0;
            for (int i = 0; i < N; i++) {
                if (citations[i] >= H) overH++;
            }
            // H를 넘는 논문의 수가 H보다 크거 같다면 H를 반환
            // H를 넘는 논문을 제외한 다른 논문은 생각할 필요가 없다. 왜냐면 H를 넘는 논문을 고려한 순간
            // 자동으로 배제되는 경우이기 때문이다.
            if (overH >= H) return H;
        }
        return H;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {};
        System.out.println(hIndex.solution(citations));
    }
}
