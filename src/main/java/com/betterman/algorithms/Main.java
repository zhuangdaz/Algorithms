package com.betterman.algorithms;

/**
 * Created by zhuangda on 4/29/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(1/64*Math.pow(1/120000d, 30000d));
        System.out.println(Math.pow(64*Math.pow(120000d, 30000d), -1));
        System.out.println(Math.pow(Math.pow(64*Math.pow(120000d, 30000d), -1), -1/30003));
    }
}
