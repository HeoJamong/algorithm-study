import java.util.*;

class Solution {
    int[] discounts = {10, 20, 30, 40};
    int maxSubscriber = 0;
    int maxSales = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(users, emoticons, new int[emoticons.length], 0);
        return new int[]{maxSubscriber, maxSales};
    }

    private void dfs(int[][] users, int[] emoticons, int[] discountInfo, int level) {
        if (level == emoticons.length) {
            int subscriber = 0;
            int totalSales = 0;

            for (int[] user : users) {
                int threshold = user[1];
                int discountLimit = user[0];
                int sum = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (discountInfo[i] >= discountLimit) {
                        sum += emoticons[i] * (100 - discountInfo[i]) / 100;
                    }
                }

                if (sum >= threshold) {
                    subscriber++;
                } else {
                    totalSales += sum;
                }
            }

            if (subscriber > maxSubscriber || (subscriber == maxSubscriber && totalSales > maxSales)) {
                maxSubscriber = subscriber;
                maxSales = totalSales;
            }
            return;
        }

        for (int discount : discounts) {
            discountInfo[level] = discount;
            dfs(users, emoticons, discountInfo, level + 1);
        }
    }
}
