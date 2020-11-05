package Programmers.Combination;

public class Combination {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

//combination(조합을 적용시킬 배열[arr], 목표 길이[destNum]) 조합의 n = arr.length, r = 목표길이

//밑에껄 바로 사용해도 되나 결과물이 저장될 temp부분을 따로 추가하거나 해야함

//        for (int i = 1; i < arr.length + 1; i++) {
//            combination(arr, i);
//        }
        combination(arr, 2);
    }


    public static void combination(int[] arr, int destNum) {

        int[] temp = new int[destNum];

        combination(arr, 0, destNum, temp);

    }


    public static void combination(int[] arr, int curLoc, int destNum, int[] temp) {

// 결과물 출력부분

        if (0 == destNum) {

            for (int i = 0; i < temp.length; i++) {
                System.out.print(arr[temp[i]] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = curLoc; i < arr.length; i++) {
            temp[temp.length - destNum] = i;
            combination(arr, i + 1, destNum - 1, temp);
        }

    }

}