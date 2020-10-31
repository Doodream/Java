package WinterCodingTest;

import java.util.Arrays;
import java.util.Objects;

public class CodingTest1 {
    public String solution(int n, int[][] delivery) {
        String answer = "";

        // 기본적으로 "?"로 초기화한다. 알수 없으니까
        String[] product = new String[n];
        for (int i = 0; i < product.length; i++) {
            product[i] = "?";
        }
        // 이전의 product의 배열을 클론
        String[] productCopy = new String[n];
        while (true) {
            productCopy = product.clone();
            for (int i = 0; i < delivery.length; i++) {
                // 만약 배송이 되었다면
                if (delivery[i][2] == 1) {
                    // 첫번째 상품과 두번쨰 상품은 재고가 남아있음
                    product[delivery[i][0] - 1] = "O";
                    product[delivery[i][1] - 1] = "O";
                    continue;
                }
                // 둘중에 하나가 재고가 확실한데 배송을 안했다면
                if (product[delivery[i][0] - 1].equals("O") || product[delivery[i][1] - 1].equals("O")) {
                    // 한 상품이 재고가 있다면 나머지는 없음
                    if (product[delivery[i][0] - 1].equals("O")) product[delivery[i][1] - 1] = "X";
                    if (product[delivery[i][1] - 1].equals("O")) product[delivery[i][0] - 1] = "X";
                }
                // 이외 상황들은 모두 ? 이다.
            }
            // 배열 비교를 여러번해도 같은 결과가 나온다면 그만.
            if (Arrays.equals(product, productCopy)) {
                break;
            }
        }
        for (String str : product) {
            answer += str;
        }
        return answer;
    }

    public static void main(String[] args) {
        CodingTest1 codingTest1 = new CodingTest1();
        int n = 6;
        int[][] delivery = {{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}};
        System.out.println(codingTest1.solution(6, delivery));
    }
}
