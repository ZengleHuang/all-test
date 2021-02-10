package com.spring13269.leetcode.Q1001_1100;

/**
 * ShipWithinDays1011 description
 *
 * @author zengle.huang@hand-china.com  2019/12/5
 * @version 1.0
 */
public class ShipWithinDays1011 {
    public static int shipWithinDays(int[] weights, int D) {
        int total = 0;
        for(int i = 0; i< weights.length; i++) {
            total += weights[i];
        }
        return shipWithinDays(weights, D, 0, total);

    }

    public static int shipWithinDays(int[] weights, int days, int start, int total) {
        int currentWeigth = 0;
        int pingjun = total/days;
        if (start >= weights.length) {
            return 0;
        }
        if (days == 1) {
            return total;
        }
        // 取得不到平均值的总和
        int i = start;
        int minWeigth = Integer.MAX_VALUE;
        for(; i < weights.length;i++) {
            currentWeigth += weights[i];
            minWeigth = Math.min(minWeigth, Math.max(currentWeigth, shipWithinDays(weights, days-1, i + 1, total - currentWeigth)));
        }
        /*int jWeigth = currentWeigth;
        for (int j=i; j< weights.length;j++) {
            jWeigth+=weights[j];
            minWeigth = Math.min(minWeigth, Math.max(jWeigth, shipWithinDays(weights, days-1, j, total - jWeigth)));
        }*/
        return minWeigth;
        /*// 判断加到大于平均值   和   不到平均值之间的最小
        int minShipLess = shipWithinDays(weights, days-1, i, total - currentWeigth);
        int minShipGreat = shipWithinDays(weights, days - 1, i+1, total -currentWeigth-weights[i]);
        int minWeigth = Math.min(Math.max(currentWeigth + weights[i], minShipGreat),
                Math.max(currentWeigth, minShipLess));
        System.out.println("Day  " + days + " min  " + minWeigth
                + "  小于平均值时当前 " + currentWeigth + " 剩余最小 " + minShipLess
                + "  大于平均值时当前 " + (currentWeigth + weights[i]) + " 剩余最小 " + minShipGreat);
        return minWeigth;*/
    }

    public static void main(String[] args) {
        int[] nums = new int[]{180,373,75,82,497,23,303,299,53,426,152,314,206,433,283,370,179,254,265,431,453,17,189,224};
        System.out.println(shipWithinDays(nums, 12));
    }
}
