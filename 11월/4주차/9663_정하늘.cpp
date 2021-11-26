#include<stdio.h>
#include<math.h>

int n;
int column[16];//각 열 별로, queen이 저장된 row값을 저장함. column[1]=3 일 경우, 첫번째 열의 퀸은 3번째 row에 위치해있다는 의미(y=1,x=3)
int cnt = 0;

int promising(int col) {
	for (int j = 0; j < col; j++) {
		if (column[j] == column[col] || abs(column[col] - column[j]) == (col - j)) return 0;
	}//같은 행 || 대각선
	return 1;
}

void N_Queen(int col) {
	if (col == n) cnt++;
	else {
		for (int i = 1; i <= n; i++) {
			column[col] = i;
			if (promising(col)) {
				N_Queen(col + 1);
			}//1~n까지 여기서 모두 탐색하게 됨. col에 대해 promising 체크하고, col+1 을 호출함. queen이 1,2,3,... 에 놓여있을 때에 promising 체크 후 다음 퀸 배치 
		}
	}
}

int main() {
	scanf("%d", &n);

	N_Queen(0);

	printf("%d\n", cnt);

}


/*
9663. N-Queen
https://www.acmicpc.net/problem/9663

문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.



*/