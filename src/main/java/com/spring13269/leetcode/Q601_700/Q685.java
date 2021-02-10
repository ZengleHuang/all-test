package com.spring13269.leetcode.Q601_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Q685
 *
 * @author : zengle.huang@hand-china.com 2020/9/17
 */
public class Q685 {
    /**
     * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
     * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
     * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
     * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
     *
     * 示例 1:
     * 输入: [[1,2], [1,3], [2,3]]
     * 输出: [2,3]
     * 解释: 给定的有向图如下:
     *   1
     *  / \
     * v   v
     * 2-->3
     * 示例 2:
     * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
     * 输出: [4,1]
     * 解释: 给定的有向图如下:
     * 5 <- 1 -> 2
     *      ^    |
     *      |    v
     *      4 <- 3
     * 注意:
     * 二维数组大小的在3到1000范围内。
     * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
     */

    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length < 1) {
            return new int[]{};
        }
        Map<Integer, Integer> inList = new HashMap<>(edges.length);
        Map<Integer, Integer> rootList = new HashMap<>(edges.length);
        /*int[] root = new int[edges.length];
        int[] parent = new int[edges.length];*/

        //Map<Integer, Set<Integer>> outList = new HashMap<>(edges.length);
        for (int[] edge : edges) {
            if (inList.containsKey(edge[1])
                    || (rootList.containsKey(edge[0]) && rootList.get(edge[0]) == edge[1])
                /*(outList.containsKey(edge[0]) && outList.get(edge[0]).contains(edge[1]))*/) {
                return edge;
            } else {
                inList.put(edge[1], edge[0]);
                rootList.put(edge[1], edge[0]);
                if (rootList.containsKey(edge[1])) {
                    rootList.entrySet().stream()
                            .filter(v -> edge[1] == v.getValue())
                            .forEach(ent -> ent.setValue(rootList.get(edge[1])));
                }
                if (rootList.containsKey(edge[0])) {
                    rootList.entrySet().stream()
                            .filter(v -> edge[0] == v.getValue())
                            .forEach(ent -> ent.setValue(rootList.get(edge[0])));
                }
                /*Set<Integer> outs = outList.getOrDefault(edge[0], new HashSet<>());
                outs.add(edge[1]);
                outList.put(edge[0], outs);*/
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Q685 q = new Q685();
        q.findRedundantDirectedConnection(new int[][]{
                {2,3}, {1,2}, {3,4}, {4,1}, {1,5}
        });
        // [[2,1],[3,1],[4,2],[1,4]]
    }
}
