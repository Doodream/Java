package Programmers.Baduser;

import java.util.HashSet;
import java.util.regex.Pattern;

class Baduser {
    private String[] userId;
    private String[] bannedRegex;
    private boolean[] checked;
    private HashSet<HashSet<Integer>> resultSet;

    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        checked = new boolean[user_id.length];
        resultSet = new HashSet<>();
        bannedRegex = new String[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            bannedRegex[i] = banned_id[i].replace("*", ".");
        }
        dfs(0, new HashSet<>());
        return resultSet.size();
    }

    private void dfs(int index, HashSet<Integer> set) {
        // 가장깊이 들어가서 더 탐색할 bannedRegex가 없다면 HashSet의 결과를 넣는다.
        if (index == bannedRegex.length) {
            resultSet.add(set);
            return;
        }
        // 유저의 길이 만큼 탐색한다.
        for (int i = 0; i < userId.length; i++) {
            // bannedId의 조건에 userId가 만족할 경우 그리고 유저아이디가 한번도 탐색하지 않았을 경우
            if (Pattern.matches(bannedRegex[index], userId[i]) && !checked[i]) {
                // 해당 유저는 탐색을 해본 경우이므로 체크
                checked[i] = true;
                // set에 탐색을 한 경우를 추가한다.
                set.add(i);
                // banned_id를 한칸 더 들어가서 탐색한다.
                dfs(index + 1, new HashSet<>(set));

                // 해당 유저보다 깊은 곳은 탐색을 마쳤으므로
                // 다시 돌아가서 다음 유저를 탐색하기 위해 checked 배열 과 Hashset을 초기화한다.
                checked[i] = false;
                set.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Baduser solution = new Baduser();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution.solution(user_id, banned_id));
    }
}
