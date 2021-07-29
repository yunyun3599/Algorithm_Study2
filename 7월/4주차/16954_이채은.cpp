#include <stdio.h>
#include <queue>
#define pp pair<int, pair<int, int>>
using namespace std;

int ans;
char chess[8][8];
bool visit[9][8][8];
int dx[9] = { -1,0,1,1,1,0,-1,-1,0 };
int dy[9] = { 1,1,1,0,-1,-1,-1,0,0 };

int main()
{
	for (int i = 0; i < 8; i++)
		for (int j = 0; j < 8; j++)
			scanf(" %c", &chess[i][j]);

	queue<pp> q;
	q.push({ 0,{7,0} });
	visit[0][7][0] = true;
	while (!q.empty()) {
		pp p = q.front(); q.pop();
		if (p.second.first == 0 && p.second.second == 7) {
			ans = 1; break;
		}

		for (int i = 0; i < 9; ++i) {
			int nx = p.second.first + dx[i];
			int ny = p.second.second + dy[i];
			int nt = min(p.first + 1, 8);

			if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visit[nt][nx][ny]) {
				if (nx - p.first >= 0 && chess[nx - p.first][ny] == '#') continue;
				if (nx - p.first - 1 >= 0 && chess[nx - p.first - 1][ny] == '#') continue;
				visit[nt][nx][ny] = true;
				q.push({ nt, {nx, ny} });
			}
		}
	}
	printf("%d", ans);
}
