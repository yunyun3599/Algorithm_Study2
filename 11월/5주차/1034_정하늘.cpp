﻿#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
#include<string>


using namespace std;


int main() {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	int n, m, answer = 0;
	cin >> n >> m;
	
	map<string, int> pattern;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		pattern[s]++;
	}

	int button;
	cin >> button;

	map<string, int> :: iterator it;
	for (it = pattern.begin(); it != pattern.end(); ++it) {
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (it->first[i] == '0') {
				cnt++;
			}
		}
		if (cnt <= button && cnt % 2 == button % 2) {
			answer = max(answer, it->second);
		}
	}

	cout << answer << '\n';
}


/*
1034. 램프
https://www.acmicpc.net/problem/1034

문제
지민이는 각 칸마다 (1×1크기의 정사각형) 램프가 들어있는 직사각형 모양의 탁자를 샀다. 모든 램프는 켜져있거나 꺼져있다. 각 열의 아래에는 스위치가 하나씩 달려있는데, 이 스위치를 누를 때마다 그 열에 있는 램프의 상태가 바뀐다. 켜져있는 램프는 꺼지고, 꺼져있는 램프는 켜진다)

만약 어떤 행에 있는 램프가 모두 켜져있을 때, 그 행이 켜져있다고 말한다. 지민이는 스위치를 K번 누를 것이다. 서로다른 스위치 K개를 누르지 않아도 된다. 지민이는 스위치를 K번 눌러서 켜져있는 행을 최대로 하려고 한다.

지민이의 탁자에 있는 램프의 상태와 K가 주어졌을 때, 스위치를 K번 누른 후에 켜져있는 행의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N은 행의 개수이고, M은 열의 개수이다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 램프의 상태가 주어진다. 1이 켜져있는 상태이고, 0이 꺼져있는 상태이다. 마지막 줄에는 K가 주어진다. K는 1,000보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 문제의 정답을 출력한다.

불을 켤 수 있으려면 0의 개수보다 많이 누를 수 있어야 하고, 짝수 홀수 개가 맞아야 함
*/