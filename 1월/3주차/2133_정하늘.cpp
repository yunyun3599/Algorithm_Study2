#include<stdio.h>

int main() {
	int n;
	scanf("%d", &n);
	int dp[31] = { 0, };
	dp[0] = 1;
	dp[2] = 3;
	for (int i = 4; i <= n; i+=2) {
		dp[i] += dp[i - 2] * 3; //2일때 3가지
		for (int j = 4; j <= i; j += 2) {
			dp[i] += dp[i - j] * 2;//4,6,8... 2가지
		}
	}
	printf("%d\n", dp[n]);
}

/*
2133. 타일 채우기
https://www.acmicpc.net/problem/2133

문제
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.

출력
첫째 줄에 경우의 수를 출력한다.

*/