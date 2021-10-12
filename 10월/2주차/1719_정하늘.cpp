#include<stdio.h>

#define INF 123456789

using namespace std;

int n, m;
int dist[201][201];
int passThrough[201][201];

void FloydWarshall() {
	for (int k = 1; k <= n; k++) {//거쳐가는 정점
		for (int i = 1; i <= n; i++) {//출발
			for (int j = 1; j <= n; j++) {//도착
				if (dist[i][k] + dist[k][j] < dist[i][j]) {
					dist[i][j] = dist[i][k] + dist[k][j];
					passThrough[i][j] = passThrough[i][k];
				}
			}
		}
	}
}

int main() {

	scanf("%d%d", &n, &m);

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j) dist[i][j] = 0;
			else dist[i][j] = INF;
		}
	}

	for (int i = 0; i < m; i++) {
		int x, y, d;
		scanf("%d%d%d", &x, &y, &d);
		dist[x][y] = d;
		dist[y][x] = d;
		passThrough[x][y] = y;
		passThrough[y][x] = x;
	}

	FloydWarshall();

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j) printf("- ");
			else printf("%d ", passThrough[i][j]);
		}
		printf("\n");
	}
}

/*
1719. 택배
https://www.acmicpc.net/problem/1719

문제
명우기업은 2008년부터 택배 사업을 새로이 시작하기로 하였다. 우선 택배 화물을 모아서 처리하는 집하장을 몇 개 마련했지만, 택배 화물이 각 집하장들 사이를 오갈 때 어떤 경로를 거쳐야 하는지 결정하지 못했다. 어떤 경로를 거칠지 정해서, 이를 경로표로 정리하는 것이 여러분이 할 일이다.



예시된 그래프에서 굵게 표시된 1, 2, 3, 4, 5, 6은 집하장을 나타낸다. 정점간의 간선은 두 집하장간에 화물 이동이 가능함을 나타내며, 가중치는 이동에 걸리는 시간이다. 이로부터 얻어내야 하는 경로표는 다음과 같다.



경로표는 한 집하장에서 다른 집하장으로 최단경로로 화물을 이동시키기 위해 가장 먼저 거쳐야 하는 집하장을 나타낸 것이다. 예를 들어 4행 5열의 6은 4번 집하장에서 5번 집하장으로 최단 경로를 통해 가기 위해서는 제일 먼저 6번 집하장으로 이동해야 한다는 의미이다.

이와 같은 경로표를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 두 수 n과 m이 빈 칸을 사이에 두고 순서대로 주어진다. n은 집하장의 개수로 200이하의 자연수, m은 집하장간 경로의 개수로 10000이하의 자연수이다. 이어서 한 줄에 하나씩 집하장간 경로가 주어지는데, 두 집하장의 번호와 그 사이를 오가는데 필요한 시간이 순서대로 주어진다. 집하장의 번호들과 경로의 소요시간은 모두 1000이하의 자연수이다.

출력
예시된 것과 같은 형식의 경로표를 출력한다.
*/