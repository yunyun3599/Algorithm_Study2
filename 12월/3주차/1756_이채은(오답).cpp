#include <stdio.h>
#include <algorithm>
#include <vector>

using namespace std;

int D, N, dp[300000];
vector<int> oven;

int main() {
    scanf("%d %d", &D, &N);
    int tmp;
    oven.push_back(0);
    for (int i = 1; i <= D; i++) {
        scanf("%d", &tmp);
        oven.push_back(tmp);
    }

    dp[0] = 2147483647;
    for (int i = 1; i <= D; i++) {
        dp[i] = min(dp[i - 1], oven[i]);
    }

    int cur = D;
    for (int i = 0; i < N; i++) {
        scanf("%d", &tmp);
        while (cur >= 0 && tmp > dp[cur--]);
        if (cur == -1) break;
    }

    printf("%d", cur + 1);
}
