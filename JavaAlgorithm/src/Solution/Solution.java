package Solution;

import java.util.*;

class Solution{
    public int solution (String user,String[][] friends, String[] visitors){
        int result = 0;
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        HashMap<String, HashSet<String>> friendslist = new HashMap<>();
        HashSet<String> userFriends = new HashSet();

        for (int i = 0; i < friends.length; i++) {

            String A = friends[i][0];
            String B = friends[i][1];
            if(A.equals("mrko")) userFriends.add(B);
            if(B.equals("mrko")) userFriends.add(A);
            scoreBoard.put(A, 0);
            scoreBoard.put(B, 0);
            getDefault(friendslist, A, B);
            getDefault(friendslist, B, A);


        }
        // 방문자 점수 더함
        for (int i = 0; i < visitors.length; i++) {
            scoreBoard.put(visitors[i], scoreBoard.getOrDefault(visitors[i], 0) + 1);
        }

        ArrayList allusers = new ArrayList(friendslist.keySet());

        for (int i = 0; i < allusers.size(); i++) {
            String C = (String) allusers.get(i);
            HashSet set = friendslist.get(allusers.get(i));
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                String A = (String)iterator.next();
                Iterator iterator1 = userFriends.iterator();
                while(iterator1.hasNext()){
                    String B = (String)iterator1.next();
                    if(A.equals(B)) {
                        scoreBoard.put(C, scoreBoard.getOrDefault(C, 0)+ 10);
                    }
                }
            }
        }
        return result;
    }

    private void getDefault(HashMap<String, HashSet<String>> friendslist, String a, String b) {
        if(!friendslist.containsKey(a)){
            HashSet<String> set = new HashSet();
            set.add(b);
            friendslist.put(a, set);
        }else{
            HashSet<String> set1 = friendslist.get(a);
            set1.add(b);
            friendslist.put(a, set1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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
        solution.solution(user, friends, visitors);
    }
}