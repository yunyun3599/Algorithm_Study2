#include<stdio.h>
#include<vector>
#include<iostream>
#include<string>

#define INF 19999999


using namespace std;


int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;
	cin >> t;
	while (t--) {
		string str;
		int k;
		cin >> str >> k;

		vector<int> alphabet[26];
		int len = str.length();
		for (int i = 0; i < len; i++) {
			alphabet[str[i] - 'a'].push_back(i);//idx 삽입
		}
		int ans_min = INF;
		int ans_max = -1;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i].size() < k) continue;//해당 알파벳이 k개보다 적으면 탈락
			for (int j = 0; j + k - 1 < alphabet[i].size(); j++) {
				if (alphabet[i][j + k - 1] - alphabet[i][j] + 1 < ans_min) {
					ans_min = alphabet[i][j + k - 1] - alphabet[i][j] + 1;
				}//k==2 면 alphabet[i][1]-alphabet[i][0]
				if (alphabet[i][j + k - 1] - alphabet[i][j] + 1 > ans_max) {
					ans_max = alphabet[i][j + k - 1] - alphabet[i][j] + 1;
				}
			}
		}

		if (ans_min == INF) cout << "-1\n";
		else cout << ans_min << " " << ans_max << '\n';
	}
}


/*
20437. 문자열 게임 2
https://www.acmicpc.net/problem/20437

문제
작년에 이어 새로운 문자열 게임이 있다. 게임의 진행 방식은 아래와 같다.

알파벳 소문자로 이루어진 문자열 W가 주어진다.
양의 정수 K가 주어진다.
어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다.
어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다.
위와 같은 방식으로 게임을 T회 진행한다.

입력
문자열 게임의 수 T가 주어진다. (1 ≤ T ≤ 100)

다음 줄부터 2개의 줄 동안 문자열 W와 정수 K가 주어진다. (1 ≤ K ≤ |W| ≤ 10,000) 

출력
T개의 줄 동안 문자열 게임의 3번과 4번에서 구한 연속 문자열의 길이를 공백을 사이에 두고 출력한다.

만약 만족하는 연속 문자열이 없을 시 -1을 출력한다.

*/