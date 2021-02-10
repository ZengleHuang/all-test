package com.spring13269.leetcode.Q901_1000;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Q933 description
 *
 * @author zengle.huang@hand-china.com  2019/12/17
 * @version 1.0
 */
public class Q933 {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(2));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.ping(7000));

    }

    static class RecentCounter {

        private LinkedList<Integer> pings = null;

        public RecentCounter() {
            pings = new LinkedList<>();
        }

        public int ping(int t) {
            Iterator<Integer> iterator = pings.iterator();
            while (iterator.hasNext()) {
                Integer integer = iterator.next();
                if (integer < t-3000) {
                    iterator.remove();
                } else {
                    break;
                }
            }
            pings.addLast(t);
            return pings.size();
        }
    }
}
