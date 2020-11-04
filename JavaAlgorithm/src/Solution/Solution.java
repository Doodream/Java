package Solution;

import java.util.*;

class User {
    String name;
    int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {
    public String[] solution(String user, String[][] friends, String[] visitors) {
        HashMap<String, String> usersFriends = new HashMap<>();
        HashMap<String, Integer> scores = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            String friendA = friends[i][0];
            String friendB = friends[i][1];
            scores.put(friendA, 0);
            scores.put(friendB, 0);
            usersFriends.put(friendA, usersFriends.getOrDefault(friendA, "") + friendB + ":");
            usersFriends.put(friendB, usersFriends.getOrDefault(friendB, "") + friendA + ":");
        }

        String[] userFriends = usersFriends.get(user).split(":");
        // 모든 유저
        ArrayList<String> allUsers = new ArrayList<>(usersFriends.keySet());
        // 모든 유저들을 user빼고 다 돌린다. 함께 아는 친구들은 점수 추가하기
        for (int i = 0; i < allUsers.size(); i++) {
            String user1 = allUsers.get(i);
            if (user1.equals(user)) continue;
            String[] user1Friends = usersFriends.get(user1).split(":");
            for (int j = 0; j < user1Friends.length; j++) {
                // 한유저의 친구들 중 한명이 user의 친구들중 한명이라면? 그유저의 점수를 10점 올림
                if(usersFriends.get(user).contains(user1Friends[j]))
                    scores.put(user1, scores.getOrDefault(user1, 0) + 10);
            }
        }
        // 방문자 점수 올리기
        for (int i = 0; i < visitors.length; i++) {
            if(usersFriends.get(user).contains(visitors[i])) continue;
            scores.put(visitors[i], scores.getOrDefault(visitors[i], 0) + 1);
        }

        // 점수판의 모든 키판
        ArrayList<String> scoresKeys = new ArrayList<>(scores.keySet());
        // 점수판에 들어 있는 모든 내용을 answer에 저장
        ArrayList<User> answer = new ArrayList<>();
        for (int i = 0; i < scoresKeys.size(); i++) {
            answer.add(new User(scoresKeys.get(i), scores.get(scoresKeys.get(i))));
        }
        // answer를 정렬
        Collections.sort(answer, (o1, o2) -> {
            // 점수가 같다면 이름순
            if(o2.score == o1.score) return o1.name.compareTo(o2.name);
            // 점수가 같지 않다면 점수가 높은 순
            return o2.score - o1.score;
        });
        // 결과를 저장
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            if(answer.get(i).score == 0) continue;
            if(result.size() >= 5) break;
            result.add(answer.get(i).name);
        }
        String[] result2 = new String[result.size()];
        for (int i = 0; i < result2.length; i++) {
            result2[i] = result.get(i);
        }
        return result2;

    }

    public static void main(String[] args) {
        String[][] friends = {
                {"donut", "andole"},
                {"donut", "jun"},
                {"donut", "mrko"},
                {"shakevan", "andole"},
                {"shakevan", "jun"},
                {"shakevan", "mrko"}
        };
        String[] visitors = {"bedi", "bedi", "donut", "bedi", "shakevan"};
        String user = "mrko";
        Solution solution = new Solution();
        String[] answer = solution.solution(user, friends, visitors);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}