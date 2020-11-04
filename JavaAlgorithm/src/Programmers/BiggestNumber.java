package Programmers;

import java.util.*;

class Number {
    private int number;

    public int getNumber() {
        return number;
    }

    public Number(int number, int biggestNumber) {
        this.number = number;
    }

}

// 두개 숫자를 합쳐보고 더 크면 오름 차순으로 정렬
class AscendingString implements Comparator<Number> {
    @Override
    public int compare(Number a, Number b) {
        String thisNumber = Integer.toString(a.getNumber());
        String numNumber = Integer.toString(b.getNumber());
        return (numNumber + thisNumber).compareTo(thisNumber + numNumber);
    }
}


class BiggestNumber {
    public String solution(int[] numbers) {
        // 입력number를 ArrayList로 변경한다.
        ArrayList<Number> numbers1 = new ArrayList<>();
        // 가장 큰수를 찾자.
        int biggestNumber = 0;
        for (int num : numbers) {
            if (biggestNumber < num) biggestNumber = num;
        }

        // numbers를 객체에 담는다.
        for (int num : numbers) {
            numbers1.add(new Number(num, biggestNumber));
        }
        // 정렬
        Collections.sort(numbers1, new AscendingString());

        String answer = "";
        if (numbers1.get(0).getNumber() == 0) {
            return "0";
        }
        for (Number num : numbers1) {
            answer += Integer.toString(num.getNumber());
        }
        return answer;
    }

    public static void main(String[] args) {
        BiggestNumber biggestNumber = new BiggestNumber();
        int[] numbers = {1, 1, 2, 1, 101};
        System.out.println(biggestNumber.solution(numbers));
    }


}


