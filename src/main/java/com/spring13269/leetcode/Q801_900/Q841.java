package com.spring13269.leetcode.Q801_900;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Q841 description
 *
 * @author zengle.huang@hand-china.com  2019/12/6
 * @version 1.0
 */
public class Q841 {
    /**
     * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     *
     * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
     *
     * 最初，除 0 号房间外的其余所有房间都被锁住。
     *
     * 你可以自由地在房间之间来回走动。
     *
     * 如果能进入每个房间返回 true，否则返回 false。
     *
     * @param rooms
     * @return
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.get(0).size() == 0) {
            if (rooms.size() == 1) {
                return true;
            }
            return false;
        }
        //LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        int[] hasIn = new int[rooms.size()];
//        List<Integer> list = new ArrayList<>(rooms.size());
//        list.addAll(rooms.get(0));
//        hasIn[0] = 1;
//        for (int i =0; i<list.size(); i++) {
//            if (hasIn[list.get(i)] == 1) {
//            } else {
//                hasIn[list.get(i)] = 1;
//                list.addAll(rooms.get(list.get(i)));
//                System.out.println(Arrays.toString(hasIn));
//            }
//        }
        Deque<List<Integer>> keys = new ArrayDeque<>(rooms.size());
        hasIn[0] = 1;
        keys.add(rooms.get(0));
        //keys.push(rooms.get(0));
        while (!keys.isEmpty()) {
            List<Integer> curKeys = keys.pop();
            curKeys.stream()
                    .filter(curKey -> hasIn[curKey]!= 1)
                    .forEach(curKey -> {
                        hasIn[curKey] = 1;
                        keys.push(rooms.get(curKey));
                    });
        }
        for (int value : hasIn) {
            if (value != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        canVisitAllRooms(Arrays.asList(Collections.singletonList(1), Collections.singletonList(2),
                Collections.singletonList(3), Collections.emptyList()));
    }
}
