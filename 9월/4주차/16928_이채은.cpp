#include <stdio.h>
#include <queue>

using namespace std;

int N, M;
int map[101], type[101], dist[101];

void simul() {
    queue<pair<int, int>> tmp;
    tmp.push({ 1, 0 });
    for (int i = 2; i < 101; i++)
        dist[i] = 101;
    while (!tmp.empty()) {
        auto p = tmp.front(); tmp.pop();
        if (p.first >= 100) continue;

        if (type[p.first] != 0) {
            dist[map[p.first]] = p.second;
            tmp.push({ map[p.first], p.second });
        }
        else {
            for (int i = 1; i <= 6; i++) {
                if (p.second + 1 < dist[p.first + i]) {
                    dist[p.first + i] = p.second + 1;
                    tmp.push({ p.first + i, p.second + 1 });
                }
            }
        }
    }
}

int main() {
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        map[x] = y; type[x] = 1;
    }
    for (int i = 0; i < M; i++) {
        int u, v;
        scanf("%d %d", &u, &v);
        map[u] = v; type[u] = 2;
    }

    simul();
    printf("%d", dist[100]);
}
