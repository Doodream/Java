import java.util.HashMap;

public class WordDictionary {

    HashMap <String, String> dic = new HashMap<>();
    public void addWord (String engWord, String korWord){
        dic.put(engWord.toLowerCase(), korWord);
    }
    public String find (String engWord){
        return dic.get(engWord.toLowerCase());
    }
}
