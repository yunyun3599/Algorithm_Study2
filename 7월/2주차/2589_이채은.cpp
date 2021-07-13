#include <stdio.h>
#include <queue>

using namespace std;

int r, c, ans = 0;
char map[50][50];
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    bool visit[50][50] = { false, };
    int dist[50][50] = { 0, };
    visit[x][y] = true;
    q.push({ x, y });
    while (!q.empty()) {
        pair<int, int> p = q.front(); q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = p.first + dx[i];
            int ny = p.second + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visit[nx][ny] && map[nx][ny] == 'L') {
                visit[nx][ny] = true;
                q.push({ nx, ny });
                dist[nx][ny] = dist[p.first][p.second] + 1;
                ans = (dist[nx][ny] > ans) ? dist[nx][ny] : ans; //bfs 함수 내부에서 최대 체크
            }
        }
    }
}

int main() {
    scanf("%d %d", &r, &c);
    for (int i = 0; i < r; i++)
        scanf("%s", &map[i]);

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            if (map[i][j] == 'L') bfs(i, j); //

    printf("%d", ans);
}
