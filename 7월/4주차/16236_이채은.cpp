#include <stdio.h>
#include <stdlib.h>
#include <queue>
#define pp pair<int, int>

using namespace std;

int N, x, y, cnt, feed, shark = 2;
int map[20][20];
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };

struct cmp {
    bool operator()(pp o1, pp o2) {
        if (o1.first == o2.first) return o1.second > o2.second;
        else return o1.first > o2.first;
    }
};

bool turn() {
    bool visit[20][20] = { false, };
    queue<pp> q;
    priority_queue<pp, vector<pp>, cmp> fish;
    q.push({ x, y }); map[x][y] = 0; int dist = 0;
    while (fish.empty() && !q.empty()) {
        int len = q.size(); dist++;
        for (int i = 0; i < len; i++) {
            auto p = q.front(); q.pop();
            for (int j = 0; j < 4; j++) {
                int nx = p.first + dx[j];
                int ny = p.second + dy[j];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    if (map[nx][ny] == 0 || map[nx][ny] == shark) q.push({ nx, ny });
                    else if (map[nx][ny] < shark) fish.push({ nx, ny });
                }
            }
        }
    }
    if (fish.empty()) return false;
    auto p = fish.top();
    cnt += dist;
    x = p.first; y = p.second;
    if (++feed == shark) {
        feed = 0; shark++;
    }
    return true;
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &map[i][j]);
            if (map[i][j] == 9) {
                x = i; y = j;
            }
        }
    }
    while (true) {
        if (!turn()) break;
    }
    printf("%d", cnt);
}
