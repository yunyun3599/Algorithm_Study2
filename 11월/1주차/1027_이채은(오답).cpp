#include <stdio.h>

int N, max, ans[51];
long long h[51];

void calc(int num) {
    for (int i = num + 1; i <= N; i++) {
        bool flag = true;
        for (int j = num + 1; j < i; j++) {
            long long val = j * h[i] + i * h[num] + num * h[j] - (i * h[j] + num * h[i] + j * h[num]);
            if (val <= 0) {
                flag = false; break;
            }
        }
        if (!flag) continue;
        ans[num]++; ans[i]++;
    }
}

int main() {
    scanf("%d", &N);
    for (int i = 1; i <= N; i++) scanf("%lld", &h[i]);
    for (int i = 1; i < N; i++) {
        calc(i);
        if (ans[i] > max) max = ans[i];
    }
    printf("%d", max);
}
