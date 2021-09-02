﻿#include <iostream>
#include <algorithm>
#include <stdio.h>
#include <string>
#include <vector>
#include <cstring>

using namespace std;

int n, o1, o2, len;
int door[21] = { 0, };
int dp[21][21][21];


int getMin(int x, int y) {
	return x > y ? y : x;
}

int recur(int open1, int open2, int cnt) {
	if (cnt == len) {
		return 0;
	}
	int ret = dp[open1][open2][cnt];
	if (ret != -1) return ret;

	ret = getMin(abs(door[cnt] - open1) + recur(door[cnt], open2, cnt + 1), abs(door[cnt] - open2) + recur(open1, door[cnt], cnt + 1));//1번 문 이동 vs 2번 문 이동
	return ret;

}

int main() {
	scanf("%d", &n);
	scanf("%d%d", &o1, &o2);
	scanf("%d", &len);

	for (int i = 0; i < len; i++) {
		int use;
		scanf("%d", &use);
		door[i] = use;
	}
	memset(dp, -1, sizeof(dp));

	printf("%d\n", recur(o1, o2, 0));
}


/*
2666. 벽장문의 이동
https://www.acmicpc.net/problem/2666

문제
n개의 같은 크기의 벽장들이 일렬로 붙어져 있고 벽장의 문은 n-2개만이 있다. 한 벽장 앞에 있는 문은 이웃 벽장 앞에 문이 없다면(즉, 벽장이 열려있다면) 그 벽장 앞으로 움직일 수 있다.

그림은 7개의 벽장의 예이다. 그림에서 2번 벽장과 5번 벽장이 열려있고, 나머지 벽장은 닫혀 있다.  벽장 문은 좌우 어느 쪽이든 그 이웃 벽장이 열려 있다면 그 쪽으로 한 칸씩 이동할 수 있다. 그림에서 주어진 상태에서는 1번 벽장을 닫고 있는 벽장문을 오른쪽으로 한 칸 이동함으로써 1번 벽장을 사용할 수 있다. 이때 2번 벽장은 닫혀져 사용할 수 없다. 역시 5번 벽장이 열려 있으므로 4번 벽장 또는 6번 벽장 앞의 벽장문을 5번 벽장 앞으로 이동시킬 수 있다.



풀어야 할 문제는 입력으로 주어지는 사용할 벽장의 순서에 따라서 벽장문을 이동하는 순서를 찾는 것이다. 이때 벽장문의 이동횟수를 최소로 하여야 한다. 입력은 다음과 같이 주어지며, 열려있는 벽장의 개수는 항상 2개이다.

예를 들어 사용할 벽장 순서가 3 1 6 5이면, 3번 앞의 문을 2번으로 옮겨서 3번 벽장을 사용하고(문 이동횟수=1), 다음에 1번과 2번 앞에 있는 문을 오른쪽으로 하나씩 옮겨서(문 이동횟수=2) 1번 벽장을 사용하며, 6번 앞에 있는 문을 왼쪽으로 옮겨서 6번 벽장을 사용하고(문 이동횟수=1), 다시 그 문을 오른쪽으로 옮겨서 5번 벽장을 사용한다(문 이동횟수=1), 따라서 문이 이동한 횟수의 합은 5이다.

입력
첫 번째 줄에 벽장의 개수를 나타내는 3보다 크고 20보다 작거나 같은 하나의 정수, 두 번째 줄에 초기에 열려있는 두 개의 벽장을 나타내는 두 개의 정수, 그리고 세 번째 줄에는 사용할 벽장들의 순서의 길이(최대 20), 그리고 그 다음줄부터 사용할 벽장의 번호가 한줄에 하나씩 순서대로 주어진다.

출력
벽장문의 최소 이동횟수를 화면에 출력한다.
*/