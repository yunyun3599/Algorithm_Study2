﻿#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<string>


using namespace std;

int n;

void backtracking(int sum, char sign, int num, int depth, string str) {
	if (depth == n) {
		if (sign == '+') {
			if (sum + num == 0) {
				cout << str << '\n';
			}
		}
		else if (sign == '-') {
			if (sum - num == 0) {
				cout << str << '\n';
			}
		}
		return;
	}
	else {
		string s;
		//" "
		s = str + " " + to_string(depth + 1);
		backtracking(sum, sign, num * 10 + depth + 1, depth + 1, s);

		//"+"
		s = str + "+" + to_string(depth + 1);
		if (sign == '+') {
			backtracking(sum + num, '+', depth + 1, depth + 1, s);
		}
		else if (sign == '-') {
			backtracking(sum - num, '+', depth + 1, depth + 1, s);
		}

		//"-"
		s = str + "-" + to_string(depth + 1);
		if (sign == '+') {
			backtracking(sum + num, '-', depth + 1, depth + 1, s);
		}
		else if (sign == '-') {
			backtracking(sum - num, '-', depth + 1, depth + 1, s);
		}
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	
	int t;
	cin >> t;

	while (t--) {
		cin >> n;
		backtracking(0, '+', 1, 1, "1");
		cout << "\n";
	}
}


/*
7490. 0 만들기
https://www.acmicpc.net/problem/7490

문제
1부터 N까지의 수를 오름차순으로 쓴 수열 1 2 3 ... N을 생각하자.

그리고 '+'나 '-', 또는 ' '(공백)을 숫자 사이에 삽입하자(+는 더하기, -는 빼기, 공백은 숫자를 이어 붙이는 것을 뜻한다). 이렇게 만든 수식의 값을 계산하고 그 결과가 0이 될 수 있는지를 살피자.

N이 주어졌을 때 수식의 결과가 0이 되는 모든 수식을 찾는 프로그램을 작성하라.

입력
첫 번째 줄에 테스트 케이스의 개수가 주어진다(<10).

각 테스트 케이스엔 자연수 N이 주어진다(3 <= N <= 9).

출력
각 테스트 케이스에 대해 ASCII 순서에 따라 결과가 0이 되는 모든 수식을 출력한다. 각 테스트 케이스의 결과는 한 줄을 띄워 구분한다.
*/