package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/13/15.
 */
public class ReadNCharsII {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */
        private int buffPtr = 0;
        private int buffCnt = 0;
        private char[] buff = new char[4];
        public int read(char[] buf, int n) {
            //try to read n chars.
            //but be cautious: 1.eof 2.exceed n then need to store in buffer for later usage.
            int cnt = 0;
            while(cnt < n) {
                if (buffPtr == 0) {
                    buffCnt = read4(buff);
                }

                if (buffCnt == 0) break;

                while (cnt < n && buffPtr < buffCnt) {
                    buf[cnt++] = buff[buffPtr++];
                }

                if (buffPtr >= buffCnt) buffPtr = 0;
            }
            return cnt;
        }
    }

    private class Reader4 {
        int read4(char[] buf) {
            return 0;
        }
    }
}
