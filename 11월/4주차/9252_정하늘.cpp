#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>
#include<iostream>


using namespace std;


int getMax(int a, int b) {
	return a < b ? b : a;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	string str1;
	string str2;
	int dp[1001][1001] = { 0, };

	cin >> str1 >> str2;

	int str1_len = str1.size();
	int str2_len = str2.size();

	string LCS[1001][1001];

	for (int i = 1; i <= str1_len; i++) {
		for (int j = 1; j <= str2_len; j++) {
			if (str1[i - 1] == str2[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
				LCS[i][j] = LCS[i][j] + LCS[i - 1][j - 1] + str1[i - 1];
			}
			else {
				dp[i][j] = getMax(dp[i - 1][j], dp[i][j - 1]);
				if (LCS[i - 1][j].size() > LCS[i][j - 1].size()) {
					LCS[i][j] = LCS[i - 1][j];
				}
				else {
					LCS[i][j] = LCS[i][j - 1];
				}
			}
		}
	}//dp로 문자열을 비교해나감. 
	cout << dp[str1_len][str2_len] << "\n" << LCS[str1_len][str2_len] << '\n';
}


/*
9252. LCS 2
https://www.acmicpc.net/problem/9252

문제
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를, 둘째 줄에 LCS를 출력한다.

LCS가 여러 가지인 경우에는 아무거나 출력하고, LCS의 길이가 0인 경우에는 둘째 줄을 출력하지 않는다.
*/