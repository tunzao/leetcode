
/**
 * @author likuan
 */
public class MultipleReadWithRead4 extends Reader4 {

    private int position = 0;
    private boolean eof = false;
    private final char[] cache = new char[4];
    private int cacheLen = 0;
    private int cachePos = 0;

    /**
     * https://leetcode-cn.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0 || eof) {
            return 0;
        }
        char[] buff4 = new char[4];
        int read = 0;
        int buffRead = 0;

        if (cacheLen > 0) {
            read = Math.min(n, cacheLen);
            copy(cache, cachePos, buf, 0, read);
            cacheLen -= n;
            if (cacheLen > 0) {
                cachePos += read;
                return read;
            }
        }

        do {
            buffRead = read4(buff4);
            if (read + buffRead > n) {
                cacheLen = read + buffRead - n;
                cachePos = 0;
                copy(buff4, n - read, cache, 0, cacheLen);
                buffRead = n - read;
            }
            copy(buff4, 0, buf, read, buffRead);
            read += buffRead;

        } while (read < n && buffRead > 0);
        position += read;
        eof = read < n;
        return read;
    }

    private void copy(char[] append, int srcPos, char[] root, int descPos, int len) {
        if (len > 0) System.arraycopy(append, srcPos, root, descPos, len);
    }
}

