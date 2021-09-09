#include <stdio.h>
#include <string.h>
#include <vector>
#include <queue>

using namespace std;

int N, M, ans = 30000;
int map[50][50];
bool visit[50][50];
bool check[10];
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
vector<pair<int, int>> pos;

void simulation() {
    memset(visit, false, sizeof(visit));

    queue<pair<int, int>> virus;
    for (int i = 0; i < pos.size(); i++) {
        if (!check[i]) continue;
        virus.push(pos[i]);
        visit[pos[i].first][pos[i].second] = true;
    }

    int cnt = 0;
    while (!virus.empty()) {
        int size = virus.size();
        for (int i = 0; i < size; i++) {
            pair<int, int> p = virus.front(); virus.pop();
            for (int j = 0; j < 4; j++) {
                int nx = p.first + dx[j];
                int ny = p.second + dy[j];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && map[nx][ny] != 1) {
                    visit[nx][ny] = true;
                    virus.push({ nx, ny });
                }
            }
        }
        cnt++;
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (!visit[i][j] && map[i][j] != 1) return;
        }
    }
    if (cnt < ans) ans = cnt;
}

void pick(int idx, int cnt) {
    if (cnt == M) {
        simulation(); return;
    }

    for (int i = idx; i < pos.size(); i++) {
        if (!check[i]) {
            check[i] = true;
            pick(i + 1, cnt + 1);
            check[i] = false;
        }
    }
}

int main() {
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &map[i][j]);
            if (map[i][j] == 2) pos.push_back({ i, j });
        }
    }

    pick(0, 0);
    if (ans == 30000) printf("-1");
    else printf("%d", ans - 1);
}
