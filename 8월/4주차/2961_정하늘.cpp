#include<stdio.h>
#include<vector>
#include<iostream>
#include<string>
#include<math.h>


using namespace std;

int n;
int ans = 1234567890;
vector< pair< int, int> > ingredient;

void comb(int idx, long long sour, long long bitter) {
	if (abs(sour - bitter) < ans) {
		if (sour != 0 && bitter != 0) ans = abs(sour - bitter);
	}
	for (int i = idx + 1; i < n; i++) {
		comb(i, sour*ingredient[i].first, bitter + ingredient[i].second);//i번째를 포함
		comb(i, sour, bitter);//i번째를 미포함
	}
}

int main() {
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		int sour, bitter;
		scanf("%d%d", &sour, &bitter);
		ingredient.push_back({ sour,bitter });
	}

	for (int i = 0; i < n; i++) {
		comb(i, ingredient[i].first, ingredient[i].second);//i번째 포함부터 시작
	}

	printf("%d\n", ans);
}


/*
2961. 도영이가 만든 맛있는 음식
https://www.acmicpc.net/problem/2961

문제
도영이는 짜파구리 요리사로 명성을 날렸었다. 이번에는 이전에 없었던 새로운 요리에 도전을 해보려고 한다.

지금 도영이의 앞에는 재료가 N개 있다. 도영이는 각 재료의 신맛 S와 쓴맛 B를 알고 있다. 여러 재료를 이용해서 요리할 때, 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.

시거나 쓴 음식을 좋아하는 사람은 많지 않다. 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다. 또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.

재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.

입력
첫째 줄에 재료의 개수 N(1 ≤ N ≤ 10)이 주어진다. 다음 N개 줄에는 그 재료의 신맛과 쓴맛이 공백으로 구분되어 주어진다. 모든 재료를 사용해서 요리를 만들었을 때, 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다.

출력
첫째 줄에 신맛과 쓴맛의 차이가 가장 작은 요리의 차이를 출력한다.
*/