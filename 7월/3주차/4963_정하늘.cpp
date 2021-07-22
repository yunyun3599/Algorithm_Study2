#include<stdio.h>

int w, h;

void DFS(int x, int y, int arr[][52], int visited[][52]) {
	visited[x][y] = 1;
	for (int i = 1; i <= h; i++) {
		for (int j = 1; j <= w; j++) {
			if (arr[x - 1][y] == 1 && visited[x - 1][y] == 0) {
				DFS(x - 1, y, arr, visited);
			}
			else if (arr[x + 1][y] == 1 && visited[x + 1][y] == 0) {
				DFS(x + 1, y, arr, visited);
			}
			else if (arr[x][y + 1] == 1 && visited[x][y + 1] == 0) {
				DFS(x, y + 1, arr, visited);
			}
			else if (arr[x][y - 1] == 1 && visited[x][y - 1] == 0) {
				DFS(x, y - 1, arr, visited);
			}
			else if (arr[x - 1][y + 1] == 1 && visited[x - 1][y + 1] == 0) {
				DFS(x - 1, y + 1, arr, visited);
			}
			else if (arr[x + 1][y + 1] == 1 && visited[x + 1][y + 1] == 0) {
				DFS(x + 1, y + 1, arr, visited);
			}
			else if (arr[x - 1][y - 1] == 1 && visited[x - 1][y - 1] == 0) {
				DFS(x - 1, y - 1, arr, visited);
			}
			else if (arr[x + 1][y - 1] == 1 && visited[x + 1][y - 1] == 0) {
				DFS(x + 1, y - 1, arr, visited);
			}
			//8방향을 모두 체크해줌
		}
	}

}

int main()
{
	while (1) {
		int count = 0;
		int arr[52][52] = { 0, };
		int visited[52][52] = { 0, };
		scanf("%d%d", &w, &h);
		if (w == 0 && h == 0) break;
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				scanf("%d", &arr[i][j]);
			}
		}

		for (int i = 1; i <=h; i++) {
			for (int j = 1; j <= w; j++) {
				if (arr[i][j] == 1 && visited[i][j] == 0) {
					count++;
					DFS(i, j, arr, visited);
				}
			}
		}
		printf("%d\n", count);
	}
}


/*
4963. 섬의 개수
https://www.acmicpc.net/problem/4963

문제
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.



한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

*/