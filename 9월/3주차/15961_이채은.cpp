#include <stdio.h>

int N, d, k, c, ans;
int sushi[3000000];
int check[3001];

void simul() {
    if (ans == d || ans == k + 1) return;
    int cnt = ans;
    for (int i = 0; i < N; i++) {
        if (--check[sushi[i]] == 0) cnt--;
        if (check[sushi[(i + k) % N]]++ == 0) cnt++;
        if (cnt > ans) ans = cnt;
    }
}

int main() {
    scanf("%d %d %d %d", &N, &d, &k, &c);
    for (int i = 0; i < N; i++) {
        scanf("%d", &sushi[i]);
    }

    for (int i = 0; i < k; i++) {
        check[sushi[i]]++;
        if (check[sushi[i]] > 1) continue;
        ans++;
    }
    if (check[c] == 0) ans++;
    check[c]++;
    simul();
    printf("%d", ans);
}
