/**
 * Created by likuan on 1/3/16.
 */
public class ReverseBits {

    /**
     * <a href="https://leetcode.com/problems/reverse-bits/">Reverse Bits</a>
     * @param n
     * @return
     */
    public int reverseBits(int n) {

        int m = 0;
        for (int i = 0; i < 32; i++) {
            m <<= 1;
            m |= ((n>>i) & 1);
        }
        return m ;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(43261596));
        System.out.println(r.reverseBits(1));
    }
}
