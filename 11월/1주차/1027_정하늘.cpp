#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>


using namespace std;

int getMax(int a, int b) {
	return a > b ? a : b;
}

int main() {
	int n;
	scanf("%d", &n);
	double buildings[51];
	for (int i = 1; i <= n; i++) {
		scanf("%lf", &buildings[i]);
	}
	int ans = 0;
	for (int i = 1; i <= n; i++) {			
		int cnt = 0;

		double max_ = 1000000000;
		for (int j = i - 1; j > 0; j--) {
			double gradient = (buildings[i] - buildings[j]) / ((double)i - (double)j);
			if (gradient < max_) {
				max_ = gradient;
				cnt++;
			}
		}//왼쪽 방향, 지금까지 왔던 기울기보다 작으면(완만하면) 보임

		double min_ = -1000000000;
		for (int j = i + 1; j <= n; j++) {
			double gradient = (buildings[j] - buildings[i]) / ((double)j - (double)i);
			if (gradient > min_) {
				min_ = gradient;
				cnt++;
			}
		}//오른쪽 방향, 기울기가 크면 보임

		ans = getMax(ans, cnt);
	}
	printf("%d\n", ans);
}

/*
1027. 고층 건물
https://www.acmicpc.net/problem/1027

문제
세준시에는 고층 빌딩이 많다. 세준시의 서민 김지민은 가장 많은 고층 빌딩이 보이는 고층 빌딩을 찾으려고 한다. 빌딩은 총 N개가 있는데, 빌딩은 선분으로 나타낸다. i번째 빌딩 (1부터 시작)은 (i,0)부터 (i,높이)의 선분으로 나타낼 수 있다. 고층 빌딩 A에서 다른 고층 빌딩 B가 볼 수 있는 빌딩이 되려면, 두 지붕을 잇는 선분이 A와 B를 제외한 다른 고층 빌딩을 지나거나 접하지 않아야 한다. 가장 많은 고층 빌딩이 보이는 빌딩을 구하고, 거기서 보이는 빌딩의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 빌딩의 수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에 1번 빌딩부터 그 높이가 주어진다. 높이는 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 문제의 정답을 출력한다.
*/