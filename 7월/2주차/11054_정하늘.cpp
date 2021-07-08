#include<stdio.h>
#include<malloc.h>

int main() {
	int n;
	scanf("%d", &n);
	int *data = (int *)malloc(sizeof(int)*n);
	int *dp = (int *)malloc(sizeof(int)*n);
	int *dpinc = (int *)malloc(sizeof(int)*n);
	int *dpdec = (int *)malloc(sizeof(int)*n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &data[i]);
		dp[i] = 1;
		dpinc[i] = 1;
		dpdec[i] = 1;
	}
	//init
	int max = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i; j++) {
			if (data[i] > data[j] && dpinc[j] + 1 > dpinc[i])
				dpinc[i] = dpinc[j] + 1;
		}
	}
	for (int i = n - 1; i >= 0; i--) {
		for (int j = n - 1; j > i; j--) {
			if (data[i] > data[j] && dpdec[j] + 1 > dpdec[i])
				dpdec[i] = dpdec[j] + 1;
		}
	}
	for (int i = 0; i < n; i++) {
		dp[i] = dpinc[i] + dpdec[i];
		if (max < dp[i]) max = dp[i];
	}
	printf("%d\n", max - 1);
}

/*
11054. 가장 긴 바이토닉 부분 수열
https://www.acmicpc.net/problem/11054

문제
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.

최장증가수열 + 최장감소수열 -1
*/
