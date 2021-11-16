﻿#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
double percentage[4];//동 서 남 북
int n;
int visit[100][100];
double ans;

void DFS(int x, int y, int depth, double percent) {
	if (depth == n) {
		ans += percent;
		return;
	}

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (visit[nx][ny] == 0) {
			visit[nx][ny] = 1;
			DFS(nx, ny, depth + 1, percent*percentage[i]);
			visit[nx][ny] = 0;
		}
	}
	
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < 4; i++) {
		int percent;
		scanf("%d", &percent);
		percentage[i] = percent / 100.0;
	}
	
	visit[50][50] = 1;
	DFS(50, 50, 0, 1);

	printf("%.10lf\n", ans);
}

/*
1405. 미친 로봇
https://www.acmicpc.net/problem/1405

문제
통제 할 수 없는 미친 로봇이 평면위에 있다. 그리고 이 로봇은 N번의 행동을 취할 것이다.

각 행동에서 로봇은 4개의 방향 중에 하나를 임의로 선택한다. 그리고 그 방향으로 한 칸 이동한다.

로봇이 같은 곳을 한 번보다 많이 이동하지 않을 때, 로봇의 이동 경로가 단순하다고 한다. (로봇이 시작하는 위치가 처음 방문한 곳이다.) 로봇의 이동 경로가 단순할 확률을 구하는 프로그램을 작성하시오. 예를 들어, EENE와 ENW는 단순하지만, ENWS와 WWWWSNE는 단순하지 않다. (E는 동, W는 서, N은 북, S는 남)

입력
첫째 줄에 N, 동쪽으로 이동할 확률, 서쪽으로 이동할 확률, 남쪽으로 이동할 확률, 북쪽으로 이동할 확률이 주어진다. N은 14보다 작거나 같은 자연수이고,  모든 확률은 100보다 작거나 같은 자연수 또는 0이다. 그리고, 동서남북으로 이동할 확률을 모두 더하면 100이다.

확률의 단위는 %이다.

출력
첫째 줄에 로봇의 이동 경로가 단순할 확률을 출력한다. 절대/상대 오차는 10-9 까지 허용한다.
*/