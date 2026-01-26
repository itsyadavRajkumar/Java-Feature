package com.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContestBuyAndSell {
//    public long maxProfit(int[] prices, int[] strategy, int k) {
//        int n = prices.length;
//        long sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += (long) strategy[i] * prices[i];
//        }
//        long max = sum;
//        int low = 0;
//        while (low + k <= n) {
//            long temp = 0;
//            int j = low;
//            while (j < low + k / 2) {
//                temp -= (long) strategy[j] * prices[j];
//                j++;
//            }
//            j = low + k / 2;
//            while (j < low + k) {
//                long pro = (long) strategy[j] * prices[j];
//                temp += (long) prices[j] - pro;
//                j++;
//            }
//            max = Math.max(max, sum + temp);
//            low++;
//        }
//
//        return max;
//    }


    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }
        long[] prefixPrice = new long[n + 1];
        long[] prefixContribution = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixPrice[i + 1] = prefixPrice[i] + prices[i];
            long pro = (long) strategy[i] * prices[i];
            prefixContribution[i + 1] = prefixContribution[i] + pro;
        }
        long best = baseProfit;
        for (int start = 0; start + k <= n; start++) {
            int mid = start + k / 2;
            int end = start + k;

            long firstHalfLoss = prefixContribution[mid] - prefixContribution[start];

            long oldSecondHalf = prefixContribution[end] - prefixContribution[mid];
            long newSecondHalf = prefixPrice[end] - prefixPrice[mid];

            long gain = -firstHalfLoss + (newSecondHalf - oldSecondHalf);

            long candidate = baseProfit + gain;
            if (candidate > best) {
                best = candidate;
            }
        }

        return best;
    }

    public long maxxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // prefix sums
        long[] P = new long[n + 1]; // prefix of prices
        long[] S = new long[n + 1]; // prefix of strategy*prices

        long original = 0;
        for (int i = 0; i < n; i++) {
            original += (long) strategy[i] * prices[i];
            P[i + 1] = P[i] + prices[i];
            S[i + 1] = S[i] + (long) strategy[i] * prices[i];
        }

        long maxProfit = original;

        // try every window
        for (int l = 0; l + k <= n; l++) {
            int mid = l + k / 2;
            int r = l + k - 1;

            // remove first half
            long remove = S[mid] - S[l];

            // replace second half
            long add = (P[r + 1] - P[mid]) - (S[r + 1] - S[mid]);

            long delta = -remove + add;
            maxProfit = Math.max(maxProfit, original + delta);
        }

        return maxProfit;
    }

    public long minArraySum(int[] nums, int k) {

        long total = 0;
        for (int num : nums) total += num;

        int rem = (int) (total % k);
        if (rem == 0) return 0;

        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Map<Integer, Long> minPrefixForRemainder = new HashMap<>();
        minPrefixForRemainder.put(0, 0L);

        long minSubSum = Long.MAX_VALUE;

        for (int j = 1; j <= n; j++) {
            int mod = (int) (prefix[j] % k);
            int target = (mod - rem + k) % k;

            if (minPrefixForRemainder.containsKey(target)) {
                long subSum = prefix[j] - minPrefixForRemainder.get(target);
                minSubSum = Math.min(minSubSum, subSum);
            }

            minPrefixForRemainder.merge(mod, prefix[j], Math::min);
        }

        return (minSubSum == Long.MAX_VALUE) ? total : minSubSum;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int) (((long) nums[idx] * v) % MOD);
            }
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public int xorAfterQueries1(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007; // 10^9 + 7

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int)(((long) nums[idx] * v) % MOD);
            }
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
