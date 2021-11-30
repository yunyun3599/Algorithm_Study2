#include<stdio.h>

int R, C;
char arr[21][21];
int num[21][21];
int visit[27];
int max = 0;

void recur(int x, int y) {
	if (x > R || x<1 || y > C || y < 1) return;
	visit[arr[x][y] - 'A' + 1] = 1;
	if (max < num[x][y]) {
		max = num[x][y];
	}
	if (visit[arr[x][y + 1] - 'A' + 1] != 1) {
		num[x][y + 1] = num[x][y] + 1;
		recur(x, y + 1);
		visit[arr[x][y + 1] - 'A' + 1] = 0;
	}
	if (visit[arr[x + 1][y] - 'A' + 1] != 1) {
		num[x + 1][y] = num[x][y] + 1;
		recur(x + 1, y);
		visit[arr[x + 1][y] - 'A' + 1] = 0;
	}
	if (visit[arr[x][y-1] - 'A' + 1] != 1) {
		num[x ][y-1] = num[x][y] + 1;
		recur(x , y-1);
		visit[arr[x][y-1] - 'A' + 1] = 0;
	}
	if (visit[arr[x - 1][y] - 'A' + 1] != 1) {
		num[x - 1][y] = num[x][y] + 1;
		recur(x - 1, y);
		visit[arr[x - 1][y] - 'A' + 1] = 0;
	}
}

int main() {
	scanf("%d%d", &R, &C);
	for (int i = 1; i <= R; i++) {
		for (int j = 1; j <= C; j++) {
			scanf(" %c", &arr[i][j]);
		}
	}
	num[1][1] = 1;
	int visit[27];
	recur(1, 1);
	printf("%d\n", max);
}

/*
1987. 알파벳
https://www.acmicpc.net/problem/1987

문제
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.

입력
첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.

출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.

*/