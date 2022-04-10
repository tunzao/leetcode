import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>(matrix.length * matrix[0].length);
        int row = matrix.length;
        int col = matrix[0].length;
        int direct = 0, i = 0, j = 0;
        while (true) {
            boolean end = true;
            switch (direct) {
                case 0:
                    for (; j < col && matrix[i][j] != Integer.MIN_VALUE; j++) {
                        addNum(ret, i, j, matrix);
                        end = false;
                    }
                    j--;
                    i++;
                    direct = 1;
                    break;
                case 1:
                    for (; i < row && matrix[i][j] != Integer.MIN_VALUE; i++) {
                        addNum(ret, i, j, matrix);
                        end = false;
                    }
                    j--;
                    i--;
                    direct = 2;
                    break;
                case 2:
                    for (; j >= 0 && matrix[i][j] != Integer.MIN_VALUE; j--) {
                        addNum(ret, i, j, matrix);
                        end = false;
                    }
                    j++;
                    i--;
                    direct = 3;
                    break;
                case 3:
                    for (; i >= 0 && matrix[i][j] != Integer.MIN_VALUE; i--) {
                        addNum(ret, i, j, matrix);
                        end = false;
                    }
                    j++;
                    i++;
                    direct = 0;
                    break;
            }
            if (end) {
                break;
            }
        }
        return ret;
    }

    private void addNum(List<Integer> ret, int i, int j, int[][] matrix) {
        ret.add(matrix[i][j]);
        matrix[i][j] = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        System.out.println(matrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
