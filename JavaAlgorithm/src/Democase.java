import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Democase {
    public int[] solution(int[][] v) {
        HashMap<Integer, Integer> hashMapX = new HashMap<>();
        HashMap<Integer, Integer> hashMapY = new HashMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < v.length; i++) {
            hashMapX.put(v[i][0], hashMapX.getOrDefault(v[i][0], 0) + 1);
            hashMapY.put(v[i][1], hashMapY.getOrDefault(v[i][1], 0) + 1);
        }
        for (int i = 0; i < v.length; i++) {
            if(hashMapX.get(v[i][0]) == 1) answer[0] = v[i][0];
            if(hashMapY.get(v[i][1]) == 1) answer[1] = v[i][1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Democase solution = new Democase();
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int[] answer = solution.solution(v);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + "");
        }
    }
}