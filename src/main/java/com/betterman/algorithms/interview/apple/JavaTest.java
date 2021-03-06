package com.betterman.algorithms.interview.apple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuangda on 3/11/16.
 */
public class JavaTest {
    /**
     * Using {@link AppleExercise.Problem1.SampleCache} as a starting point, answer questions 1-3 by
     * creating 3 new inner classes within {@link AppleExercise.Problem1} below.
     */
    public static class Problem1 {

        public interface Cache {
            public void put(Object key, Object value);

            public Object get(Object key);
        }

        public static class SampleCache implements Cache {

            private Map map;

            public SampleCache() {
                map = new HashMap();
            }

            @SuppressWarnings("unchecked")
            public void put(Object key, Object value) {
                map.put(key, value);
            }

            public Object get(Object key) {
                return map.get(key);
            }
        }

        /**
         * Problem 1.1
         *
         * Re-implement {@link AppleExercise.Problem1.SampleCache} as a
         singleton which implements the Cache interface.
         * Do not use any @SuppressWarnings annotations, and ensure that
         your implementation compiles without warnings
         * under Java 1.6.
         *
         * Name it {@link AppleExercise.Problem1.SingletonCache}
         */

        /**
         * Problem 1.2
         *
         * The HashMap class backing the {@link AppleExercise.Problem1.
        SampleCache} class is not thread-safe.
         * Duplicate and modify your {@link AppleExercise.Problem1.
        SingletonCache} implementation to ensure
         * that both Cache.put and Cache.get methods are safe to be called
         by multi-threads.
         * Do not use any @SuppressWarnings annotations, and ensure that
         your implementation compiles
         * without warnings under Java 1.6.
         *
         * Name it {@link AppleExercise.Problem1.ThreadSafeCache}
         */

        /**
         * Problem 1.3
         *
         * Use Java Generics to implement a non-singleton GenericCache class
         to improve compile-time type checking.
         *
         * Name it {@link AppleExercise.Problem1.GenericCache}
         */
    }

    /**
     * Using any Java 1.6 classes or language features, implement these five methods. Create any
     * helper classes or methods that you think contribute to an elegant and efficient solution.
     *
     * If you feel like there is more than one solution to the problem, implement only the one that
     * you feel is "best", and please explain why you think it is a better choice than the
     * alternatives. List any assumptions that you made for your best solution.
     */
    public static class Problem2 {

        /**
         * Problem 2.1
         *
         * Return an Iterator that iterates through of each String in the order that they are
         * provided, but skips {@code null} values.
         *
         * @param strings an array of nullable values
         * @return an iterator of strings
         */
        public static Iterator<String> iterateStrings(String... strings) {
            // TODO
            return null;
        }

        /**
         * Problem 2.2
         *
         * Return a single Iterator<String> that chains together the array of Iterator<String>s in
         * the order that they are provided, but skips {@code null} values.
         *
         * @param stringIterators an array of nullable {@code Iterator< String>}s of nullable {@code
         *                        String}s
         * @return an {@link java.util.Iterator} of {@code String}s
         */
        public static Iterator<String> iterateStrings(Iterator<String>...
                                                              stringIterators) {
            // TODO
            return null;
        }

        /**
         * Problem 2.3
         *
         * Return an Iterator that iterates through strings of each String[] in the order that they
         * are provided, but skips {@code null} values.
         *
         * @param stringArrays an array of nullable {@code String[}s of nullable {@code String}s
         * @return an {@link java.util.Iterator} of {@code String}s
         */
        public static Iterator<String> iterateStrings(String[]...
                                                              stringArrays) {
            // TODO
            return null;
        }

        /**
         * Problem 2.4
         *
         * Return an Iterator that iterates through all Integers within each two-dimensional Integer
         * array in the order that they are provided, but skips {@code null} values.
         *
         * @param twoDimensionalIntArrays an array of nullable {@code Integer[][]}s of nullable
         *                                values
         * @return an {@link java.util.Iterator} of {@code Integer}s
         */
        public static Iterator<Integer> iterateInts(Integer[][]...
                                                            twoDimensionalIntArrays) {
            // TODO
            return null;
        }

        /**
         * Problem 2.5
         *
         * Return an Iterator that iterates through all Integers within each set in the order that
         * they are provided, but skips {@code null} values.
         *
         * @param integerSetList a list of nullable {@code LinkedHashSet}s of nullable {@code
         *                       Integer}s
         * @return an {@link java.util.Iterator} of {@code Integer}s
         */
        public static Iterator<Integer> iterateInts2(List<LinkedHashSet<
                Integer>> integerSetList) {
            // TODO
            return null;
        }

        /**
         * Problem 2.6
         *
         * Bonus question!
         *
         * Despite using generics, invoking one of the methods above in
         Problem 2 is not guaranteed to be
         * type-safe.
         *
         * Answer the following questions:
         *
         *   a) Which method is it?
         *
         *   b) Does the java compiler let you know? If not, how can you
         tell? If so, what warning or error
         *      will the compiler give you?
         *
         *   c) What can you do to avoid the problem?
         */
    }
}
