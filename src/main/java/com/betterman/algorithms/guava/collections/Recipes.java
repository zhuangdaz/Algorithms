package com.betterman.algorithms.guava.collections;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by zhuangda on 4/20/16.
 */
public class Recipes {

    //downcast a List<Parent> to a List<Child>
    class CastFunction<F, T extends F> implements Function<F, T> {
        public T apply(F from) {
            return (T) from;
        }
    }

    @Test
    public void downcastParentsToChildren() {
        List<Number> from = Lists.newArrayList(new Number[]{1, 2.5, 3.0});
        List<Integer> to = Lists.transform(from, new CastFunction<>());
        System.out.println(to);
    }
}
