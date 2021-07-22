#include<stdio.h>
#include<vector>
#include<queue>


using namespace std;

int R, C, T;

int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,1,-1 };

int ccw[4] = { 2, 0, 3, 1 };
int cw[4] = { 2, 1, 3, 0 };

int room[51][51] = { 0, };
int room_copy[51][51] = { 0, };

void copy() {
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			room_copy[i][j] = room[i][j];
		}
	}
}

int main() {
	
	int airX_top = -1, airY_top = -1, airX_bottom = -1, airY_bottom = -1;

	scanf("%d%d%d", &R, &C, &T);
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			scanf("%d", &room[i][j]);
			if (room[i][j] == -1) {
				if (airX_top == -1) { 
					airX_top = i;
					airY_top = j; 
				}
				else {
					airX_bottom = i;
					airY_bottom = j;
				}
			}
		}
	}

	while (T--) {
		queue<pair<int, int>> q;

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (room[i][j] >= 1) q.push({ i, j });//미세먼지 있는 좌표 삽입

		copy();
		while (!q.empty()) {
			int x = q.front().first;
			int y = q.front().second;
			q.pop();
			int spread = room_copy[x][y] / 5;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < R && 0 <= ny && ny < C) {
					if (room_copy[nx][ny] >= 0) {
						room[nx][ny] += spread;
						room[x][y] -= spread;
					}
				}
			}
		}

		copy();
		//위쪽 반시계 공기청정		
		int x = airX_top;
		int y = airY_top + 1;
		room[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			while (1) {
				int nx = x + dx[ccw[i]];
				int ny = y + dy[ccw[i]];
				if (ny == airY_top && nx == airX_top) break;
				if (!(0 <= nx && nx < R && 0 <= ny && ny < C)) break;
				room[nx][ny] = room_copy[x][y]; 
				x = nx; 
				y = ny;
			}
		}

		//아래쪽 시계 공기청정 
		x = airX_bottom;
		y = airY_bottom + 1;
		room[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			while (1) {
				int nx = x + dx[cw[i]];
				int ny = y + dy[cw[i]];
				if (nx == airX_bottom && ny == airY_bottom) break;
				if (!(0 <= nx && nx < R && 0 <= ny && ny < C)) break;
				room[nx][ny] = room_copy[x][y]; 
				x = nx; 
				y = ny;


			}
		}
	}

	int ans = 0;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			ans += room[i][j];
		}
	}
	printf("%d\n", ans + 2);
}

/*
17144. 미세먼지 안녕!
https://www.acmicpc.net/problem/17144

문제
미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다. (r, c)는 r행 c열을 의미한다.



공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.

1초 동안 아래 적힌 일이 순서대로 일어난다.

미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
확산되는 양은 Ar,c/5이고 소수점은 버린다.
(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
공기청정기가 작동한다.
공기청정기에서는 바람이 나온다.
위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
다음은 확산의 예시이다.



왼쪽과 오른쪽에 칸이 없기 때문에, 두 방향으로만 확산이 일어났다.



인접한 네 방향으로 모두 확산이 일어난다.



공기청정기가 있는 칸으로는 확산이 일어나지 않는다.

공기청정기의 바람은 다음과 같은 방향으로 순환한다.



방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.

입력
첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.

둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.

출력
첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.
*/