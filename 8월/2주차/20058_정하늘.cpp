#include<stdio.h>
#include<vector>
#include<queue>
#include<iostream>
#include<math.h>


using namespace std;

int N, Q;
int n;
int ice[70][70];
int ice_copy[70][70];

int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };


void rotate(int x, int y, int L) {
	for (int i = 0; i < L; i++) {
		for (int j = 0; j < L; j++) {
			ice_copy[i][j] = ice[x + L - 1 - j][y + i];
		}
	}
	for (int i = 0; i < L; i++) {
		for (int j = 0; j < L; j++) {
			ice[x + i][y + j] = ice_copy[i][j];
		}
	}
}


int visit[70][70];
int DFS(int x, int y) {
	visit[x][y] = 1;

	int ret = 1;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (nx >= n || nx < 0 || ny >= n || ny < 0) continue;
		if (!visit[nx][ny] && ice[nx][ny] > 0)
			ret += DFS(nx, ny);
	}
	return ret;
}
	
int main() {
	scanf("%d%d", &N, &Q);
	n = pow(2, N);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &ice[i][j]);
		}
	}
	while (Q--) {
		int level;
		scanf("%d", &level);

		level = pow(2, level);
		for (int i = 0; i < n; i += level) {
			for (int j = 0; j < n; j += level) {
				rotate(i, j, level);
			}
		}//모든 격자에 대해 회전

		int melt[70][70] = { 0, };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ice[i][j] == 0) continue;//얼음이 없으면 pass
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx >= n || nx<0 || ny>=n || ny < 0) continue;
					if (ice[nx][ny] > 0) cnt++;
				}
				if (cnt < 3) melt[i][j] = 1;//주변에 얼음이 3개 미만이면 녹음
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (melt[i][j]) ice[i][j]--;
			}
		}
	}


	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			sum += ice[i][j];
		}
	}
	int max_size = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (ice[i][j] > 0 && visit[i][j] == 0) {
				int ret = DFS(i, j);
				if (ret > max_size) max_size = ret;
			}
		}
	}
	
	printf("%d\n%d\n", sum, max_size);
}


/*
20058. 마법사 상어와 파이어스톰
https://www.acmicpc.net/problem/20058

문제
마법사 상어는 파이어볼과 토네이도를 조합해 파이어스톰을 시전할 수 있다. 오늘은 파이어스톰을 크기가 2N × 2N인 격자로 나누어진 얼음판에서 연습하려고 한다. 위치 (r, c)는 격자의 r행 c열을 의미하고, A[r][c]는 (r, c)에 있는 얼음의 양을 의미한다. A[r][c]가 0인 경우 얼음이 없는 것이다.

파이어스톰을 시전하려면 시전할 때마다 단계 L을 결정해야 한다. 파이어스톰은 먼저 격자를 2L × 2L 크기의 부분 격자로 나눈다. 그 후, 모든 부분 격자를 시계 방향으로 90도 회전시킨다. 이후 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다. (r, c)와 인접한 칸은 (r-1, c), (r+1, c), (r, c-1), (r, c+1)이다. 아래 그림의 칸에 적힌 정수는 칸을 구분하기 위해 적은 정수이다.


마법을 시전하기 전	L = 1	L = 2
마법사 상어는 파이어스톰을 총 Q번 시전하려고 한다. 모든 파이어스톰을 시전한 후, 다음 2가지를 구해보자.

남아있는 얼음 A[r][c]의 합
남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
얼음이 있는 칸이 얼음이 있는 칸과 인접해 있으면, 두 칸을 연결되어 있다고 한다. 덩어리는 연결된 칸의 집합이다.

입력
첫째 줄에 N과 Q가 주어진다. 둘째 줄부터 2N개의 줄에는 격자의 각 칸에 있는 얼음의 양이 주어진다. r번째 줄에서 c번째 주어지는 정수는 A[r][c] 이다.

마지막 줄에는 마법사 상어가 시전한 단계 L1, L2, ..., LQ가 순서대로 주어진다.

출력
첫째 줄에 남아있는 얼음 A[r][c]의 합을 출력하고, 둘째 줄에 가장 큰 덩어리가 차지하는 칸의 개수를 출력한다. 단, 덩어리가 없으면 0을 출력한다.

*/