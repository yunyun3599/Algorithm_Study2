﻿#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;

vector<long long> result;

void DFS(long long idx, int cnt) {
	if (cnt > 10) return;//범위 넘어감

	printf("%lld, %d\n", idx, cnt);

	result.push_back(idx);
	for (int i = 0; i < 10; i++) {
		if (idx % 10 > i) {
			DFS(idx * 10 + i, cnt + 1);
		}
	}
	return;
}

int main() {
	int n;
	scanf("%d", &n);
	
	for (int i = 0; i < 10; i++) {
		DFS(i, 1);
	}

	sort(result.begin(), result.end());

	printf("%d\n", result.size());
	if (result.size() <= n) {
		printf("-1\n");
	}
	else {
		printf("%lld\n", result[n]);
	}
}


/*
1038. 감소하는 수
https://www.acmicpc.net/problem/1038

문제
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.

입력
첫째 줄에 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 N번째 감소하는 수를 출력한다.
*/