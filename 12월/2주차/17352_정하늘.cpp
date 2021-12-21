﻿#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<set>
#include<string>


using namespace std;

int n;
int _set[1000001];

int find(int x) {
	if (_set[x] == x) return x;
	return _set[x] = find(_set[x]);
}


void Union(int x, int y) {
	x = find(x);
	y = find(y);

	_set[y] = x;
}

bool isUnion(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y)
		return true;
	return false;
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		_set[i] = i;
	}

	for (int i = 0; i < n-2; i++) {
		int x, y;
		scanf("%d%d", &x, &y);
		Union(x, y);
	}

	for (int i = 2; i <= n; i++) {
		if (!isUnion(1, i)) {
			printf("1 %d\n", i);
			break;
		}
	}
}


/*
17352. 여러분의 다리가 되어 드리겠습니다! 
https://www.acmicpc.net/problem/17352

문제
선린월드에는 N개의 섬이 있다. 섬에는 1, 2, ..., N의 번호가 하나씩 붙어 있다. 그 섬들을 N - 1개의 다리가 잇고 있으며, 어떤 두 섬 사이든 다리로 왕복할 수 있다.

어제까지는 그랬다.

"왜 다리가 N - 1개밖에 없냐, 통행하기 불편하다"며 선린월드에 불만을 갖던 욱제가 다리 하나를 무너뜨렸다! 안 그래도 불편한 통행이 더 불편해졌다. 서로 왕복할 수 없는 섬들이 생겼기 때문이다. 일단 급한 대로 정부는 선린월드의 건축가를 고용해, 서로 다른 두 섬을 다리로 이어서 다시 어떤 두 섬 사이든 왕복할 수 있게 하라는 지시를 내렸다.

그런데 그 건축가가 당신이다! 안 그래도 천하제일 코딩대회에 참가하느라 바쁜데...

입력
첫 줄에 정수 N이 주어진다. (2 ≤ N ≤ 300,000)

그 다음 N - 2개의 줄에는 욱제가 무너뜨리지 않은 다리들이 잇는 두 섬의 번호가 주어진다.

출력
다리로 이을 두 섬의 번호를 출력한다. 여러 가지 방법이 있을 경우 그 중 아무거나 한 방법만 출력한다.
*/