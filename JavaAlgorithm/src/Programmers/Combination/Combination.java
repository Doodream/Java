package Programmers.Combination;


import java.util.ArrayList;
class Combination<T> {
    // 배열을 받아라
    private T[] user_id;
    private ArrayList<ArrayList<T>> resultArr;
    private boolean[] checked;

    public ArrayList<ArrayList<T>> solution(String[] user_id) {
        resultArr = new ArrayList<>();
        checked = new boolean[user_id.length];

        // 뽑을 갯수를 넣어라
        dfs(2, new ArrayList<>());
        return resultArr;
    }

    public void dfs(int selectAmount, ArrayList<T> arr) {
        if (arr.size() == selectAmount) {
            resultArr.add(arr);
            return;
        } else {
            for (int i = 0; i < user_id.length; i++) {
                if(!checked[i]){
                    // 리스트 사이즈가 뽑는 수보다 작아야지 dfs로 더 탐색한다.
                    checked[i] = true;
                    arr.add(user_id[i]);
                    // 기존에 있던 arr를 넣어야한다.
                    dfs(selectAmount, new ArrayList<>(arr));
                    checked[i] = false;
                    arr.remove(user_id[i]);
                }
            }
        }

    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        ArrayList<ArrayList<String>> answer = solution.solution(solution.user_id);
//        for (int i = 0; i < answer.size(); i++) {
//            for (int j = 0; j < answer.get(i).size(); j++) {
//                System.out.print(answer.get(i).get(j) + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println(answer.size());
//    }

}