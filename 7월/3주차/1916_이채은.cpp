#include <stdio.h>
#include <vector>

using namespace std;

int N, M, s, r;
int dist[1001];
bool visit[1001];
int bus[1001][1001];

int findIdx() {
    int idx = -1, min = 987654321;
    for (int i = 1; i <= N; i++) {
        if (!visit[i] && dist[i] < min) {
            idx = i; min = dist[i];
        }
    }
    return idx;
}

int main() {
    scanf("%d%d", &N, &M);
    for (int i = 0; i <= N; i++)
        for (int j = 0; j <= N; j++)
            bus[i][j] = 987654321;

    for (int i = 0; i < M; i++) {
        int x, y, z;
        scanf("%d%d%d", &x, &y, &z);
        if(bus[x][y] > z) bus[x][y] = z;
    }
    scanf("%d%d", &s, &r);

    for (int i = 0; i <= N; i++)
        dist[i] = 987654321;

    visit[s] = true;
    for (int i = 1; i <= N; i++) {
        dist[i] = bus[s][i];
    }

    for (int i = 0; i < N - 1; i++) {
        int cur = findIdx();
        if (cur == -1) break;
        visit[cur] = true;
        for (int j = 1; j <= N; j++) {
            if (bus[cur][j] != 987654321 && !visit[j] && dist[j] > dist[cur] + bus[cur][j])
                dist[j] = dist[cur] + bus[cur][j];
        }
    }

    printf("%d", dist[r]);
}
