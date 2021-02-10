package com.spring13269.leetcode.Q301_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Q332
 *
 * @author : zengle.huang@hand-china.com 2020/8/27
 */
public class Q332 {
    /**
     * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
     *
     * 说明:
     *
     * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
     * 所有的机场都用三个大写字母表示（机场代码）。
     * 假定所有机票至少存在一种合理的行程。
     * 示例 1:
     *
     * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     * 示例 2:
     *
     * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
     *
     *
     * 中文翻译有问题，大意是一个人的所有票，然后根据票重新排列顺序，将所有经过的路径串起来
     * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
     *
     * Note:
     * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     * All airports are represented by three capital letters (IATA code).
     * You may assume all tickets form at least one valid itinerary.
     * One must use all the tickets once and only once.
     */

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result= new ArrayList<>(tickets.size() + 1);
        if (tickets.size() < 1) {
            return result;
        }
        /*Map<String, List<String>> ticketMap = tickets.stream()
                .collect(Collectors.toMap(ticket -> ticket.get(0),
                ticket -> Collections.singletonList(ticket.get(1)),
                (v1,v2) -> {v1.addAll(v2); return v1;}));*/
        Map<String, List<String>> ticketMap = tickets.stream()
                .collect(Collectors.groupingBy(tic -> tic.get(0), HashMap::new,
                        Collectors.mapping(tic -> tic.get(1), Collectors.toList())));
        String current = "JFK";
        result.add(current);
        while (ticketMap.containsKey(current)) {
            List<String> newAddrs = ticketMap.get(current);
            String next = newAddrs.stream().min(String::compareTo).orElse(newAddrs.get(0));
            newAddrs.remove(next);
            if (newAddrs.size() <1) {
                ticketMap.remove(current);
            }

            result.add(next);
            current = next;
        }
        return result;
    }
}
