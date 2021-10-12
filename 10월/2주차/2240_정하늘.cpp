#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<iostream>
#include<string>


using namespace std;

int getMax(int x, int y) {
	return x > y ? x : y;
}

int main() {
	int t, w;
	scanf("%d%d", &t, &w);
	int Tree1[1001];
	int Tree2[1001];
	for (int i = 1; i <= t; i++) {
		int jadu;
		scanf("%d", &jadu);
		if (jadu == 1) Tree1[i] = 1;
		else Tree2[i] = 1;
	}
	int dp[3][31][1001] = { 0, };//dp[i] = i초에 자두가 받을 수 있는 자두의 최대 개수, 이동 횟수도 점검해줘야 함. 2차원 배열, dp[30][1001], ex) dp[4][40] : 40초까지 4번 움직이고 얻을 수 있는 최대 자두 개수

	for (int j = 0; j <= w; j++) {
		for (int i = 1; i <= t; i++) {
			if (j == 0) {
				dp[1][j][i] = dp[1][j][i - 1] + Tree1[i];
			}
			else {
				dp[1][j][i] = getMax(dp[1][j][i - 1] + Tree1[i], dp[2][j - 1][i - 1] + Tree1[i]);
				dp[2][j][i] = getMax(dp[2][j][i - 1] + Tree2[i], dp[1][j - 1][i - 1] + Tree2[i]);
			}
		}
	}
	
	int ans = 0;
	for (int i = 1; i <= 2; i++) {
		for (int j = 0; j <= w; j++) {
			ans = getMax(dp[i][j][t], ans);
		}
	}
	printf("%d\n", ans);
}

/*
2240. 자두나무
https://www.acmicpc.net/problem/2240

문제
자두는 자두를 좋아한다. 그래서 집에 자두나무를 심어두고, 여기서 열리는 자두를 먹고는 한다. 하지만 자두는 키가 작아서 자두를 따먹지는 못하고, 자두가 떨어질 때까지 기다린 다음에 떨어지는 자두를 받아서 먹고는 한다. 자두를 잡을 때에는 자두가 허공에 있을 때 잡아야 하는데, 이는 자두가 말랑말랑하여 바닥에 떨어지면 못 먹을 정도로 뭉개지기 때문이다.

매 초마다, 두 개의 나무 중 하나의 나무에서 열매가 떨어지게 된다. 만약 열매가 떨어지는 순간, 자두가 그 나무의 아래에 서 있으면 자두는 그 열매를 받아먹을 수 있다. 두 개의 나무는 그다지 멀리 떨어져 있지 않기 때문에, 자두는 하나의 나무 아래에 서 있다가 다른 나무 아래로 빠르게(1초보다 훨씬 짧은 시간에) 움직일 수 있다. 하지만 자두는 체력이 그다지 좋지 못해서 많이 움직일 수는 없다.

자두는 T(1≤T≤1,000)초 동안 떨어지게 된다. 자두는 최대 W(1≤W≤30)번만 움직이고 싶어 한다. 매 초마다 어느 나무에서 자두가 떨어질지에 대한 정보가 주어졌을 때, 자두가 받을 수 있는 자두의 개수를 구해내는 프로그램을 작성하시오. 자두는 1번 자두나무 아래에 위치해 있다고 한다.

입력
첫째 줄에 두 정수 T, W가 주어진다. 다음 T개의 줄에는 각 순간에 자두가 떨어지는 나무의 번호가 1 또는 2로 주어진다.

출력
첫째 줄에 자두가 받을 수 있는 자두의 최대 개수를 출력한다.
*/