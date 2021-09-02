#include <stdio.h>
#include <algorithm>

using namespace std;

int N, K, ans;
int sensor[10000];
int dist[10000];

int main() {
    scanf("%d %d", &N, &K);
    for (int i = 0; i < N; i++)
        scanf("%d", &sensor[i]);
    if (K >= N) {
        printf("0"); return 0;
    }
    sort(sensor, sensor + N);
    for (int i = 0; i < N - 1; i++)
        dist[i] = sensor[i + 1] - sensor[i];
    sort(dist, dist + N - 1);
    for (int i = 0; i < N - K; i++)
        ans += dist[i];
    printf("%d", ans);
}
