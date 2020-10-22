import java.util.*;

public class Hash_1 {
    public String solution(String[] participant, String[] completion) {
        // participant 부분을 정렬하고
        Arrays.sort(participant);
        // completion 부분을 정렬한다.
        Arrays.sort(completion);
        // --> 문자열순으로 즉, 문자열 배열을 sort 함수로 정렬하면
        // 알파벳, 모음순으로 정렬이된다.
        // index를 빼주는 방법
        int i;
        // 완주자 수 만큼 비교한다.
        for (i = 0; i < completion.length; i++) {
            // 정렬된 과정에서 완주자는 참가자 의 한 부분이므로
            // 정렬을 하면 참가자 한명씩 완주자 리스트를 비교해본다.
            // 그럼 완주자리스트에 없는 참가자를 거를 수 있다.
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }
}