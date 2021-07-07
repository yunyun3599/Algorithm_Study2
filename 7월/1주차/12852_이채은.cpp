#include <stdio.h>

int N;
int dp[1000001] = { 0, };
int type[1000001] = { 0, };

int main() {
    scanf("%d", &N);
    for (int i = 1; i <= N; i++) {
        dp[i] = dp[i - 1] + 1;
        type[i] = 1;
        if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
            dp[i] = dp[i / 2] + 1; type[i] = 2;
        }
        if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
            dp[i] = dp[i / 3] + 1; type[i] = 3;
        }
    }
    printf("%d\n", dp[N] - 1);
    while (N > 0) {
        printf("%d ", N);
        switch (type[N]) {
        case 1:
            N--; break;
        case 2:
            N /= 2; break;
        case 3:
            N /= 3; break;
        }
    }
}
