#include<stdio.h>
#include<vector>
#include<iostream>
#include<string>
#include<string.h>
#include<algorithm>
#include<queue>

using namespace std;



int main() {
	int t;
	scanf("%d", &t);
	while (t--) {
		int node;
		scanf("%d", &node);

		int parent[10001];
		for (int i = 1; i <= node; i++) {
			parent[i] = i;
		}
		int visit[10001] = { 0, };
		for (int i = 0; i < node - 1; i++) {
			int p, c;
			scanf("%d%d", &p, &c);
			parent[c] = p;
		}
		int n1, n2;//node 1, node 2
		scanf("%d%d", &n1, &n2);

		visit[n1] = 1;
		while (n1 != parent[n1]) {
			n1 = parent[n1];
			visit[n1] = 1;
		}//루트노드가 아닐때까지

		while (1) {
			if (visit[n2] == 1) {
				break;
			}
			n2 = parent[n2];
		}
		printf("%d\n", n2);
	}
}


/*
3584. 가장 가까운 공통 조상
https://www.acmicpc.net/problem/3584

문제
루트가 있는 트리(rooted tree)가 주어지고, 그 트리 상의 두 정점이 주어질 때 그들의 가장 가까운 공통 조상(Nearest Common Anscestor)은 다음과 같이 정의됩니다.

두 노드의 가장 가까운 공통 조상은, 두 노드를 모두 자손으로 가지면서 깊이가 가장 깊은(즉 두 노드에 가장 가까운) 노드를 말합니다.
nca.png

예를 들어  15와 11를 모두 자손으로 갖는 노드는 4와 8이 있지만, 그 중 깊이가 가장 깊은(15와 11에 가장 가까운) 노드는 4 이므로 가장 가까운 공통 조상은 4가 됩니다.

루트가 있는 트리가 주어지고, 두 노드가 주어질 때 그 두 노드의 가장 가까운 공통 조상을 찾는 프로그램을 작성하세요

입력
첫 줄에 테스트 케이스의 개수 T가 주어집니다.

각 테스트 케이스마다, 첫째 줄에 트리를 구성하는 노드의 수 N이 주어집니다. (2 ≤ N ≤ 10,000)

그리고 그 다음 N-1개의 줄에 트리를 구성하는 간선 정보가 주어집니다. 한 간선 당 한 줄에 두 개의 숫자 A B 가 순서대로 주어지는데, 이는 A가 B의 부모라는 뜻입니다. (당연히 정점이 N개인 트리는 항상 N-1개의 간선으로 이루어집니다!) A와 B는 1 이상 N 이하의 정수로 이름 붙여집니다.

테스트 케이스의 마지막 줄에 가장 가까운 공통 조상을 구할 두 노드가 주어집니다.

출력
각 테스트 케이스 별로, 첫 줄에 입력에서 주어진 두 노드의 가장 가까운 공통 조상을 출력합니다.

*/