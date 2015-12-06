package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/6/15.
 */

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * <p>
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * <p>
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * <p>
 * Note:
 * The read function will only be called once for each test case.
 * <p>
 * Hide Tags String
 * Hide Similar Problems (H) Read N Characters Given Read4 II - Call multiple times
 */
public class ReadNCharacters {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return The number of characters read
         */

        //note:
        // 1. eof when read4 return count less than 4;
        // 2. already read n characters
        public int read(char[] buf, int n) {
            char[] buf4 = new char[4];
            int readBytes = 0;
            while (readBytes < n) {
                int count = read4(buf4);
                for (int j = 0; j < count; j++) {
                    buf[readBytes++] = buf4[j];
                    if (readBytes >= n) {
                        return n;
                    }
                }

                if (count < 4) { //eof
                    return readBytes;
                }
            }
            return readBytes;
        }
    }

    //Dummy class to avoid compile error
    private class Reader4 {
        public int read4(char[] buf) {
            return 0;
        }
    }


}
