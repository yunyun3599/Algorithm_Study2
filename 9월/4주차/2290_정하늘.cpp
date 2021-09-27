#include<stdio.h>
#include<vector>
#include<string>
#include<iostream>


using namespace std;

string n;
int s;

//윗 --
//윗 |
//중간 --
//아래 |
//아래 --
//각 함수를 별도로 만들어놓고 자릿수 하나씩 돌면서 출력하기

void upHorizen() {
	//14 || 23567890
	int len = n.length();
	for (int i = 0; i < len; i++) {
		if (n[i] == '1' || n[i] == '4') {
			cout << ' ';
			for (int j = 0; j < s; j++) {
				cout << ' ';
			}
			cout << ' ';
		}
		else {
			cout << ' ';
			for (int j = 0; j < s; j++) {
				cout << '-';
			}
			cout << ' ';
		}
		cout << ' ';
	}
	cout << '\n';
}

void upVertical() {
	int len = n.length();
	//1237 || 4890 || 56
	for (int j = 0; j < s; j++) {
		for (int i = 0; i < len; i++) {
			if (n[i] == '5' || n[i] == '6') {
				cout << '|';
				for (int k = 0; k < s; k++) {
					cout << ' ';
				}
				cout << ' ';
			}
			else if (n[i] == '4' || n[i] == '8' || n[i] == '9' || n[i] == '0') {
				cout << '|';
				for (int k = 0; k < s; k++) {
					cout << ' ';
				}
				cout << '|';
			}
			else {
				cout << ' ';
				for (int k = 0; k < s; k++) {
					cout << ' ';
				}
				cout << '|';
			}
			cout << ' ';
		}
		cout << '\n';
	}
}

void midHorizen() {
	//170 || 2345689
	int len = n.length();
	for (int i = 0; i < len; i++) {
		if (n[i] == '1' || n[i] == '7' || n[i] == '0') {
			cout << ' ';
			for (int j = 0; j < s; j++) {
				cout << ' ';
			}
			cout << ' ';
		}
		else {
			cout << ' ';
			for (int j = 0; j < s; j++) {
				cout << '-';
			}
			cout << ' ';
		}
		cout << ' ';
	}
	cout << '\n';
}

void downVertical() {
	int len = n.length();
	//134579 || 2 || 680
	for (int j = 0; j < s; j++) {
		for (int i = 0; i < len; i++) {
			if (n[i] == '2') {
				cout << '|';
				for (int k = 0; k < s; k++) {
					cout << ' ';
				}
				cout << ' ';
			}//왼쪽 |
			else if (n[i] == '6' || n[i] == '8' || n[i] == '0') {
				cout << '|';
				for (int k = 0; k < s; k++) {
					cout << ' ';
				}
				cout << '|';
			}
			else {
				cout << ' ';
				for (int k = 0; k < s; k++) {
					cout << ' ';
				}
				cout << '|';
			}
			cout << ' ';
		}
		cout << '\n';
	}
}

void downHorizen() {
	//147
	int len = n.length();
	for (int i = 0; i < len; i++) {
		if (n[i] == '1' || n[i] == '4' || n[i] == '7') {
			cout << ' ';
			for (int j = 0; j < s; j++) {
				cout << ' ';
			}
			cout << ' ';
		}
		else {
			cout << ' ';
			for (int j = 0; j < s; j++) {
				cout << '-';
			}
			cout << ' ';
		}
		cout << ' ';
	}
	cout << '\n';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s >> n;

	upHorizen();
	upVertical();
	midHorizen();
	downVertical();
	downHorizen();
}


/*
2290. LCD Test
https://www.acmicpc.net/problem/2290

문제
지민이는 새로운 컴퓨터를 샀다. 하지만 새로운 컴퓨터에 사은품으로 온 LC-디스플레이 모니터가 잘 안나오는 것이다. 지민이의 친한 친구인 지환이는 지민이의 새로운 모니터를 위해 테스트 할 수 있는 프로그램을 만들기로 하였다.

입력
첫째 줄에 두 개의 정수 s와 n이 들어온다. (1 ≤ s ≤ 10, 0 ≤ n ≤ 9,999,999,999)이다. n은 LCD 모니터에 나타내야 할 수 이며, s는 크기이다.

출력
길이가 s인 '-'와 '|'를 이용해서 출력해야 한다. 각 숫자는 모두 s+2의 가로와 2s+3의 세로로 이루어 진다. 나머지는 공백으로 채워야 한다. 각 숫자의 사이에는 공백이 한 칸 있어야 한다.

*/