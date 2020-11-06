import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexExample {
    public static void main(String[] args)  {

        String pattern = "^[0-9]*$"; //숫자만
        String val = "123456789"; //대상문자열
        boolean p = Pattern.matches(pattern, val);
        // 위식은 아래식과 정확히 같다.//
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher k = pattern1.matcher(val);
        boolean a = k.matches();
        // 위식은 아래식과 정확히 같다.//
        boolean s = Pattern.compile(pattern).matcher(val).matches();

        boolean regex = Pattern.matches(pattern, val);
        System.out.println(regex);
    }
}
