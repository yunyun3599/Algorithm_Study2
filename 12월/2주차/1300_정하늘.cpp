#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;



int main() {
	//ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	int n, k;
	scanf("%d%d", &n, &k);

	int low = 1, high = k;
	int ans = -1;

	while (low <= high) {
		int cnt = 0;
		int mid = (low + high) / 2;
		for (int i = 1; i <= n; i++) {
			cnt += min(mid / i, n);//mid보다 작은 j의 수(i * j <= mid)
		}
		if (cnt < k) low = mid + 1;
		else {
			ans = mid;
			high = mid - 1;
		}
	}
	printf("%d\n", ans);

}


/*
1300. K번째 수
https://www.acmicpc.net/problem/1300

문제
세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.

배열 A와 B의 인덱스는 1부터 시작한다.

입력
첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.

출력
B[k]를 출력한다.
*/