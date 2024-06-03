/**
 * Problem: Trail of ones
 * Description: Given a number n, find the number of binary strings of length n that contain consecutive 1's in them. Since the number can be very large, return the answer after modulo with 1e9+7.
 */
class Solution {
    static final int MOD = 1000000007;

    static int numberOfConsecutiveOnes(int n) {
        if (n == 1) {
            return 0;
        }

        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];

        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = (dp0[i-1] + dp1[i-1]) % MOD;
            dp1[i] = dp0[i-1] % MOD;
        }

        long total_valid_strings = (dp0[n] + dp1[n]) % MOD;

        long total_strings = power(2, n, MOD);

        long total_invalid_strings = (total_strings - total_valid_strings + MOD) % MOD;

        return (int) total_invalid_strings;
    }

    static long power(int base, int exp, int mod) {
        long result = 1;
        long baseMod = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * baseMod) % mod;
            }
            baseMod = (baseMod * baseMod) % mod;
            exp >>= 1;
        }

        return result;
    }
}