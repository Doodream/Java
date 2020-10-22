import java.util.*;

public class PhoneNumberList {
    public boolean solution(String[] phoneBook) {
        // 예외 없게 처음부터 끝까지 다 넣는다.
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook.length; j++) {
                // 같다면 넘어간다.
                if(i == j){continue;}
                // 같지 않다면 접두어 인지 확인
                if(phoneBook[i].startsWith(phoneBook[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PhoneNumberList phoneNumberList = new PhoneNumberList();
        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        System.out.println(phoneNumberList.solution(phone_book3));
    }
}
