#include <stdio.h>

int N, arr[101];
long long dp[101][21];

int main() {
    scanf("%d", &N);
    for (int i = 1; i <= N; i++)
        scanf("%d", &arr[i]);

    dp[1][arr[1]] = 1;
    for (int i = 1; i < N - 1; i++) {
        for (int j = 0; j < 21; j++) {
            if (dp[i][j] != 0) {
                int plus = j + arr[i + 1];
                int minus = j - arr[i + 1];
                if (plus >= 0 && plus <= 20) dp[i + 1][plus] += dp[i][j];
                if (minus >= 0 && minus <= 20) dp[i + 1][minus] += dp[i][j];
            }
        }
    }

    printf("%lld", dp[N - 1][arr[N]]);
}
