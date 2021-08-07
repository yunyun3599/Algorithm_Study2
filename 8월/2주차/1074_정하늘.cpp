#include<stdio.h>

int N, r, c;
int size = 1;
int cnt = 0;
int flag = 0;

void recur(int col, int row, int width) {
	if ((col <= r && r < col + width) && (row <= c && c < row + width)) {
		if (col == r && row == c) flag = 1;
		for (int i = col; i < col+width; i += width / 2) {
			for (int j = row; j < row+width; j += width / 2) {
				if (flag == 1) return;
				recur(i, j, width / 2);
			}
		}
	}
	else {
		cnt += width * width;
	}
}

int main() {
	scanf("%d%d%d", &N, &r, &c);
	r += 1;
	c += 1;
	for (int i = 1; i <= N; i++)
		size *= 2;
	recur(1, 1, size);
	printf("%d\n", cnt);
}


/*
1074. Z 
https://www.acmicpc.net/problem/1074

문제
한수는 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다. 예를 들어, 2*2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.

만약, 2차원 배열의 크기가 2^N * 2^N라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 4등분 한 후에 (크기가 같은 2^(N-1)로) 재귀적으로 순서대로 방문한다.

다음 예는 2^2 * 2^2 크기의 배열을 방문한 순서이다.

N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음 그림은 N=3일 때의 예이다.

입력
첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다 작거나 같은 정수이다

출력
첫째 줄에 문제의 정답을 출력한다.

*/
