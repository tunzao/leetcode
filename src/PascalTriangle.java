import java.util.ArrayList;
import java.util.List;

/**
 * Created by likuan on 12/23/15.
 * @see <a href="https://leetcode.com/problems/pascals-triangle-ii/">Pascal Triangle II</a>
 */
public class PascalTriangle {

    public List<Integer> getRow(int rowIndex) {
        int current = 0;
        int[] a = new int[rowIndex + 1];
        int[] b = new int[rowIndex + 1];
        a[0] = 1;
        b[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            int[] n = current == 0 ? b : a;
            int[] o = current == 0 ? a : b;

            for (int j = 1; j < i; j++) {
                n[j] = o[j] + o[j - 1];
            }
            n[i] = 1;
            current = current == 0 ? 1 : 0;
        }

        List<Integer> row = new ArrayList<Integer>(rowIndex + 1);
        if (current == 0) {
            for (int i : a) {
                row.add(i);
            }
        } else {
            for (int i : b) {
                row.add(i);
            }
        }
        return row;
    }


    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.getRow(1));
        System.out.println(p.getRow(2));
        System.out.println(p.getRow(3));
        System.out.println(p.getRow(4));
        System.out.println(p.getRow(5));
    }
}
