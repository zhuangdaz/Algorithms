package com.betterman.algorithms.interview.airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhuangda on 11/18/15.
 */
public class TwoDArray<Type> implements Iterable<Type> {
    private List<Type> list = new ArrayList<Type>();

    public TwoDArray(Type[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                list.add(array[row][col]);
            }
        }
    }

    public Iterator<Type> iterator() {
        Iterator<Type> iter = new Iterator<Type>() {
            private int nextIndex = 0;

            public boolean hasNext() {
                if (nextIndex == list.size()) {
                    return false;
                }
                return true;
            }

            public Type next() {
                if (hasNext()) {
                    return list.get(nextIndex++);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }

            public void remove() {
                if (nextIndex == 0) {
                    throw new IllegalStateException();
                }

                list.remove(nextIndex - 1);
                nextIndex--;
            }
        };
        return iter;
    }

    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{
            {1, 2, 3},
            {},
            {5, 6}
        };

        TwoDArray<Integer> twoDArray = new TwoDArray<Integer>(arr);
        Iterator<Integer> iterator = twoDArray.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i == 5) iterator.remove();
            else System.out.println(i);
        }

    }
}
