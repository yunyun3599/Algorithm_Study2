#include<stdio.h>
#include<vector>
#include<queue>
#include<iostream>
#include<sstream>
#include<string>
#include<typeinfo>

using namespace std;


int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string ip;
	cin >> ip;

	int len = ip.length();

	istringstream ss(ip);
	string stringBuffer;
	vector<string> x;

	string ans = "";
	int size = 0;
	if (ip == "::") {
		ans = "0000:0000:0000:0000:0000:0000:0000:0000";
	}
	else {
		while (getline(ss, stringBuffer, ':')) {
			if (stringBuffer.size() > 0) size++;
			x.push_back(stringBuffer);
		}

		//두 경우로 나누자. 맨 앞부터 ::인 경우, 중간에 ::인 경우, 끝에 ::인 경우
		if (x.size() - size == 0) {
			for (int i = 0; i < x.size(); i++) {
				int t = x[i].size();
				if (i != 0)ans += ':';
				if (t < 4) {
					while (t != 4) {
						ans += '0';
						t++;
					}
				}
				ans += x[i];
			}
		}//::이 없는 경우
		else if (x.size() - size == 1) {
			for (int i = 0; i < x.size(); i++) {
				int t = x[i].size();
				int flag = 0;
				if (t == 0) {
					while (1) {
						ans += ":0000";
						flag++;
						if (flag == 8 - size) break;
					}
					continue;
				}
				else if (t < 4) {
					if (i != 0) ans += ':';
					while (t != 4) {
						ans += '0';
						t++;
					}
				}
				ans += x[i];
			}
		}//::이 중간에 있는 경우
		else {
			int flag = 0;
			if (ip[0] == ':') {
				while (1) {
					ans += "0000:";
					flag++;
					if (flag == 8 - size) break;
				}
				for (int i = 2; i < x.size(); i++) {
					int t = x[i].size();
					if (t < 4) {

						while (t != 4) {
							ans += '0';
							t++;
						}
					}
					ans += x[i];
					if (i != x.size() - 1) ans += ':';
				}

			}//처음에 ::가 있는 경우
			else {
				for (int i = 0; i < x.size() - 2; i++) {
					int t = x[i].size();
					if (t < 4) {
						if (i != 0) ans += ':';
						while (t != 4) {
							ans += '0';
							t++;
						}
					}
					ans += x[i];
				}
				while (1) {
					ans += ":0000";
					flag++;
					if (flag == 8 - size) break;
				}
			}//끝에 ::가 있는 경우
		}//::이 처음 or 끝에 있는 경우
	}
	cout << ans << '\n';
}


/*
3107. IPv6
https://www.acmicpc.net/problem/3107

문제
IPv6은 길이가 128비트인 차세대 인터넷 프로토콜이다.

IPv6의 주소는 32자리의 16진수를 4자리씩 끊어 나타낸다. 이때, 각 그룹은 콜론 (:)으로 구분해서 나타낸다.

예를 들면, 다음과 같다.

2001:0db8:85a3:0000:0000:8a2e:0370:7334
32자리의 16진수는 사람이 읽고 쓰기에 불편하고, 대부분의 자리가 0이기 때문에 아래와 같이 축약할 수 있다.

각 그룹의 앞자리의 0의 전체 또는 일부를 생략 할 수 있다. 위의 IPv6을 축약하면, 다음과 같다
2001:db8:85a3:0:00:8a2e:370:7334
만약 0으로만 이루어져 있는 그룹이 있을 경우 그 중 한 개 이상 연속된 그룹을 하나 골라 콜론 2개(::)로 바꿀 수 있다.
2001:db8:85a3::8a2e:370:7334
2번째 규칙은 모호함을 방지하기 위해서 오직 한 번만 사용할 수 있다.

올바른 축약형 IPv6주소가 주어졌을 때, 이를 원래 IPv6 (32자리의 16진수)로 복원하는 프로그램을 작성하시오.

입력
첫째 줄에 올바른 IPv6 주소가 주어진다. 이 주소는 최대 39글자이다. 또한, 주소는 숫자 0-9, 알파벳 소문자 a-f, 콜론 :으로만 이루어져 있다.

출력
첫째 줄에, 입력으로 주어진 IPv6의 축약되지 않은 형태를 출력한다.


: 기준으로 split, 덩어리가 8개가 아니면 0000이 축약된 것이 존재하는 것.
split 된 문자열의 길이가 4가 아니면 0이 축약된것. 0추가


25:09:1985:aa:091:4846:374:bb

0025:0009:1985:00aa:0091:4846:0374:00bb


1:	0000:0000:0000:0000:0000:0000:	:1
0000:0000:0000:0000:0000:0000:0000:0001

::1 -> 3개
1::1 -> 3개
>> 공백이 아닌 덩어리의 수를 세자
*/