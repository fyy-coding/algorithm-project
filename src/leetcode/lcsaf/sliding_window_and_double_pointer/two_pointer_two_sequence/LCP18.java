package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_two_sequence;

import java.util.Arrays;

public class LCP18 {
    /**
     * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
     *
     * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     * 1 <= staple.length <= 10^5
     * 1 <= drinks.length <= 10^5
     * 1 <= staple[i],drinks[i] <= 10^5
     * 1 <= x <= 2*10^5
     */

    public static final int MOD = (int) (1e9 + 7);
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int len1 = staple.length, len2 = drinks.length;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        int idx1 = 0, idx2 = len2 - 1;
        while (idx1 < len1 && idx2 >= 0) {
            if (staple[idx1] + drinks[idx2] <= x) {
                ans += idx2 + 1;
                ans %= MOD;
                idx1++;
            } else {
                idx2--;
            }
        }
        return ans;
    }
}
