package Programmers;

import java.util.*;

public class Maraton {
    public String solution(String[] participant, String[] completion) {
        String string = "";
        // HashMap 선언
        HashMap<String, Integer> hm = new HashMap<>();
        // 참가자모두에게 value 값을 1을 준다. 만약 이름이 중복된 참가자가 있다면 기존 값에서 + 1을 추가한다.
        for (String player : participant) {
            if (hm.containsKey(player)) {
                hm.put(player, hm.get(player) + 1);
            }
            else{
                hm.put(player, 1);
            }
        }
        // 완주자들은 키값을 -1 한다.
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        // 완주자들은 키값이 모두 0일 것이나 완주하지 못한 이들은 키값이 0 이상일 것이다.
        for (String player : hm.keySet()) {
            if (hm.get(player) > 0) {
                string = player;
            }
        }

        return string;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        Maraton hash_1 = new Maraton();
        System.out.println(hash_1.solution(participant, completion));
    }
}