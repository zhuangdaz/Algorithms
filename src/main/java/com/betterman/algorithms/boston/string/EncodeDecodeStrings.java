package com.betterman.algorithms.boston.string;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class EncodeDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        return strs.stream().map(str ->
                new StringBuilder()
                        .append(str.length())
                        .append("/")
                        .append(str)
                        .toString()
        ).collect(Collectors.joining());
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int end = s.indexOf("/", start);
            int len = Integer.valueOf(s.substring(start, end));
            res.add(s.substring(end + 1, end + 1 + len));
            start = end + 1 + len;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = Lists.newArrayList("/d", "5/ds");
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        String encoded = encodeDecodeStrings.encode(strs);
        System.out.println(encoded);
        List<String> decoded = encodeDecodeStrings.decode(encoded);
        System.out.println(decoded);
        Assert.assertArrayEquals(strs.stream().toArray(), decoded.stream().toArray());
    }
}
