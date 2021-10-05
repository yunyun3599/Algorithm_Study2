#include<iostream>
#include<string>

using namespace std;

int main(void)
{
	string str1, str2;
	cin >> str1 >> str2;

	if (str1.size() != str2.size())
		cout << "0\n";
	else {
		int len = str1.size();
		int ans = 0;

		for (int i = 0; i < len; i++) {
			if (str1[i] != str2[i])
				break;

			if (str1[i] == '8')
				ans++;
		}
		cout << ans << '\n';
	}
}

/*
1105. 팔
https://www.acmicpc.net/problem/1105

문제
L과 R이 주어진다. 이때, L보다 크거나 같고, R보다 작거나 같은 자연수 중에 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 L과 R이 주어진다. L은 2,000,000,000보다 작거나 같은 자연수이고, R은 L보다 크거나 같고, 2,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 L보다 크거나 같고, R보다 작거나 같은 자연수 중에 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 구하는 프로그램을 작성하시오.

*/