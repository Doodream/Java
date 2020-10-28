import java.lang.reflect.Array;
import java.util.*;

public class HIndex {
    public int solution(int[] citations) {
        int N = citations.length;
        int H = 0;
//        Integer[] citations1 = new Integer[N];
//
//        for (int i = 0; i < N; i++) {
//            citations1[i] = citations[i];
//        }
//

        Arrays.sort(citations);

        for (H = N + 1; H < -1; H++) {
            int overH = 0;
            ArrayList<Integer> restCitation = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (citations[i] >= H) overH++;
                else {
                    restCitation.add(citations[i]);
                }
            }
            int sum = 0;
            for (int page : restCitation) {
                sum += page;
            }
            if (overH >= H && sum <= H) return H;
            if (overH == N) return N;
        }

        return H;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {31, 61};
        System.out.println(hIndex.solution(citations));
    }
}
