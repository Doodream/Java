package Solution;

import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    private HashSet<HashSet<Integer>> resultSet;
    private String[] bannedId;
    private String[] userId;
    private boolean[] checked;

    public int solution(String[] user_id, String[]banned_id) {
        bannedId = banned_id;
        userId = user_id;
        resultSet = new HashSet<>();
        checked = new boolean[user_id.length];

        for (int i = 0; i < bannedId.length; i++) {
            bannedId[i] = banned_id[i].replace("*", ".");
        }
        dfs(0, new HashSet<>());

        return resultSet.size();
    }

    public void dfs (int index, HashSet<Integer> set){
        if(index == bannedId.length){
            resultSet.add(set);
            return;
        }

        for (int i = 0; i < userId.length; i++) {
            if(Pattern.matches(userId[i], bannedId[index]) && !checked[i])
                checked[i] = true;
                set.add(i);
                dfs(index + 1, new HashSet<>());
                checked[i] = false;
                set.remove(i);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution.solution(user_id, banned_id));
    }
}