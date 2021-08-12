#include <stdio.h>
#include <stdlib.h>

int N, ans = 500000;
int map[21][21];

void check(int x, int y, int d1, int d2) {
    int ppl[5] = { 0, };
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            if (i < x + d1 && j <= y && i + j < x + y) {
                ppl[0] += map[i][j];
            }
            else if (i <= x + d2 && j > y && j - i > y - x) {
                ppl[1] += map[i][j];
            }
            else if (i >= x + d1 && j < y - d1 + d2 && i - j > x - y + 2 * d1) {
                ppl[2] += map[i][j];
            }
            else if (i > x + d2 && j >= y - d1 + d2 && i + j > x + y + 2 * d2) {
                ppl[3] += map[i][j];
            }
            else {
                ppl[4] += map[i][j];
            }
        }
    }
    int max = 0, min = 100000;
    for (int i = 0; i < 5; i++) {
        if (ppl[i] < min) min = ppl[i];
        if (ppl[i] > max) max = ppl[i];
    }
    if (ans > max - min) ans = max - min;
}

int main() {
    scanf("%d", &N);
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            scanf("%d", &map[i][j]);

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            for (int d1 = 1; d1 <= j - 1; d1++) {
                for (int d2 = 1; d2 <= N - j; d2++) {
                    if (d1 + d2 > N - i) continue;
                    check(i, j, d1, d2);
                }
            }
        }
    }

    printf("%d", ans);
}
