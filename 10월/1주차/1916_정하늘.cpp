﻿#include<stdio.h>
#include<queue>
#include<vector>

#define INF 100000000

using namespace std;

int n, m, src, dst;

vector<pair<int, int>> vert[1010];//인접행렬
int dist[1010];


void Dijkstra(int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push(make_pair(0, start));//dist, 시작정점
	dist[start] = 0;

	while (!pq.empty()) {
		int cost = pq.top().first;
		int x = pq.top().second;
		pq.pop();
		if (dist[x] < cost) continue;
		for (int i = 0; i < vert[x].size(); i++) {//x에 연결된 모든 정점들에 대해 거리배열 갱신
			int nx = vert[x][i].second;//x에 연결된 다음 정점
			int nd = vert[x][i].first;//다음 정점까지의 거리
			if (cost + nd < dist[nx]) {
				dist[nx] = cost + nd;
				pq.push(make_pair(cost + nd, nx));
			}//dist에 저장된 값보다 작은 경우 최솟값으로 변경
		}
	}
}

int main() {
	scanf("%d%d", &n, &m);
	
	for (int i = 1; i <= m; i++) {
		int x, y, d;
		scanf("%d%d%d", &x, &y, &d);
		vert[x].push_back(make_pair(d, y));
	}
	
	scanf("%d%d", &src, &dst);
	for (int i = 1; i <= n; i++) {
		dist[i] = INF;
	}
	Dijkstra(src);

	printf("%d\n", dist[dst]);
}

/*
1916. 최소비용 구하기
https://www.acmicpc.net/problem/1916

문제
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.

입력
첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
*/