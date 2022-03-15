
/**
 * @author likuan
 */
public class ReadWithRead4 extends Reader4 {

    /**
     * https://leetcode-cn.com/problems/read-n-characters-given-read4/
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        char[] four = new char[4];
        int read = 0;
        while (read < n) {
            int buffRead = read4(four);
            if (read + buffRead > n) {
                append(buf, read, four, n - read);
                return n;
            } else if (buffRead > 0){
                append(buf, read, four, buffRead);
            }
            read += buffRead;
            if (buffRead < 4) {
                return read;
            }
        }
        return n;
    }

    private void append(char[] root, int offset, char[] append, int len) {
        if (len >= 0) System.arraycopy(append, 0, root, offset, len);

    }
}

class Reader4 {
    public int read4(char[] buf) {
        return 0;
    }
}
