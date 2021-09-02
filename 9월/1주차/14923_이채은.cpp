#include <stdio.h>
#include <queue>
#include <vector>
#define pp pair<pair<int, int>, int>

using namespace std;

int N, M, Hx, Hy, Ex, Ey;
int map[1001][1001];
int visit[1001][1001][2];
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void bfs() {
    queue<pp> q;
    q.push({ { Hx, Hy }, 0 });
    visit[Hx][Hy][0] = 1;
    while (!q.empty()) {
        auto p = q.front(); q.pop();
        int x = p.first.first;
        int y = p.first.second;
        int w = p.second;
        if (x == Ex && y == Ey) {
            printf("%d", visit[Ex][Ey][w] - 1);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx > 0 && nx <= N && ny > 0 && ny <= M && visit[nx][ny][w] == 0) {
                if (map[nx][ny] == 0) {
                    q.push({ {nx, ny}, w });
                    visit[nx][ny][w] = visit[x][y][w] + 1;
                }
                else if (w == 0) {
                    q.push({ {nx, ny}, w + 1 });
                    visit[nx][ny][w + 1] = visit[x][y][w] + 1;
                }
            }
        }
    }
    printf("-1");
}

int main() {
    scanf("%d %d", &N, &M);
    scanf("%d %d", &Hx, &Hy);
    scanf("%d %d", &Ex, &Ey);
    for (int i = 1; i < N + 1; i++)
        for (int j = 1; j < M + 1; j++)
            scanf("%d", &map[i][j]);

    bfs();
}
