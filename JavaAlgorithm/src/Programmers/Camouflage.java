package Programmers;

import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothType = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            clothType.put(clothes[i][1], clothType.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String key:clothType.keySet()) {
            answer *= clothType.get(key) + 1;
        }

        return answer -1;
    }

    public static void main(String[] args) {

        String[][] wears = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] wears2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        Camouflage clothes = new Camouflage();
        System.out.println(clothes.solution(wears));

    }
}
