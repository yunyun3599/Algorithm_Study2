#include <stdio.h>

int N, M, sum, ans;
int lesson[100000];

int main() {
    scanf("%d%d", &N, &M);
    for (int i = 0; i < N; i++) {
        scanf("%d", &lesson[i]);
        sum += lesson[i];
    }
    int min = 1, max = sum;
    while (min <= max) {
        bool flag = false;
        int mid = (min + max) / 2, cnt = 0;
        for (int i = 0; i < N;) {
            int tmp = 0;
            while (i < N) {
                if (lesson[i] > mid) {
                    flag = true; break;
                }
                tmp += lesson[i];
                if (tmp <= mid) i++;
                else break;
            }
            cnt++;
            if (flag) break;
        }
        if (!flag && cnt <= M) {
            ans = mid;
            max = mid - 1;
        }
        else min = mid + 1;
    }
    printf("%d", ans);
}
