import java.util.HashMap;
import java.util.Map;

/**
 * Created by likuan on 12/22/15.
 * Bulls and Cows
 * @see <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            // a == b 那就是bull
            if (a == b) {
                bulls++;
            } else {
                Integer ca = m.get(a);
                if (ca == null) {
                    ca = 0;
                }
                if (ca < 0) {
                    // a 在 guess 里出现过, 所以a是cow
                    cows++;
                }
                ca += 1;
                m.put(a, ca);

                Integer cb = m.get(b);
                if (cb == null) {
                    cb = 0;
                }
                if (cb > 0) {
                    // b 在 secret 里出现过, 所以b是cow
                    cows++;
                }
                cb -= 1;
                m.put(b, cb);
            }

        }
        return String.format("%dA%dB", bulls, cows);
    }

    public static void main(String[] args) {
        BullsAndCows b = new BullsAndCows();
        System.out.println(b.getHint("1807", "7810"));
        System.out.println(b.getHint("1123", "0111"));
        System.out.println(b.getHint("1122", "2211"));
    }
}
