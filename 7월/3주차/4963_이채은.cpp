#include <stdio.h>
#include <queue>

using namespace std;

int w, h;
int map[50][50];
bool visit[50][50] = { false, };
int dx[8] = { 0, 0, 1, -1, -1, 1, 1, -1 };
int dy[8] = { 1, -1, 0, 0, -1, -1, 1, 1 };

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    visit[x][y] = true;
    q.push({ x, y });
    while (!q.empty()) {
        pair<int, int> p = q.front(); q.pop();
        for (int i = 0; i < 8; i++) {
            int nx = p.first + dx[i];
            int ny = p.second + dy[i];
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny] && map[nx][ny] == 1) {
                q.push({ nx, ny });
                visit[nx][ny] = true;
            }
        }
    }
}

int main() {
    while (true) {
        scanf("%d %d", &w, &h);
        if (w == 0 && h == 0) break;
        int cnt = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                scanf("%d", &map[i][j]);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    bfs(i, j); cnt++;
                }
            }
        }

        printf("%d\n", cnt);
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                visit[i][j] = false;
    }
}
