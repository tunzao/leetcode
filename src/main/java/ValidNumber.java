/**
 * Created by likuan on 15/7/7.
 */
public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber s = new ValidNumber();
        System.out.println(s.isNumber("0"));
        System.out.println(s.isNumber(" 0.1 "));
        System.out.println(s.isNumber("abc"));
        System.out.println(s.isNumber("1 a"));
        System.out.println(s.isNumber("2e10"));
        System.out.println(s.isNumber("2.10e10"));
        System.out.println(s.isNumber("2. "));
        System.out.println(s.isNumber(""));
        System.out.println(s.isNumber("+.8"));
        System.out.println(s.isNumber("+."));
        System.out.println(s.isNumber("1.e1"));

    }
    /**
     *
     * Valid Number
     * @see <a>https://leetcode.com/problems/valid-number/</a>
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        int state = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (state) {
                // 开始
                case 0:
                    if (Character.isSpaceChar(c)) {
                        continue;
                    } else if (Character.isDigit(c)) {
                        state = 1;
                    } else if (c == '+' || c== '-') {
                        state = 9;
                    } else if (c == '.') {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                // 出现数字
                case 1:
                    if (Character.isDigit(c)) {
                        continue;
                    } else if (c == '.') {
                        state = 2;
                    } else if ( c == 'e') {
                        state = 4;
                    } else if (Character.isSpaceChar(c)){
                        state = 8;
                    } else {
                        return false;
                    }
                    break;
                // 出现数字后出现小数点
                case 2:
                    if (Character.isDigit(c)) {
                        state = 3;
                    } else if (Character.isSpaceChar(c)) {
                        state = 8;
                    } else if (c == 'e' || c == 'E') {
                        state = 4;
                    } else {
                        return false;
                    }
                    break;
                // 出现小数点后又出现数字
                case 3:
                    if (Character.isDigit(c)) {
                        continue;
                    } else if ( c == 'e' || c == 'E') {
                        state = 4;
                    } else if (Character.isSpaceChar(c)) {
                        state = 8;
                    } else {
                        return false;
                    }
                    break;
                // 出现e
                case 4:
                    if (Character.isDigit(c)) {
                        state = 5;
                    } else if (c == '+' || c== '-') {
                        state = 10;
                    } else {
                        return false;
                    }
                    break;
                // e > 数字
                case 5:
                    if (Character.isDigit(c)) {
                        continue;
                    } else if (Character.isSpaceChar(c)) {
                        state = 8;
                    } else {
                        return false;
                    }
                    break;
                // 出现小数点
                case 6:
                    if (Character.isDigit(c)) {
                        state = 3;
                    } else  {
                        return false;
                    }
                    break;
                // 数字末尾
                case 8:
                    if (Character.isSpaceChar(c)) {
                        continue;
                    } else {
                        return false;
                    }
                    // 出现符号
                case 9:
                    if (Character.isDigit((c))) {
                        state = 1;
                    } else if(c == '.') {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                // 出现e后出现符号
                case 10:
                    if (Character.isDigit(c)) {
                        state = 5;
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return state == 8 || state == 2 || state == 1 || state == 3 || state == 5;
    }
}
