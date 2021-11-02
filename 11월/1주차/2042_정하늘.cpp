#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<math.h>


using namespace std;

//세그먼트 트리의 크기를 구할 때
//N * 4 하면 공간 낭비는 있지만 항상 큰 값이 나오게 됨.

vector<long long> arr;
vector<long long> segTree;
vector < pair<long long, pair<long long, long long> > > cmd;

long long makeSegTree(int node, int start, int end) {
	if (start == end) return segTree[node] = arr[start];//노드가 하나인 경우
	
	int mid = (start + end) / 2;
	long long leftResult = makeSegTree(node * 2, start, mid);
	long long rightResult = makeSegTree(node * 2 + 1, mid + 1, end);
	segTree[node] = leftResult + rightResult;
	return segTree[node];
}

long long returnSum(int node, int start, int end, int left, int right) {
	if (left > end || right < start) return 0;//교집합이 없는 경우
	if (left <= start && end <= right) return segTree[node];

	int mid = (start + end) / 2;
	long long leftResult = returnSum(node * 2, start, mid, left, right);
	long long rightResult = returnSum(node * 2 + 1, mid + 1, end, left, right);
	return leftResult + rightResult;
}//노드가 담당하고 있는 구간: start, end / 합을 구해야 하는 구간: left, right

void updateSegTree(int node, int start, int end, int index, long long diff) {//바꾸려는 노드의 index, 값 차이
	if (index < start || index > end) return;
	segTree[node] = segTree[node] + diff;

	if (start != end) {
		int mid = (start + end) / 2;
		updateSegTree(node * 2, start, mid, index, diff);
		updateSegTree(node * 2 + 1, mid + 1, end, index, diff);
	}
}

int main() {
	int N, M, K;
	scanf("%d%d%d", &N, &M, &K);

	for (int i = 0; i < N; i++) {
		long long x;
		scanf("%lld", &x);
		arr.push_back(x);
	}

	for (int i = 0; i < M + K; i++) {
		long long a, b, c;
		scanf("%lld%lld%lld", &a, &b, &c);
		cmd.push_back({ a,{b,c} });
	}

	int height = (int)ceil(log2(N));
	int size = (1 << (height + 1));
	
	segTree.resize(size);
	makeSegTree(1, 0, N - 1);

	for (int i = 0; i < cmd.size(); i++) {
		int CMD = cmd[i].first;
		if (CMD == 1) {
			int index = cmd[i].second.first - 1;
			long long value = cmd[i].second.second;
			long long diff = value - arr[index];
			arr[index] = value;
			updateSegTree(1, 0, N - 1, index, diff);
		}//값 변경
		else {
			int left = cmd[i].second.first - 1;
			int right = cmd[i].second.second - 1;
			long long result = returnSum(1, 0, N - 1, left, right);
			printf("%lld\n", result);
		}//구간 합
	}
}

/*
2042. 구간 합 구하기
https://www.acmicpc.net/problem/2042

문제
어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.

입력으로 주어지는 모든 수는 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.

출력
첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 단, 정답은 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
*/