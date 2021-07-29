#include <stdio.h>

int R, C, K, ans;
int dp[31][31];

int main() {
    scanf("%d %d %d", &R, &C, &K);
    for (int i = 0; i <= R + C; i++) {
        for (int j = 0; j <= i; j++) {
            if (i == j || j == 0)
                dp[i][j] = 1;
            else
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]);
        }
    }
    if (K == 0)
        ans = dp[R + C - 2][C - 1];
    else {
        int nr = K / C;
        if (K % C == 0) nr--;
        int nc = (K - 1) % C;
        ans = dp[nr + nc][nr] * dp[R + C - nr - nc - 2][C - nc - 1];
    }
    printf("%d", ans);
}
