﻿#include<stdio.h>
#include<vector>
#include<queue>
#include<string.h>
#define INF 19999999

using namespace std;

int n, m;
int max = 0;
long long ans = 0;
int max_cost = 0;

vector< pair<int,int> > house[100001]; //cost, dst
priority_queue < pair<int, int>, vector< pair<int, int> >, greater< pair<int, int> > > dist;
int visit[100001] = { 0, };//포함된 정점 체크

void add_edge(int node) {
	for (auto edge : house[node]) {
		dist.push(edge);
	}
}

long long prim(int v) {
	dist.push({ 0, 1 });
	for (int i = 1; i <= v; i++) {
		int now = -1, min_dist = INF;
		while (!dist.empty()) {
			now = dist.top().second;
			if (!visit[now]) {
				min_dist = dist.top().first;
				break;
			}
			dist.pop();
		}
		ans += min_dist;
		if (max_cost < min_dist) max_cost = min_dist;
		visit[now] = 1;
		add_edge(now);
	}
	return ans;
}


int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < m; i++) {
		int A, B, cost;
		scanf("%d%d%d", &A, &B, &cost);
		house[A].push_back({ cost,B });
		house[B].push_back({ cost,A });
	}

	printf("%lld\n", prim(n) - max_cost);
}

/*
1647. 도시 분할 계획
https://www.acmicpc.net/problem/1647

문제
동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 그러다가 평화로운 마을에 가게 되었는데, 그곳에서는 알 수 없는 일이 벌어지고 있었다.

마을은 N개의 집과 그 집들을 연결하는 M개의 길로 이루어져 있다. 길은 어느 방향으로든지 다닐 수 있는 편리한 길이다. 그리고 각 길마다 길을 유지하는데 드는 유지비가 있다.

마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다. 마을이 너무 커서 혼자서는 관리할 수 없기 때문이다. 마을을 분할할 때는 각 분리된 마을 안에 집들이 서로 연결되도록 분할해야 한다. 각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 한다는 뜻이다. 마을에는 집이 하나 이상 있어야 한다.

그렇게 마을의 이장은 계획을 세우다가 마을 안에 길이 너무 많다는 생각을 하게 되었다. 일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다. 그리고 각 분리된 마을 안에서도 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다. 마을의 이장은 위 조건을 만족하도록 길들을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다. 이것을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수N, 길의 개수M이 주어진다. N은 2이상 100,000이하인 정수이고, M은 1이상 1,000,000이하인 정수이다. 그 다음 줄부터 M줄에 걸쳐 길의 정보가 A B C 세 개의 정수로 주어지는데 A번 집과 B번 집을 연결하는 길의 유지비가 C (1 ≤ C ≤ 1,000)라는 뜻이다.

출력
첫째 줄에 없애고 남은 길 유지비의 합의 최솟값을 출력한다.

우선순위큐로 구현해야 시간초과 안났음
*/