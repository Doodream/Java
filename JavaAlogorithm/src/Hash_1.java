import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hash_1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // participant에 있는 String 변수를 하나씩 completion에 있는지 비교해본다.
        for (int i = 0; i < participant.length; i++) {
            boolean isInclude = false;
            // completion에 participant에서 나온 name이 있는 지 확인
            for (int j = 0; j < completion.length; j++) {
                // 있다면 isInclude true
                if (participant[i].equals(completion[j])) {
                    completion[j] = null;
                    isInclude = true;
                    break;
                }
            }
            // 만약 없었다면 없는 이름 반환.
            if (!isInclude) {
                answer = participant[i];
            }
        }
        return answer;
    }
}
