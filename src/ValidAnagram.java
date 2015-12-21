import java.util.HashMap;
import java.util.Map;

/**
 * Created by likuan on 12/21/15.
 * Valid Anagram
 *
 * @see <a href="https://leetcode.com/problems/valid-anagram/"></a>
 * 这里是关于<a href="https://en.wikipedia.org/wiki/Anagram">Anagram</a>的解释
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> letterMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character a = s.charAt(i);
            Character b = t.charAt(i);
            if (!a.equals(b)) {
                Integer ca = letterMap.get(a);
                if (ca == null) {
                    ca = 0;
                }
                ca += 1;
                if (ca == 0) {
                    letterMap.remove(a);
                } else {
                    letterMap.put(a, ca);
                }

                Integer cb = letterMap.get(b);
                if (cb == null) {
                    cb = 0;
                }
                cb = cb - 1;
                if (cb == 0) {
                    letterMap.remove(b);
                } else {
                    letterMap.put(b, cb);
                }
            }
        }
        return letterMap.size() == 0;
    }

    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("abc", "cba"));
        System.out.println(v.isAnagram("anagram", "nagaram"));
        System.out.println(v.isAnagram("rat", "car"));
    }

}
