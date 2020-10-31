package WinterCodingTest;

public class CodingTest2 {
    public String solution(String encrypted_text, String key, int rotation) {
        // 역 로테이션 하기
        encrypted_text = reversRotation(encrypted_text, rotation);
        // 복호화 하기
        String answer = Decrypted(encrypted_text, key);
        return answer;
    }

    // 로테이션 왼쪽으로 돌리기 인수 : text, 왼쪽으로 돌아갈 횟수
    public String reversRotation(String text, int rotationCount) {
        // textArr은 text를 한글자씩 나눠서 String[]에 담는다.
        String[] textArr = new String[text.length()];
        textArr = text.split("");
        // textTmp는 textArr.clone()
        String[] textTmp = textArr.clone();
        String result = "";

        for (int i = 0; i < textArr.length; i++) {
            //왼쪽으로 로테이션을 돌릴때는 (원래 칸 + (오른쪽으로 돌릴 칸수 + 전체 길이)) % 전체 길이
            textArr[i] = textTmp[(i + (textArr.length + (rotationCount % textArr.length))) % (textArr.length)];
        }


        for (int i = 0; i < textArr.length; i++) {
            result += textArr[i];
        }
        return result;
    }
    // text를 받고 key를 숫자로 변환하여 그만큼 알파벳의 뒤에 있는 만큼 가게하기.
    public String Decrypted(String text, String key) {
        // key값을 한글자씩 char[] 배열에 넣는다.
        char[] keyArr = key.toCharArray();
        String[] textArr = text.split("");
        char[] textToChar = text.toCharArray();
        for (int i = 0; i < keyArr.length; i++) {
            // text의 한문자를 대응되는 영문자의 숫자만큼 왼쪽으로 복호화한다.
            textArr[i] = Decrypt(textToChar[i], keyArr[i]);
        }
        String result = "";
        for (int i = 0; i < textArr.length; i++) {
            result += textArr[i];
        }
        return result;
    }

    // a를 b라는 알파벳이 의미하는 숫자만큼 알파벳에서 a보다 앞에 있는 문자로 바꾼다.
    public String Decrypt(char a, char b) {
        String arr = "abcdefghijklmnopqrstuvwxyz";
        // 알파벳을 순서대로 char[]배열에 넣었다.
        char[] arrToChar = arr.toCharArray();
        // char a - 'a' + 1 = a라는 문자가 가진 숫자
        // (a문자의 순서 + (전체문자 - b문자의 순서)) % 26
        // 전체문자 - b문자순서 만큼 오른쪽으로 밀면 b문자 순서만큼 왼쪽으로 밀게 되는 거랑 같다.
        return Character.toString(arrToChar[(((a - 'a') + 1) + (26 - ((b - 'a') + 1)) - 1) % 26]);
    }

    public static void main(String[] args) {
        CodingTest2 codingTest2 = new CodingTest2();
        String encyptedText = "qyyigoptvfb";
        String key = "abcdefghijk";
        int rotation = 3;
        System.out.println(codingTest2.solution(encyptedText, key, rotation));
    }
}
