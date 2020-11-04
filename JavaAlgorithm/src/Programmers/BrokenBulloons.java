package Programmers;

import java.util.ArrayList;

class BrokenBulloons {
    public int solution(int[] a) {
        int count = a.length;

        for (int i = 0; i < a.length; i++) {
            int bulloon = a[i];
            ArrayList<Integer> leftList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                leftList.add(a[j]);
            }
            ArrayList<Integer> rightList = new ArrayList<>();
            for (int j = i + 1; j < a.length; j++) {
                rightList.add(a[j]);
            }

            ArrayList<Integer> minlist = new ArrayList<>();

            if (leftList.size() == 0 || rightList.size() == 0) continue;
            minlist.add(minBulloon(leftList));
            minlist.add(minBulloon(rightList));
            minlist.add(bulloon);

            ArrayList<Integer> answerList = new ArrayList<>();
            if (bulloon == maxBulloons(minlist)) {
                answerList.add(bulloon);
                System.out.print(bulloon+ " ");
                count--;
            }
        }
        return count;
    }

    //ArrayList의 최소값의 인덱스를 반환하는 함수
    public int minBulloon(ArrayList<Integer> list) {
        int num = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (num > list.get(i)) num = list.get(i);
        }
        return num;
    }

    public int maxBulloons(ArrayList<Integer> list) {
        int num = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (num < list.get(i)) num = list.get(i);
        }
        return num;
    }

    public static void main(String[] args) {
        BrokenBulloons solution = new BrokenBulloons();
        int[] a = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
        System.out.println(solution.solution(a));
    }
}

