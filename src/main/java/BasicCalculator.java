import java.util.Stack;

/**
 * @author likuan
 */
public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = 0;
        char preOp = '=';
        int num = 0;
        boolean preNum = false;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    if (compareOp(preOp, c) >=0) {
                       stack.push(compute(stack, num, preOp)) ;
                    } else {
                        stack.push(num);
                    }
                    num = 0;
                    stack.push((int)c);
                    preOp = c;
                    break;
                case '(':
                    stack.push((int)c);
                    break;
                case ')':
                    // todo
                    while (true) {
                        int t = stack.pop();
                        if (t == '(') {
                            stack.push(num);
                            num = 0;
                            break;
                        }
                        switch (t) {
                            case '+':
                            case '-':
                            case '*':
                            case '/':
                                num = compute(stack.pop(), (char)t, num) ;
                                break;
                            default:
                                num = t;
                        }
                    }
                    break;
                default:
                    num = num*10 + (c-'0');
                    preNum = true;
            }
        }

        while (!stack.isEmpty()) {
            int t = stack.pop();
            switch (t) {
                case '+':
                case '-':
                case '*':
                case '/':
                    num = compute(stack.pop(), (char)t, num) ;
                    if (stack.isEmpty()) {
                        return num;
                    }
                    break;
                default:
                    num = t;
            }
        }
        return num;

    }

    private int compareOp(char preOp, char c) {
        if (preOp == '=') {
            return -1;
        }
        switch (preOp) {
            case '+':
            case '-':
                switch (c) {
                    case '+':
                    case '-':
                        return 1;
                    default:
                        return -1;
                }
            case '*':
            case '/':
                return 1;
            default:
                return -1;
        }
    }

    private Integer compute(Stack<Integer> stack, int num, char op) {
        stack.pop();
        return compute(stack.pop(), op, num);
    }

    private int compute(int a, char op, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
//        System.out.println(bc.calculate("1+1"));
//        System.out.println(bc.calculate("1+1*2"));
//        System.out.println(bc.calculate("1+1/2*2"));
//        System.out.println(bc.calculate("6-4/2"));
//        System.out.println(bc.calculate("0"));
        System.out.println(bc.calculate("2*(5+5*2)/3+(6/2+8)"));
    }
}
