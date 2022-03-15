/**
 * Created by likuan on 12/22/15.
 * Bulls and Cows
 * @see <a href="https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] m = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            // a == b 那就是bull
            if (a == b) {
                bulls++;
            } else {
                int indexA = a - '0';
                int ca = m[indexA];
                if (ca < 0) {
                    // a 在 guess 里出现过, 所以a是cow
                    cows++;
                }
                ca += 1;
                m[indexA] = ca;

                int indexB = b - '0';
                Integer cb = m[indexB];
                if (cb > 0) {
                    // b 在 secret 里出现过, 所以b是cow
                    cows++;
                }
                cb -= 1;
                m[indexB] = cb;
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
