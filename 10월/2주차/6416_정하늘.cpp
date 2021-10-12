#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>
#include<set>
#include<map>

using namespace std;

int u, v;

set<int> nodeSet;
vector <pair<int, int> > edges;

int hasNoCycle() {
	set<int> findRoot(nodeSet);
	map<int, int> visit;
	for (int i = 0; i < edges.size(); i++) {
		visit[edges[i].first] = 0;
		visit[edges[i].second] = 0;
		findRoot.erase(edges[i].second);
		//indegree가 없는 node를 찾아야함
	}
	int root = *findRoot.begin();

	queue<int> q;
	q.push(root);
	visit[root] = 1;

	while (!q.empty()) {
		int start = q.front();
		q.pop();
		int size = edges.size();
		for (int i = 0; i < size; i++) {
			if (edges[i].first == start) {
				if (visit[edges[i].second] > 0) {
					return 0;
				}//cycle 존재
				else {
					visit[edges[i].second]++;
					q.push(edges[i].second);
				}
			}
		}
	}//루트에서 시작해서 BFS, 이미 방문한 노드가 있는 경우 2, 3번 불충족

	for (auto it = visit.begin(); it != visit.end(); it++) {
		if (it->second == 0) return 0;
	}//모든 노드에 방문 가능해야함.
	return 1;
}

int isTree() {
	if ((edges.size() + 1 == nodeSet.size() || edges.size() == 0) && hasNoCycle()) {
		return 1;
	}//빈 Tree 또는 node  = edges+1
	else return 0;
}


int main() {
	int i = 1;

	while (1) {
		scanf("%d%d", &u, &v);
		if (u < 0 && v < 0) break;
		if (u == 0 && v == 0) {
			if (isTree()) printf("Case %d is a tree.\n", i);
			else printf("Case %d is not a tree.\n", i);
			i++;
			nodeSet.clear();
			edges.clear();
		}
		else {
			nodeSet.insert(u);
			nodeSet.insert(v);
			edges.push_back({ u,v });
		}
	}
}

/*
6416. 트리인가?
https://www.acmicpc.net/problem/6416

문제
트리는 굉장히 잘 알려진 자료 구조이다. 트리를 만족하는 자료 구조는 비어 있거나(노드의 개수가 0개), 노드의 개수가 1개 이상이고 방향 간선이 존재하며 다음과 같은 조건을 만족해야 한다. 이때, 노드 u에서 노드 v로 가는 간선이 존재하면 간선을 u에 대해서는 '나가는 간선', v에 대해서는 '들어오는 간선'이라고 하자.

들어오는 간선이 하나도 없는 단 하나의 노드가 존재한다. 이를 루트(root) 노드라고 부른다.
루트 노드를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재한다.
루트에서 다른 노드로 가는 경로는 반드시 가능하며, 유일하다. 이는 루트를 제외한 모든 노드에 성립해야 한다.
아래의 그림을 보자. 원은 노드, 화살표는 간선을 의미하며, 화살표의 방향이 노드 u에서 노드 v로 향하는 경우 이는 이 간선이 u에서 나가는 간선이며 v로 들어오는 간선이다. 3개의 그림 중 앞의 2개는 트리지만 뒤의 1개는 트리가 아니다.



당신은 간선의 정보들을 받아서 해당 케이스가 트리인지를 판별해야 한다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있으며, 입력의 끝에는 두 개의 음의 정수가 주어진다.

각 테스트 케이스는 여러 개의 정수쌍으로 이루어져 있으며, 테스트 케이스의 끝에는 두 개의 0이 주어진다.

각 정수쌍 u, v에 대해서 이는 노드 u에서 노드 v로 가는 간선이 존재함을 의미한다. u와 v는 0보다 크다.

출력
각 테스트 케이스에 대해서, 테스트 케이스의 번호가 k일 때(k는 1부터 시작하며, 1씩 증가한다) 트리일 경우 "Case k is a tree."를, 트리가 아닐 경우 "Case k is not a tree."를 출력한다.
*/