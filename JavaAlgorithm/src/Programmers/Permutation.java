package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Permutation {
    public int solution(String numbers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        permutation("", numbers, set);
        int count = 0;
        // HashSet 사용하기
        // HashSet을 배열처럼 사용하기 위해서는 iterator()가 꼭 필요하다.
        // iterator().hasNext()는 다음 원소가 있는지 없는지 판별한다.
        while (set.iterator().hasNext()) {
            // iterator().next()는 다음 원소를 불러온다.

            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;

    }

    // 소수를 찾을 때는 0과 1을 상관없고 3부터 시작해서 짝수도 거른다음
    // 해당 숫자의 제곱근까지만 나눠서 0이면 소수가 아닌 것으로 판별한다.
    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 순열
    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
        // 모든 글자들을 한글자 씩 빼서 prefix에 넣고 HashSet에 저장한다. 한 사이클 순열
        // 그 글자만 뺀 나머지 String만 재귀함수를 돌려서 결국에는 모든 글자에 대해 순열을 완성한다.
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
    }


}