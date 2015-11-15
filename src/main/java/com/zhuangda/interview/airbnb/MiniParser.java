package com.zhuangda.interview.airbnb;

import java.util.ArrayList;

/**
 * Created by zhuangda on 11/7/15.
 */
public class MiniParser {
    /**
     * Implement a mini parser, the input string format is a string:”324″ or”[123,456,[788,799,833],[[]],10,[]]”
     * output:324 or [123,456,[788,799,833],[[]],10,[]]
     */

    static class IntegerOrArray {
        public int mInt;
        public ArrayList<IntegerOrArray> mArray;

        @Override
        public String toString() {
            if (mArray == null) {
                return Integer.toString(mInt);
            } else {
                return mArray.toString();
            }
        }
    }

    // parse each small section of data, recursively transform it into IntegerOrArray object
    public static IntegerOrArray parse(String line) {
        if (line == null) {
            return null;
        }

        line = line.trim();

        if (line.isEmpty()) {
            return null;
        }

        IntegerOrArray ret = new IntegerOrArray();

        // assume integer string is in good format
        if (line.charAt(0) != '[') {
            ret.mInt = Integer.parseInt(line);
            return ret;
        }

        ret.mArray = new ArrayList<IntegerOrArray>();
        int l = 1;
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ',') {
                IntegerOrArray element = parse(line.substring(l, i));
                if (element != null) {
                    ret.mArray.add(element);
                }
                l = i + 1;
            } else if (c == '[') {
                int leftBracket = 1;
                for (int j = i + 1; j < line.length(); j++) {
                    if (line.charAt(j) == '[') {
                        leftBracket++;
                        continue;
                    }

                    if (line.charAt(j) == ']') {
                        leftBracket--;

                        if (leftBracket == 0) {
                            IntegerOrArray element = parse(line.substring(l, j + 1));
                            if (element != null) {
                                ret.mArray.add(element);
                            }
                            l = j + 1;
                            i = j;
                            break;
                        }
                    }
                }
            } else if (c == ']' && l < i) {
                IntegerOrArray element = parse(line.substring(l, i));
                if (element != null) {
                    ret.mArray.add(element);
                }
                l = i + 1;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        String str =
//                "[[[]]]"
//                "[[]]"
//                "[123,456,[788,799,833],[[]],10,[]]"
                "324"
                ;

        System.out.println(parse(str));

    }

}
