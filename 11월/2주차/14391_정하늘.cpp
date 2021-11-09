﻿#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;

int paper[5][5];
bool check[5][5] = { false, };
int n, m;
int ans = 0;


int main() {

	scanf("%d%d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			char c;
			scanf(" %c", &c);
			paper[i][j] = c - '0';
		}
	}

	for (int k = 0; k < (1 << (n*m)); k++) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int now = 0;
			for (int j = 0; j < m; j++) {
				int idx = i * m + j;         
				if ((k & (1 << idx)) == 0) {
					now = now * 10 + paper[i][j];
				}
				else {
					sum += now;
					now = 0;
				}
			}
			sum += now;
		}//가로로 자름
		for (int j = 0; j < m; j++) {
			int now = 0;
			for (int i = 0; i < n; i++) {
				int idx = i * m + j;
				if ((k & (1 << idx)) != 0) {
					now = now * 10 + paper[i][j];
				}
				else {
					sum += now;
					now = 0;
				}
			}
			sum += now;
		}//세로로 자름
		if (ans < sum) ans = sum;
	}
	printf("%d\n", ans);
}

/*
14391. 종이 조각
https://www.acmicpc.net/problem/14391

문제
영선이는 숫자가 쓰여 있는 직사각형 종이를 가지고 있다. 종이는 1×1 크기의 정사각형 칸으로 나누어져 있고, 숫자는 각 칸에 하나씩 쓰여 있다. 행은 위에서부터 아래까지 번호가 매겨져 있고, 열은 왼쪽부터 오른쪽까지 번호가 매겨져 있다.

영선이는 직사각형을 겹치지 않는 조각으로 자르려고 한다. 각 조각은 크기가 세로나 가로 크기가 1인 직사각형 모양이다. 길이가 N인 조각은 N자리 수로 나타낼 수 있다. 가로 조각은 왼쪽부터 오른쪽까지 수를 이어 붙인 것이고, 세로 조각은 위에서부터 아래까지 수를 이어붙인 것이다.

아래 그림은 4×4 크기의 종이를 자른 한 가지 방법이다.



각 조각의 합은 493 + 7160 + 23 + 58 + 9 + 45 + 91 = 7879 이다.

종이를 적절히 잘라서 조각의 합을 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 종이 조각의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 4)

둘째 줄부터 종이 조각이 주어진다. 각 칸에 쓰여 있는 숫자는 0부터 9까지 중 하나이다.

출력
영선이가 얻을 수 있는 점수의 최댓값을 출력한다.
*/