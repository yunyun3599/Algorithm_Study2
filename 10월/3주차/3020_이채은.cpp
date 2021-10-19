#include <stdio.h>
#include <vector>

int N, H, cnt, min = 300000, num;
int bottom[500001], top[500001];

int main() {
    scanf("%d %d", &N, &H);
    for (int i = 0; i < N; i++) {
        scanf("%d", &num);
        if (i % 2 == 0) {
            bottom[num]++;
        }
        else {
            top[num]++;
        }
    }
    for (int i = 1; i < H; i++) {
        top[H - i] += top[H - i + 1];
        bottom[H - i] += bottom[H - i + 1];
    }
    for (int i = 1; i <= H; i++) {
        int sum = top[H - i + 1] + bottom[i];
        if (min > sum) {
            min = sum; cnt = 1;
        }
        else if (min == sum) cnt++;
    }
    printf("%d %d", min, cnt);
}
