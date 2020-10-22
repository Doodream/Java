import java.util.*;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hashmap = new HashMap<>();
        // hashmap에 전화번호 key로 다 넣었다.
        for (int i = 0; i < phone_book.length; i++) {
            hashmap.put(phone_book[i], hashmap.getOrDefault(phone_book[i], 0));
        }

        for (String phoneNumber : hashmap.keySet()) {
            HashMap<String, Integer> copyPhone_book = new HashMap<>();
            copyPhone_book = (HashMap<String, Integer>) hashmap.clone();
            copyPhone_book.remove(phoneNumber);
            for (String number: copyPhone_book.keySet()) {
                if(number.contains(phoneNumber)){
                    answer = false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneNumberList phoneNumberList = new PhoneNumberList();
        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        System.out.println(phoneNumberList.solution(phone_book3));
    }
}
