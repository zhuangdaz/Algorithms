package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/6/15.
 */
public class IntToWords {
    public class Solution {
        // 1000000 => One million
        // 14 => Fourteen
        // 90 => Ninety
        // 0 => Zero
        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            String[] partitions = new String[]{
                "",
                " Thousand",
                " Million",
                " Billion"
            };

            String ret = "";
            int i = 0;
            while (num > 0) {
                int sec = num % 1000;
                String secStr = numToWordsRec(sec);

                if (!secStr.isEmpty()) {
                    ret = secStr + partitions[i] + " " + ret;
                }


                i++;
                num /= 1000;
            }
            return ret.trim();
        }

        private String numToWordsRec(int num) {
            if (num == 0) return "";
            StringBuffer sb = new StringBuffer();
            String[] table = new String[]{
                "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
            };

            String[] tens = new String[]{
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
            };

            while (num > 0) {
                if (num >= 100) {
                    int count = num / 100;
                    sb.append(table[count] + " " + "Hundred");
                    num %= 100;
                } else if (num < 20) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }

                    sb.append(table[num]);
                    num = 0;
                } else {
                    int count = num / 10;
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(tens[count - 2]);
                    num %= 10;
                }
            }
            return sb.toString();
        }
    }
}
