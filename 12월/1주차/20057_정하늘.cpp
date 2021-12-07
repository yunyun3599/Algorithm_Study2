#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;

int n, answer = 0;
int map[501][501] = { 0, };

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

// 1 1 7 7 10 10 2 2 5 순서
int xdx[4][10] = { { -1, 1, -1, 1, -1, 1, -2, 2, 0, 0 },{ -1, 1, -1, 1, -1, 1, -2, 2, 0, 0 },
				  { 0, 0, 1, 1, 2, 2, 1, 1, 3, 2}, { 0, 0, -1, -1, -2, -2, -1, -1, -3, -2} };
int ydy[4][10] = { { 0, 0, 1, 1, 2, 2, 1, 1, 3, 2}, { 0, 0, -1, -1, -2, -2, -1, -1, -3, -2},
				  { -1, 1, -1, 1, -1, 1, -2, 2, 0, 0}, {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0} };
int Percent[9] = { 1, 1, 7, 7, 10, 10, 2, 2, 5 };
int direction[4] = { 3,2,0,1 };


void spread(int x, int y, int dir) {
	//x->y로 이동하는 칸의 좌표
	int xx = x + dx[dir];
	int yy = y + dy[dir];
	if (map[xx][yy] == 0) return;
	
	int sand = map[xx][yy];
	int temp = sand;
	for (int i = 0; i < 10; i++) {
		int nx = x + xdx[dir][i];
		int ny = y + ydy[dir][i];
		int p = Percent[i];
		int plus = (temp*p) / 100;

		if (nx<1 || ny<1 || nx>n || ny>n) answer += plus;//밖으로 나간 모래
		else map[nx][ny] += plus;//다음 칸으로 이동한 모래

		sand -= plus;
	}

	//a로 이동하는 모래
	int nx = x + xdx[dir][9];
	int ny = y + ydy[dir][9];

	if (nx<1 || ny<1 || nx>n || ny>n) answer += sand;
	else map[nx][ny] += sand;
	map[xx][yy] = 0;
}

int main() {
	scanf("%d", &n);


	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			scanf("%d", &map[i][j]);
		}
	}

	int x = (n + 1) / 2;
	int y = (n + 1) / 2;
	int dir = 1;
	int move = 1;

	while (1) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < move; j++) {
				spread(x, y, dir);
				x += dx[dir];
				y += dy[dir];
			}//토네이도가 중심에서부터 2->3->4..로 2번씩 이동함
			dir = direction[dir];
		}

		move++;
		if (move == n) {//토네이도 소멸 시
			for (int j = 0; j < move; j++) {
				spread(x, y, dir);
				x += dx[dir];
				y += dy[dir];
			}
			break;
		}
	}

	printf("%d\n", answer);

}


/*
20057. 마법사 상어와 토네이도
https://www.acmicpc.net/problem/20057

문제
마법사 상어가 토네이도를 배웠고, 오늘은 토네이도를 크기가 N×N인 격자로 나누어진 모래밭에서 연습하려고 한다. 위치 (r, c)는 격자의 r행 c열을 의미하고, A[r][c]는 (r, c)에 있는 모래의 양을 의미한다.

토네이도를 시전하면 격자의 가운데 칸부터 토네이도의 이동이 시작된다. 토네이도는 한 번에 한 칸 이동한다. 다음은 N = 7인 경우 토네이도의 이동이다.



토네이도가 한 칸 이동할 때마다 모래는 다음과 같이 일정한 비율로 흩날리게 된다.



토네이도가 x에서 y로 이동하면, y의 모든 모래가 비율과 α가 적혀있는 칸으로 이동한다. 비율이 적혀있는 칸으로 이동하는 모래의 양은 y에 있는 모래의 해당 비율만큼이고, 계산에서 소수점 아래는 버린다. α로 이동하는 모래의 양은 비율이 적혀있는 칸으로 이동하지 않은 남은 모래의 양과 같다. 모래가 이미 있는 칸으로 모래가 이동하면, 모래의 양은 더해진다. 위의 그림은 토네이도가 왼쪽으로 이동할 때이고, 다른 방향으로 이동하는 경우는 위의 그림을 해당 방향으로 회전하면 된다.

토네이도는 (1, 1)까지 이동한 뒤 소멸한다. 모래가 격자의 밖으로 이동할 수도 있다. 토네이도가 소멸되었을 때, 격자의 밖으로 나간 모래의 양을 구해보자.

입력
첫째 줄에 격자의 크기 N이 주어진다. 둘째 줄부터 N개의 줄에는 격자의 각 칸에 있는 모래가 주어진다. r번째 줄에서 c번째 주어지는 정수는 A[r][c] 이다.

출력
격자의 밖으로 나간 모래의 양을 출력한다.
*/