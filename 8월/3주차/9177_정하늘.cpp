#include<stdio.h>
#include<vector>
#include<iostream>
#include<string>


using namespace std;

string str1, str2, target;
int len;
int n;
int flag = 0;

void DFS(int idx1, int idx2, int idx3) {
	for (int i = idx3; i < len; i++) {
		if (flag) return;
		if (target[i] == str1[idx1] && target[i] == str2[idx2]) {
			DFS(idx1, idx2 + 1, i + 1);
			idx1++;
		}
		else if (target[i] == str1[idx1]) {
			idx1++;
		}
		else if (target[i] == str2[idx2]) {
			idx2++;
		}
		else return;
	}
	flag = 1;
	return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> str1 >> str2 >> target;
		flag = 1;
		int len1 = str1.length();
		int len2 = str2.length();
		len = len1 + len2;
		int alpha[26] = { 0, };
		for (int i = 0; i < len1; i++) {
			alpha[str1[i] - 'a']++;
		}
		for (int i = 0; i < len2; i++) {
			alpha[str2[i] - 'a']++;
		}
		for (int i = 0; i < len; i++) {
			alpha[target[i] - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (alpha[i] != 0) flag = 0;
		}
		if (flag) {
			flag = 0;
			DFS(0, 0, 0);
			cout << "Data set " << i << ": ";
			flag ? (cout << "yes\n") : (cout << "no\n");
		}
		else {
			cout << "Data set " << i << ": ";
			cout << "no\n";
		}

	}
}


/*
9177. 단어 섞기
https://www.acmicpc.net/problem/9177

문제
세 개의 단어가 주어졌을때, 꿍은 첫 번째 단어와 두 번째 단어를 섞어서 세 번째 단어를 만들 수 있는지 궁금해졌다. 첫 번째와 두 번째 단어는 마음대로 섞어도 되지만 원래의 순서는 섞여서는 안 된다. 다음과 같은 경우를 생각해보자.

첫 번째 단어 : cat
두 번째 단어 : tree
세 번째 단어 : tcraete
보면 알 수 있듯이, 첫 번째 단어와 두 번째 단어를 서로 섞어서 세 번째 단어를 만들 수 있다. 아래와 같이 두 번째 예를 들어보자.

첫 번째 단어 : cat
두 번째 단어 : tree
세 번째 단어 : catrtee
이 경우 역시 가능하다. 그렇다면 "cat"과 "tree"로 "cttaree"를 형성하는건 불가능하다는걸 눈치챘을 것이다.

입력
입력의 첫 번째 줄에는 1부터 1000까지의 양의 정수 하나가 주어지며 데이터 집합의 개수를 뜻한다. 각 데이터집합의 처리과정은 동일하다고 하자. 각 데이터집합에 대해, 세 개의 단어로 이루어져 있으며 공백으로 구분된다. 모든 단어는 대문자 또는 소문자로만 구성되어 있다. 세 번째 단어의 길이는 항상 첫 번째 단어와 두 번째 단어의 길이의 합이며 첫 번째 단어와 두 번째 단어의 길이는 1~200이다.

출력
각 데이터집합에 대해 다음과 같이 출력하라.

만약 첫 번째 단어와 두 번째 단어로 세 번째 단어를 형성할 수 있다면

Data set n: yes
과 같이 출력하고 만약 아니라면

Data set n: no
과 같이 출력하라. 물론 n은 데이터집합의 순번으로 바뀌어야 한다. 아래의 예제 출력을 참고하라.


DFS처럼 풀면 될 듯?
둘 중에 가능한거 있으면 돌려버리기

둘 중에 하나만 되면 해당 idx를 ++ 해버리기.
둘 다 되면 둘 다 해보기

>> 50퍼센트에서 틀리는 코드(시간초과)

str1, str2와 target의 알파벳을 비교해서 아예 불가능한 경우를 먼저 제외해주면 시간초과X
*/