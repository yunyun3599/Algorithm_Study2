#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<queue>


using namespace std;


char arr[3072][6143];


void draw(int row, int col) {
	//첫번째 줄
	arr[row][col] = '*';

	//두번째 줄
	arr[row + 1][col - 1] = '*';
	arr[row + 1][col + 1] = '*';

	//세번째 줄
	for (int i = 0; i < 5; i++) {
		arr[row + 2][col - 2 + i] = '*';
	}
}


void recur(int len, int row, int col) {
	if (len == 3) {
		draw(row, col);
		return;
	}

	//세개의 삼각형의 꼭짓점을 인자로
	recur(len / 2, row, col);
	recur(len / 2, row + len / 2, col - len / 2);
	recur(len / 2, row + len / 2, col + len / 2);
}

int main() {

	//ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n;
	scanf("%d", &n);

	//배열 초기화
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2 * n - 1; j++) {
			arr[i][j] = ' ';
		}
	}

	recur(n, 0, n - 1);//가장 큰 삼각형부터

	//출력
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2 * n - 1; j++) {
			printf("%c", arr[i][j]);
		}
		printf("\n");
	}
}


/*
2448. 별 찍기 - 11
https://www.acmicpc.net/problem/2448

문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.
*/