import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothType = new HashMap<>();

        // 옷 종류에 따른 옷 갯수 구하기
        for (int i = 0; i < clothes.length; i++) {
            // 옷 종류가 이미 있으면 카운트 추가 , 해당 옷이 없으면 넣고 카운트 1
            clothType.put(clothes[i][1], clothType.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 조합을 센다. 옷 종류 별로 가지고 있는 옷갯수를 보자 추가로 옷종류 별로 안입을 경우의 수를 더한다.
        // 예를 들면 모자 2개 상의 3개 라고 한다면 모자로 나올수 있는 경우는 모자1, 모자2, 안입음 이렇게 3가지가 나온다.
        // 즉, 옷 종류에 있는 갯수 + 1을 해야 옷을 입는 경우의 수가 나온다.
        // 따라서 clothType.get(key) + 1 하고 answer에 곱해나가면 경우의수가 나온다. 이후 마지막에 - 1을 한다.(안입는 경우의수)
        for (String key:clothType.keySet()) {
            answer *= clothType.get(key) + 1;
        }
        // 아무것도 안입는 경우의 수 제거
        return answer - 1;
    }

    public static void main(String[] args) {

        String[][] wears = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] wears2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        Camouflage clothes = new Camouflage();
        System.out.println(clothes.solution(wears));

    }
}
