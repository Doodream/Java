import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothName = new HashMap<>();
        HashMap<String, Integer> clothType = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            // 옷 이름이 이미 있으면 카운트 추가 해당 옷이 없으면 넣고 카운트 1
            clothName.put(clothes[i][0], clothName.getOrDefault(clothes[i][0], 0) + 1);
            // 옷 종류가 이미 있으면 카운트 추가 , 해당 옷이 없으면 넣고 카운트 1
            clothType.put(clothes[i][1], clothType.getOrDefault(clothes[i][1], 0) + 1);
        }


        for (String type:clothType.keySet()) {
            int count = 0;
            for (int i = 1; i < clothType.size(); i++) {
                count += i;
            }
            answer = (int) (count * Math.pow(2, clothType.size()));
        }

        if (clothType.keySet().size() == 1){ return clothes.length; }
        return clothes.length + answer;
    }

    public static void main(String[] args) {

        String[][] wears = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] wears2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        Camouflage clothes = new Camouflage();
        System.out.println(clothes.solution(wears));

    }
}
