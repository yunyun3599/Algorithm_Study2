#include <stdio.h>
#include <stdlib.h>
#include <algorithm>

using namespace std;

int N;
int liq[100000];

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        scanf("%d", &liq[i]);
    }
    sort(liq, liq + N);
    if (liq[0] >= 0) {
        printf("%d %d", liq[0], liq[1]); return 0;
    }
    if (liq[N - 1] <= 0) {
        printf("%d %d", liq[N - 2], liq[N - 1]); return 0;
    }
    int l = 0, r = N - 1, min = 2000000001, ans1, ans2;
    while (l < r) {
        int sum = liq[l] + liq[r];
        if (sum == 0) {
            printf("%d %d", liq[l], liq[r]); return 0;
        }
        if (abs(sum) < abs(min)) {
            ans1 = liq[l]; ans2 = liq[r]; min = sum;
        }
        if (sum < 0) l++;
        if (sum > 0) r--;
    }
    printf("%d %d", ans1, ans2);
}
