#include <stdio.h>

int N, S, M, ans = -1, V[51];
bool dp[51][1001];

int main() {
    scanf("%d %d  %d", &N, &S, &M);
    for (int i = 1; i <= N; i++) {
        scanf("%d", &V[i]);
    }

    dp[0][S] = true;
    for (int i = 1; i <= N; i++) {
        for (int j = 0; j <= M; j++) {
            if (!dp[i - 1][j]) continue;
            if (j + V[i] <= M) dp[i][j + V[i]] = true;
            if (j - V[i] >= 0) dp[i][j - V[i]] = true;
        }
    }

    for (int i = M; i >= 0; i--) {
        if (dp[N][i]) {
            ans = i; break;
        }
    }
    printf("%d", ans);
}
