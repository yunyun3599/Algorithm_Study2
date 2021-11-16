#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;

bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first) {
		return a.second > b.second;
	}
	else {
		return a.first > b.first;
	}
}

int main() {
	int n;
	scanf("%d", &n);
	vector<pair<int, int>> line;
	for (int i = 0; i < n; i++) {
		int x, y;
		scanf("%d%d", &x, &y);
		line.push_back({ x,y });
	}
	sort(line.begin(), line.end());

	int length = 0;
	int start = 0;
	int end = 0;
	int covered = -1234567890;

	for (int i = 0; i < n; i++) {
		if (covered < line[i].first) {
			length += line[i].second - line[i].first;
			covered = line[i].second;
		}
		else if (covered < line[i].second) {
			length += line[i].second - covered;
			covered = line[i].second;
		}
	}
	printf("%d\n", length);
}

/*
2170. 선 긋기
https://www.acmicpc.net/problem/2170

문제
매우 큰 도화지에 자를 대고 선을 그으려고 한다. 선을 그을 때에는 자의 한 점에서 다른 한 점까지 긋게 된다. 선을 그을 때에는 이미 선이 있는 위치에 겹쳐서 그릴 수도 있는데, 여러 번 그은 곳과 한 번 그은 곳의 차이를 구별할 수 없다고 하자.

이와 같은 식으로 선을 그었을 때, 그려진 선(들)의 총 길이를 구하는 프로그램을 작성하시오. 선이 여러 번 그려진 곳은 한 번씩만 계산한다.

입력
첫째 줄에 선을 그은 횟수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 다음 N개의 줄에는 선을 그을 때 선택한 두 점의 위치 x, y(-1,000,000,000 ≤ x < y ≤ 1,000,000,000)가 주어진다.

출력
첫째 줄에 그은 선의 총 길이를 출력한다.
*/