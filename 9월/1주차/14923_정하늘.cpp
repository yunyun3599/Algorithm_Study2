#include<stdio.h>
#include<vector>
#include<queue>

using namespace std;

int n, m;
int hx, hy;
int ex, ey;
int map[1002][1002];
int visit[1002][1002][2] = { 0, };//x,y,block 여부
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int BFS() {
	queue< pair< pair<int, int>, pair<int, int> > > q;
	q.push({ {hx,hy},{0,0} });//시작점, 벽 뚫은 여부, cnt
	visit[hx][hy][0] = 1;//방문 체크

	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int block = q.front().second.first;
		int cnt = q.front().second.second;
		q.pop();
		if (x == ex && y == ey) {
			return cnt;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 < nx && nx <= n && 0 < ny && ny <= m) {
				if (map[nx][ny] == 1 && block == 0) {
					visit[nx][ny][block + 1] = 1;
					q.push({ { nx,ny }, { block + 1 , cnt + 1 } });
				}//벽이 있고, 뚫을 수 있다면				
				else if (map[nx][ny] == 0 && visit[nx][ny][block] == 0) {
					visit[nx][ny][block] = 1;
					q.push({ { nx,ny }, { block,cnt + 1 } });
				}
			}

		}
	}
	return -1;
}


int main() {
	scanf("%d%d", &n, &m);
	scanf("%d%d", &hx, &hy);
	scanf("%d%d", &ex, &ey);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	printf("%d\n", BFS());
}


/*
14923. 미로 탈출
https://www.acmicpc.net/problem/14923

문제
홍익이는 사악한 마법사의 꾐에 속아 N x M 미로 (Hx, Hy) 위치에 떨어졌다. 다행히도 홍익이는 마법사가 만든 미로의 탈출 위치(Ex, Ey)를 알고 있다. 하지만 미로에는 곳곳에 마법사가 설치한 벽이 있어 홍익이가 탈출하기 어렵게 하고 있다.

홍익이는 마법사의 연구실에서 훔친 지팡이가 있어, 벽을 길로 만들 수 있다. 그렇지만, 안타깝게도 마법의 지팡이는 단 한 번만 사용할 수 있다.

이때, 홍익이를 도와 미로에서 탈출할 수 있는지 알아보고, 할 수 있다면 가장 빠른 경로의 거리 D는 얼마인지 알아보자.

인접한 칸으로 이동하는데 똑같은 시간이 들고, 벽을 부수는 데 시간이 걸리지 않는다.

입력
N M
Hx Hy
Ex Ey
N X M 행렬
2 ≤ N ≤ 1000, 2 ≤ M ≤ 1000
1 ≤ Hx, Hy, Ex, Ey ≤ 1000
(Hx, Hy)≠ (Ex, Ey)
행렬은 0과 1로만 이루어져 있고, 0이 빈 칸, 1이 벽이다.
출력
D (탈출 할 수 없다면, -1을 출력한다.)

*/