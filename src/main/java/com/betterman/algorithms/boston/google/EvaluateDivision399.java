package com.betterman.algorithms.boston.google;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * <p>
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class EvaluateDivision399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> m = new HashMap();

        int i = 0;
        for (List<String> pair : equations) {
            String s0 = pair.get(0), s1 = pair.get(1);
            if (!m.containsKey(s0)) {
                m.put(s0, new HashMap());
            }

            if (!m.containsKey(s1)) {
                m.put(s1, new HashMap());
            }

            m.get(s0).put(s1, values[i]);
            m.get(s1).put(s0, 1 / values[i]);
            i++;
        }

        double[] res = new double[queries.size()];
        i = 0;
        for (List<String> query : queries) {
            res[i++] = dfs(m, new HashSet(), query.get(0), query.get(1));
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map,
                       Set<String> seen,
                       String from,
                       String to) {
        if (!map.containsKey(from) || !seen.add(from)) {
            return -1;
        } else if (from.equals(to)) {
            return 1;
        }

        Map<String, Double> links = map.get(from);
        for (String key : links.keySet()) {
            double val = dfs(map, seen, key, to);
            if (val != -1) {
                return val * links.get(key);
            }
        }
        return -1;
    }


    public double[] calcEquationUnionFind(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> roots = new HashMap();
        Map<String, Double> distances = new HashMap();
        int i = 0;
        for (List<String> e : equations) {
            union(roots, distances, e.get(0), e.get(1), values[i]);
            i++;
        }

        double[] res = new double[queries.size()];
        i = 0;
        for (List<String> query : queries) {
            String s0 = query.get(0);
            String s1 = query.get(1);
            String p0 = find(roots, distances, s0);
            String p1 = find(roots, distances, s1);
            if (p0 == null || p1 == null) {
                res[i] = -1;
            } else if (!p0.equals(p1)) {
                res[i] = -1;
            } else {
                res[i] = distances.get(s0) / distances.get(s1);
            }
            i++;
        }
        return res;
    }

    private void union(Map<String, String> roots, Map<String, Double> distances, String s0, String s1, double value) {
        if (!roots.containsKey(s0)) {
            roots.put(s0, s0);
            distances.put(s0, 1.0);
        }
        if (!roots.containsKey(s1)) {
            roots.put(s1, s1);
            distances.put(s1, 1.0);
        }

        String r0 = find(roots, distances, s0);
        String r1 = find(roots, distances, s1);

        roots.put(r0, r1);
        distances.put(r0, value * distances.get(s1) / distances.get(s0));
    }

    private String find(Map<String, String> roots, Map<String, Double> distances, String str) {
        if (!roots.containsKey(str)) {
            return null;
        }

        String r = roots.get(str);
        if (r.equals(str)) {
            return r;
        }

        String rr = find(roots, distances, r);
        //path compression
        if (!r.equals(rr)) {
            roots.put(str, rr);
            distances.put(str, distances.get(r) * distances.get(str));
        }
        return rr;
    }

    public static void main(String[] args) {

        List<String> equation = Lists.newArrayList("a", "b");
        List<String> equation1 = Lists.newArrayList("b", "c");
        List<String> equation2 = Lists.newArrayList("c", "d");
        List<String> equation3 = Lists.newArrayList("d", "e");
        List<List<String>> equations = Lists.newArrayList(equation, equation1, equation2, equation3);
        double[] values = {2.0, 3.0, 4.0, 5.0, 6.0};


        List<String> query0 = Lists.newArrayList("a", "e");
        List<String> query1 = Lists.newArrayList("e", "b");
        List<String> query2 = Lists.newArrayList("a", "e");
        List<String> query3 = Lists.newArrayList("a", "a");
        List<String> query4 = Lists.newArrayList("x", "x");
        List<List<String>> queries = Lists.newArrayList(
                query0,
                query1
//                query2,
//                query3,
//                query4
        );
        EvaluateDivision399 evaluateDivision = new EvaluateDivision399();

        System.out.println(Arrays.toString(evaluateDivision.calcEquationUnionFind(equations, values, queries)));
    }
}
