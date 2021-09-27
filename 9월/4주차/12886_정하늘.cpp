#include<stdio.h>
#include<vector>
#include<string>
#include<queue>
#include<algorithm>

using namespace std;


bool visit[1501][1501];//A+B+C 값은 고정, 도중 나올 수 있는 최댓값 1500으로 visit[A][B] 설정

int main() {
	int A, B, C;
	scanf("%d%d%d", &A, &B, &C);

	int ans = 0;
	if ((A + B + C) % 3 != 0) ans = 0;
	else {
		queue< pair< pair<int, int>, int> > q;
		q.push({ {A,B}, C });
		while (!q.empty()) {
			int a = q.front().first.first;
			int b = q.front().first.second;
			int c = q.front().second;
			q.pop();

			if (a == b && b == c) {
				ans = 1;
				break;
			}
			else {//ab bc ca 모든 선택의 경우의 수
				if (a > b) {
					if (!visit[a - b][b + b]) {
						visit[a - b][b + b] = true;
						q.push({ { a - b, b + b }, c });
					}
				}
				else if (a < b) {
					if (!visit[a + a][b - a]) {
						visit[a + a][b - a] = true;
						q.push({ { a + a, b - a }, c });
					}
				}

				if (b > c) {
					if (!visit[a][b - c]) {
						visit[a][b - c] = true;
						q.push({ { a, b - c }, c + c });
					}
				}
				else if (b < c) {
					if (!visit[a][b + b]) {
						visit[a][b + b] = true;
						q.push({ { a, b + b }, c - b });
					}
				}

				if (c > a) {
					if (!visit[a + a][b]) {
						visit[a + a][b] = true;
						q.push({ { a + a, b }, c - a });
					}
				}
				else if (c < a) {
					if (!visit[a - c][b]) {
						visit[a - c][b] = true;
						q.push({ { a - c, b }, c + c });
					}
				}
			}
		}
	}
	printf("%d\n", ans);
	//두 그룹을 골라서 큰 것 Y-X개, 작은 것 X+X
	//같은 개수로 만들 수 있으면 1 아니면 0

	//A,B,C를 가지고 있는 큐를 만들기
}

/*
12886. 돌 그룹
https://www.acmicpc.net/problem/12886

문제
오늘 강호는 돌을 이용해 재미있는 게임을 하려고 한다. 먼저, 돌은 세 개의 그룹으로 나누어져 있으며 각각의 그룹에는 돌이 A, B, C개가 있다. 강호는 모든 그룹에 있는 돌의 개수를 같게 만들려고 한다.

강호는 돌을 단계별로 움직이며, 각 단계는 다음과 같이 이루어져 있다.

크기가 같지 않은 두 그룹을 고른다. 그 다음, 돌의 개수가 작은 쪽을 X, 큰 쪽을 Y라고 정한다. 그 다음, X에 있는 돌의 개수를 X+X개로, Y에 있는 돌의 개수를 Y-X개로 만든다.

A, B, C가 주어졌을 때, 강호가 돌을 같은 개수로 만들 수 있으면 1을, 아니면 0을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 주어진다. (1 ≤ A, B, C ≤ 500)

출력
돌을 같은 개수로 만들 수 있으면 1을, 아니면 0을 출력한다.
*/