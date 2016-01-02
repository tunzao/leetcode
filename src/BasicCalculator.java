import java.util.Stack;

/**
 * Created by likuan on 12/28/15.
 */
public class BasicCalculator {

    /**
     * <a href="https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Character> opStack = new Stack<Character>();
        Stack<Integer> numStack = new Stack<Integer>();

        int num = 0;
        boolean foundNum = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '-':
                case '+':
                case '(':
                case ')':
                    if (foundNum) {
                        foundNum = false;
                        numStack.push(num);
                        num = 0;
                    }
                    if (!opStack.empty()) {
                        boolean drop = false;
                        while (!opStack.isEmpty()) {
                            char peek = opStack.peek();
                            int p = compareOperator(peek, c);
                            if (p > 0) {
                                // 如果栈顶的运算符优先级比当前运算符优先级高就计算前面的
                                int b = numStack.pop();
                                int a = numStack.pop();
                                int n = cal(peek, a, b);
                                numStack.push(n);
                                opStack.pop();
                            } else if (p < 0) {
                                break;
                            } else {
                                drop = true;
                                opStack.pop();
                                break;
                            }
                        }
                        if (!drop) {
                            opStack.push(c);
                        }
                    } else {
                        opStack.push(c);
                    }
                    break;
                case ' ':
                    if (foundNum) {
                        foundNum = false;
                        numStack.push(num);
                        num = 0;
                    }
                    break;
                default:
                    foundNum = true;
                    num = (c - '0') + num * 10;
            }
        }
        if (foundNum) {
            numStack.push(num);
        }
        while (!opStack.empty()) {
            char op = opStack.pop();
            int b = numStack.pop();
            int a = numStack.pop();
            int n = cal(op, a, b);
            numStack.push(n);
        }
        return numStack.pop();
    }

    private int cal(char op, int a, int b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        }
        return 0;
    }

    /**
     * 比较两个运算符的优先级
     *
     * @param a
     * @param b
     * @return
     */
    private int compareOperator(char a, char b) {
        return priority[getIndex(a)][getIndex(b)];
    }

    private int getIndex(char a) {
        switch (a) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '(':
                return 2;
            case ')':
                return 3;
        }
        return -1;
    }

    // 运算符优先级表
    private int[][] priority = {{1, 1, -1, 1}, {1, 1, -1, 1}, {-1, -1, -1, 0}, {1, 1, 0, 1}};


    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        System.out.println(b.calculate("1 + 1"));
        System.out.println(b.calculate(" 2-1 + 2 "));
        System.out.println(b.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
