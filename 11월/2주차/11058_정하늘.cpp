#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;


int main() {
	int n;
	scanf("%d", &n);

	int ans = 0;
	long long dp[101];

	for (int i = 0; i < 6; i++) {
		dp[i] = i;
	}

	for (int i = 6; i <= n; i++) {
		dp[i] = max({ dp[i - 1] + 1, dp[i - 3] * 2, dp[i - 4] * 3, dp[i - 5] * 4 });
		//A만 누르는 경우
		//3칸 전 값 전체 복사 붙여넣기
		//4칸 전 값 전체 복사 붙여넣기 붙여넣기
		//5칸 전 값 전체 복사 붙여넣기 붙여넣기 붙여넣기
	}

	printf("%lld\n", dp[n]);
}

/*
11058. 크리보드
https://www.acmicpc.net/problem/11058

문제
크리보드는 kriii가 만든 신기한 키보드이다. 크리보드에는 버튼이 4개만 있으며, 하는 역할은 다음과 같다.

화면에 A를 출력한다.
Ctrl-A: 화면을 전체 선택한다
Ctrl-C: 전체 선택한 내용을 버퍼에 복사한다
Ctrl-V: 버퍼가 비어있지 않은 경우에는 화면에 출력된 문자열의 바로 뒤에 버퍼의 내용을 붙여넣는다.
크리보드의 버튼을 총 N번 눌러서 화면에 출력된 A개수를 최대로하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
크리보드의 버튼을 총 N번 눌러서 화면에 출력할 수 있는 A 개수의 최댓값을 출력한다.
*/