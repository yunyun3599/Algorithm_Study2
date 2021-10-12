#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>


using namespace std;


int main() {
	int n;
	scanf("%d", &n);

	int ans = 0;

	queue< pair< pair<int, int>, int> > q;//이모티콘 개수, 횟수, clipboard
	bool visit[1001][1001] = { 0, };//이모티콘 개수, clipboard

	q.push({ { 1,0 },0 });

	while (!q.empty()) {
		int emojis = q.front().first.first;
		int num = q.front().first.second;
		int clipboard = q.front().second;
		q.pop();

		if (emojis == n) {
			ans = num;
			break;
		}


		if (!visit[emojis][emojis]) {
			visit[emojis][emojis] = true;
			q.push({ {emojis, num + 1}, emojis });
		}//전체 복사	
		if (clipboard != 0 && emojis + clipboard <= n) {
			if (!visit[emojis + clipboard][clipboard]) {
				visit[emojis + clipboard][clipboard] = true;
				q.push({ { emojis + clipboard, num + 1 }, clipboard });
			}//붙여넣기
		}
		if (emojis - 1 > 0 && !visit[emojis - 1][clipboard]) {
			visit[emojis - 1][clipboard] = true;
			q.push({ {emojis - 1, num + 1}, clipboard });
		}//1개 삭제
	}

	printf("%d\n", ans);
}

/*
14226. 이모티콘
https://www.acmicpc.net/problem/14226

문제
영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.

영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.

화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
화면에 있는 이모티콘 중 하나를 삭제한다.
모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다. 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.

영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 S (2 ≤ S ≤ 1000) 가 주어진다.

출력
첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.

L:45) emojis -1 > 0 체크 필수
*/