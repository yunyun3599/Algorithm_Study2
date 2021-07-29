#include<iostream>
#include<queue>
#include<vector>

using namespace std;

char map[9][9];
char time_map[9][9][9];
vector< pair<int, int> > wall;

int dx[9] = { -1, -1, -1, 0, 0, 1, 1, 1, 0 };//대각선 상하좌우 제자리
int dy[9] = { -1, 0, 1, -1, 1, -1, 0, 1, 0 };

void init_time_map(){
	for (int i = 0; i < wall.size(); i++) {
		int x = wall[i].first;
		int y = wall[i].second;
		int Time = 1;

		while (1){
			int nx = x + 1;
			int ny = y;
			if (nx >= 8) break;

			time_map[Time][nx][ny] = '#';
			Time++;
			x = nx;
			y = ny;
		}
	}
}//시간에 따라 벽 상태를 저장

int check(int x, int time){
	for (int i = x - 1; i >= 0; i--){
		for (int j = 0; j < 8; j++){
			if (time_map[time][i][j] == '#') return 0;
		}
	}
	return 1;
}

int BFS(int a, int b) {
	queue<pair<pair<int, int>, int>> q;
	q.push({ { a, b }, 0 });

	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int t = q.front().second;
		q.pop();

		if (x == 0) return 1;//맨 윗 줄 도착
		if (check(x, t)) return 1;

		for (int i = 0; i < 9; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int nt = t + 1;

			if (nx >= 0 && ny >= 0 && nx < 8 && ny < 8) {
				if (time_map[nt][nx][ny] == '.' && time_map[t][nx][ny] == '.') {
					q.push(make_pair(make_pair(nx, ny), nt));
				}//현재 이동 가능하고, 벽이 움직인 후에도 이동 가능해야함.
			}
		}
	}
	return 0;
}


int main(void){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			cin >> map[i][j];
			if (map[i][j] == '#') {
				time_map[0][i][j] = '#';
				wall.push_back(make_pair(i, j));
			}
		}
	}
	for (int t = 0; t < 8; t++) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (time_map[t][i][j] == '#') continue;
				time_map[t][i][j] = '.';
			}
		}
	}//t초에 i,j의 상태

	init_time_map();
	cout << BFS(7, 0) << endl;

	return 0;
}


/*
16954. 움직이는 미로 탈출
https://www.acmicpc.net/problem/16954

문제
욱제는 학교 숙제로 크기가 8×8인 체스판에서 탈출하는 게임을 만들었다. 체스판의 모든 칸은 빈 칸 또는 벽 중 하나이다. 욱제의 캐릭터는 가장 왼쪽 아랫 칸에 있고, 이 캐릭터는 가장 오른쪽 윗 칸으로 이동해야 한다.

이 게임의 특징은 벽이 움직인다는 점이다. 1초마다 모든 벽이 아래에 있는 행으로 한 칸씩 내려가고, 가장 아래에 있어서 아래에 행이 없다면 벽이 사라지게 된다. 욱제의 캐릭터는 1초에 인접한 한 칸 또는 대각선 방향으로 인접한 한 칸으로 이동하거나, 현재 위치에 서 있을 수 있다. 이동할 때는 빈 칸으로만 이동할 수 있다.

1초 동안 욱제의 캐릭터가 먼저 이동하고, 그 다음 벽이 이동한다. 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없다.

욱제의 캐릭터가 가장 오른쪽 윗 칸으로 이동할 수 있는지 없는지 구해보자.

입력
8개 줄에 걸쳐서 체스판의 상태가 주어진다. '.'은 빈 칸, '#'는 벽이다. 가장 왼쪽 아랫칸은 항상 벽이 아니다.

출력
욱제의 캐릭터가 가장 오른쪽 윗 칸에 도착할 수 있으면 1, 없으면 0을 출력한다.


*/