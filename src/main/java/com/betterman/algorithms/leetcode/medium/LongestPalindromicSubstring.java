package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 10/15/15.
 */
public class LongestPalindromicSubstring {
    public static class Solution {
        public String longestPalindrome(String s) {
            //preprocess string
            //use mirror alg to caculate palindromic length

            s = preprocess(s);

            String longestStr = "";
            int max = 0;
            int range = 0, center = 0;
            int[] lengths = new int[s.length()];


            for (int i = 1; i < s.length() - 1; i++) {
                int mirror = center * 2 - i;
                if (range > i) {
                    if (i + lengths[mirror] < range) {
                        lengths[i] = lengths[mirror];
                        continue;
                    } else {
                        lengths[i] = range - i;
                    }
                }


                while (i - lengths[i] - 1 >= 0 && i + lengths[i] + 1 < s.length()) {
                    if (s.charAt(i - lengths[i] - 1) == s.charAt(i + lengths[i] + 1)) {
                        lengths[i]++;
                    } else {
                        break;
                    }
                }

                if (i + lengths[i] > range) {
                    center = i;
                    range = i + lengths[i];
                }

                if (lengths[i] > max) {
                    longestStr = s.substring(i - lengths[i], i + lengths[i] + 1);
                    max = lengths[i];
                }
            }

            return clean(longestStr);

        }

        private String preprocess(String s) {
            String ret = "#";
            for (int i = 0; i < s.length(); i++) {
                ret += s.charAt(i) + "#";
            }
            return ret;
        }

        private String clean(String s) {
            String ret = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '#') {
                    ret += s.charAt(i);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(str));
    }
}
