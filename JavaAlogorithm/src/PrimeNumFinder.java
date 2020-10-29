import com.sun.deploy.net.MessageHeader;

import java.util.*;


public class PrimeNumFinder {
    public static final HashSet<Integer> com = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        // 숫자를 int형으로 변환하여 배열에 저장
        int[] intNumbers = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            // String 클래스에서 i번째 char값을 꺼내려면 charAt 메소드 사용해야한다.
            // 또한 char 값을 int형으로 변환하려면 char - '0' 해야한다.
            intNumbers[i] = numbers.charAt(i) - '0';
        }

        // 1개의 숫자만을 뽑는 방법부터 배열 전체를 뽑는 방법 까지 HashSet에 저장
        for (int i = 1; i <= intNumbers.length + 1; i++) {
            combination(intNumbers, i);
        }

        Iterator iter = com.iterator();    // Iterator 사용
        while (iter.hasNext()) {//값이 있으면 true 없으면 false
            System.out.println(iter.next());
            if (isPrimeNumber((Integer) iter.next())) answer++;
        }
        return answer;
    }


    public static void combination(int[] arr, int destNum) {
        int[] temp = new int[destNum];
        combination(arr, 0, destNum, temp);
    }

    // 원배열,
    public static void combination(int[] arr, int curLoc, int destNum, int[] temp) {
        // 결과물 출력부분
        if (0 == destNum) {
            String numStr = null;
            // temp는 숫자들을 모아놓은 배열이므로 그것자체를 String으로 만들고 int화 시키면된다.
            for (int i = 0; i < temp.length; i++) {
                numStr = Integer.toString(temp[i]);
                //System.out.println(numStr);
            }
            com.add(Integer.valueOf(numStr));
            return;
        }
        for (int i = curLoc; i < arr.length; i++) {
            temp[temp.length - destNum] = i;
            combination(arr, i + 1, destNum - 1, temp);
        }
    }

    public boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumFinder primeNumFinder = new PrimeNumFinder();
        String numbers = "17";
        System.out.println(primeNumFinder.solution(numbers));
    }
}
