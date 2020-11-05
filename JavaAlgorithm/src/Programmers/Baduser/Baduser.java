package Programmers.Baduser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Combination<T> {
    private T[] arr;     //기준 배열
    private Stack<T> st; //조합을 저장할 스택
    public ArrayList<ArrayList<T>> result = new ArrayList<>();

    public Combination(T[] arr) {
        this.arr = arr;             //배열을 받아 객체에 저장한다.
        st = new Stack<T>(); //스택에 메모리를 할당한다.
    }

    public void addStack() {
        //스택에 있는 값들을 출력한다.
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < st.size(); i++) {
            //System.out.print(st.get(i) + " ");
            arrayList.add(st.get(i));
        }
        result.add(arrayList);
    }

    public ArrayList<ArrayList<T>> doCombination(int n, int r, int index) {
        // n : 전체 개수
        // r : 뽑을 개수
        // index 배열이다보니 현재 배열의 어디를 가리키고 있는지 필요하므로.
        if (r == 0) {
            //0개를 뽑는다는건 더 이상 뽑을 것이 없다는 말과 같으므로  스택을 출력하고 함수를 종료한다.
            addStack();
            return result;
        } else if (n == r) {
            //nCr 이라는 건 나머지를 전부 뽑겠다는 말과 같으므로 전부 스택에 넣은 후 출력하면 된다.
            for (int i = 0; i < n; i++) st.add(arr[index + i]);//index부터 n개를 차례대로 스택에 넣고
            addStack(); //결과에 넣여준다.
            for (int i = 0; i < n; i++) st.pop(); //이후 전부 pop을 시켜 다음 과정을 진행한다.
        } else {
            //저 두가지 예외 사항을 빼면 점화식대로 진행하면 된다.

            //index를 포함하는 경우
            st.add(arr[index]);
            doCombination(n - 1, r - 1, index + 1); //index를 스택에 넣은상태로 index를 1옮겨 그대로 진행.

            //index를 포함하지 않는 경우
            st.pop(); //index를 제거해주고
            doCombination(n - 1, r, index + 1); //index를 제외한 상태에서 n-1Cr 진행.
        }
        return result;
    }

//    public static void main(String[] args) {
//        String[] arr = {"rho", "doo", "hyun"};
//        Integer[] arrant = {1, 2, 3};
//        Combination combination = new Combination(arr);
//        ArrayList<ArrayList<String>> arrayLists = combination.doCombination(arr.length, 2, 0);
//        for (int i = 0; i < arrayLists.size(); i++) {
//            for (int j = 0; j < arrayLists.get(i).size(); j++) {
//                System.out.print(arrayLists.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//
//    }
}

class Baduser {
    public boolean compareString(String A, String B) {
        char[] banID = B.toCharArray();
        if (A.length() == banID.length) {
            char[] userID = A.toCharArray();
            String stars = "";
            for (int k = 0; k < banID.length; k++) {
                stars += "*";
            }
            // bannid가 ******이면 글자수가 맞으니까 통과
            if (stars.equals(B)) return true;
            for (int k = 0; k < banID.length; k++) {
                if (banID[k] == '*') continue;
                // 글자 수가 안맞으면
                if (banID[k] != userID[k]) return false;
            }
            // 문자열이 조건이 맞으므로 List에 추가
            return true;
        }
        return false;
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;


        Combination combination = new Combination(user_id);
        ArrayList<ArrayList<String>> arrayLists = combination.doCombination(user_id.length, banned_id.length, 0);

        for (int i = 0; i < arrayLists.size(); i++) {
            int count = 0;
            for (int j = 0; j < banned_id.length; j++) {
                String A = arrayLists.get(i).get(j);
                if (compareString(A, banned_id[j])) count++;
            }
            if (count == banned_id.length) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Baduser solution = new Baduser();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution.solution(user_id, banned_id));
    }
}

