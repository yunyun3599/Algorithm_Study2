#include <stdio.h>
#include <algorithm>
#include <stdlib.h>

using namespace std;

int N, s1, s2, l, ans;
int arr[20];

void move(int d1, int d2, int idx, int cnt) {
    if (idx == l) {
        ans = min(ans, cnt); return;
    }

    move(arr[idx], d2, idx + 1, cnt + abs(d1 - arr[idx]));
    move(d1, arr[idx], idx + 1, cnt + abs(d2 - arr[idx]));
}

int main() {
    scanf("%d", &N);
    scanf("%d %d", &s1, &s2);
    scanf("%d", &l);
    for (int i = 0; i < l; i++)
        scanf("%d", &arr[i]);

    ans = N * l + 1;
    move(s1, s2, 0, 0);
    printf("%d", ans);
}
