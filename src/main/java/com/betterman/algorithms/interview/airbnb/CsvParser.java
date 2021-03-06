package com.betterman.algorithms.interview.airbnb;

/**
 * Created by zhuangda on 11/1/15.
 */
public class CsvParser {
    /**
     * parse csv
     * 1) don't treat, inside quote as a separator
     * 2) Each field inside "xxx" may have escape
     * , where " acts as an escape. so "" will show as "
     *
     * @param line
     * @return
     */

    /*
        John,Smith,john.smith@gmail.com,Los Angeles,1
        Jane,Roberts,janer@msn.com,"San Francisco, CA",0
        "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
        """Alexandra Alex"""
        John|Smith|john.smith@gmail.com|Los Angeles|1
        Jane|Roberts|janer@msn.com|San Francisco, CA|0
        Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
        "Alexandra Alex"
    */
    private static String parseLine(String line) {
        // number of properties is fixed?
        // 1. use comma as delimiter, prob: if comma is also existed in the string
        // 2. ignore comma in the string, use (quotation mark), prob: multiple quotation marks
        // 3. need to confirm there won't be any error format

        if (line == null) {
            return null;
        }

        line = line.trim();
        StringBuffer sb = new StringBuffer();
        boolean isInQuote = false;
        int i = 0;
        while (i < line.length()) {
            char c = line.charAt(i++);
            if (c == ',' && !isInQuote) {
                sb.append("|");
                continue;
            }

            if (c == '\"') {
                if (!isInQuote) {
                    isInQuote = true;
                } else {
                    if (i < line.length() && line.charAt(i) != ',') {
                        //escape
                        sb.append(line.charAt(i++));
                    } else {
                        isInQuote = false;
                    }
                }
                continue;
            }

            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] lines = new String[]{
            "John,Smith,john.smith@gmail.com,Los Angeles,1",
            "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0",
            "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1",
            "\"\"\"Alexandra Alex\"\"\""
        };
//        String csv =
////                "John,Smith,john.smith@gmail.com,Los Angeles,1"
//                "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"
////                "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"
////                "\"\"\"Alexandra Alex\"\"\""
////                "\"\"Alexandra Alex\"\""  //bad formatting
//                ;
        for (String line : lines) {
            System.out.println(parseLine(line));
        }

    }

    private static String parseLine2(String line) {
        char[] arr = line.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean inQuote = false;
        for (int i = 0; i < arr.length; i++) {
            // special case: , & "
            if (arr[i] == ',' && !inQuote) {
                sb.append("|");
            } else if (arr[i] == '"') {
                if (!inQuote) {
                    inQuote = true;
                } else {
                    if (i + 1 == arr.length || arr[i + 1] != '"') {
                        inQuote = false;
                    } else {
                        sb.append("\"");
                        i++;
                    }
                }
            } else {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

}
