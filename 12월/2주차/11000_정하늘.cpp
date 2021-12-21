#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;



int main() {
	//ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n;
	scanf("%d", &n);

	vector<pair<int, int>> lectures;//start 순으로 정렬
	priority_queue<int, vector<int>, greater<int>>pq;//end 순으로 정렬

	for (int i = 0; i < n; i++) {
		int start, end;
		scanf("%d%d", &start, &end);
		lectures.push_back({ start,end });
	}

	sort(lectures.begin(), lectures.end());

	pq.push(0);
	int start, end;

	for (int i = 0; i < n; i++) {
		start = lectures[i].first;
		end = lectures[i].second;

		if (pq.top() > start) {
			pq.push(end);
		}
		else {
			pq.pop();
			pq.push(end);
		}
	}

	printf("%d\n", pq.size());
}


/*
11000. 강의실 배정
https://www.acmicpc.net/problem/11000

문제
수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.

김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.

참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)

수강신청 대충한 게 찔리면, 선생님을 도와드리자!

입력
첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)

이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)

출력
강의실의 개수를 출력하라.


처음에 시간을 1씩 늘려가면서 했을 때 시간초과.
배열에 저장된 시간만 활용해서 해야함.
*/