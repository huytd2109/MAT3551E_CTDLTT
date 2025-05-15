public class Robot {

    public int countPath(int M, int N, int t) {
        return combination(t - 1 + N - 1, t - 1) +  // from [t,1] to [1,N]
               combination(M - (t + 1) + N - 1, M - (t + 1));  // from [t+1,1] to [M,N]
    }

    // Tính tổ hợp C(n, k)
    private int combination(int n, int k) {
        if (k > n) return 0;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return (int) res;
    }
}
