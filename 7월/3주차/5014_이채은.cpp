#include <stdio.h>
#include <queue>

using namespace std;

int F, S, G, U, D, ans = -1;
bool visit[1000001];

int main() {
    scanf("%d %d %d %d %d", &F, &S, &G, &U, &D);
    queue<pair<int, int>> q;
    q.push({ S, 0 }); visit[S] = true;
    while (!q.empty()) {
        pair<int, int> p = q.front(); q.pop();
        if (p.first == G) {
            ans = p.second; break;
        }
        int up = p.first + U;
        int down = p.first - D;
        if (up <= F && !visit[up]) {
            q.push({ up, p.second + 1 });
            visit[up] = true;
        }
        if (down > 0 && !visit[down]) {
            q.push({ down, p.second + 1 });
            visit[down] = true;
        }
    }
    printf((ans == -1) ? "use the stairs" : "%d", ans);
}
