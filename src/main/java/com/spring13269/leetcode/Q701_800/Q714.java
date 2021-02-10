package com.spring13269.leetcode.Q701_800;

/**
 * Q714
 *
 * @author : zengle.huang@hand-china.com 2020/12/21
 */
public class Q714 {
    /**
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 示例 1:
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * 注意:
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     */
    public int maxProfit(int[] prices, int fee) {
        int total = 0;
        if (prices.length < 2) {
            return total;
        }
        int min = prices[0];
        int max = prices[0];
        boolean up = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                if (max - min > fee) {
                    total += max - min - fee;
                }
                min = prices[i];
                max = prices[i];
                up =false;
            }
            if (prices[i] > max) {
                max = prices[i];
                up = true;
            }
            if (prices[i] <= max && max - min > fee) {
                total += max - min - fee;
                min = prices[i];
                max = prices[i];
                up = false;
            }
        }
        if (up && max - min > fee) {
            total += max - min - fee;
        }
        return total;
    }
    public static void main(String[] args) {
        Q714 q = new Q714();
        //q.maxProfit(new int[]{1,4,1,4,1,4,1,4,1,4,1,4,1,4}, 2);
        q.maxProfit(new int[]{1,3,7,5,10,3}, 3);
    }
}
