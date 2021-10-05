#include<stdio.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<iostream>
#include<string>


using namespace std;


int main() {
	int n, m, price[11];
	cin >> n;

	memset(price, -1, sizeof(price));

	vector< pair<int, int> > v;

	for (int i = 0; i < n; ++i) {
		int x;
		cin >> x;
		price[i] = x;
		v.push_back({ x, i });
	}

	cin >> m;

	sort(v.begin(), v.end());

	string res("");
	int idx = 0;
	if (!v[idx].second) {
		if (v.size() == 1 || v[idx + 1].first > m) {
			res = "0";
		}
		idx++;
	}
	if (res != "0") {
		res.push_back(v[idx].second + '0');
		m -= v[idx].first;
		idx = 0;

		while (m - v[idx].first >= 0) {
			res.push_back(v[idx].second + '0');
			m -= v[idx].first;
		}

		for (int i = 0; i < res.size(); ++i) {
			for (int j = 0; j < 10; j++) {
				if (price[j] == -1) continue;

				int cur = res[i] - '0';

				int diff = price[j] - price[cur];
				if (m - diff >= 0 && cur < j) {
					m -= diff;
					res[i] = char(j + '0');
				}
			}
		}
	}
	cout << res << '\n';
}

/*
1082. 방 번호
https://www.acmicpc.net/problem/1082

문제
스타트링크가 입주한 사무실은 방 번호를 직접 정할 수 있다. 방 번호를 정하려면 1층 문방구에서 파는 숫자를 구매해야 한다. 숫자를 구매하기 위해 준비한 금액은 M원이고, M원을 모두 사용해야 한다.

문방구에서 파는 숫자는 0부터 N-1까지이고, 각 숫자 i의 가격은 Pi이다. 문방구에서는 같은 숫자를 여러 개 구매할 수 있고, 문방구는 매우 많은 재고를 보유하고 있기 때문에, 항상 원하는 만큼 숫자를 구매할 수 있다. 방 번호가 0이 아니라면 0으로 시작할 수 없다.

예를 들어, N = 3, M = 21, P0 = 6, P1 = 7, P2 = 8이라면, 만들 수 있는 가장 큰 방 번호는 210이다. M원을 모두 사용해서 만들 수 있는 가장 큰 방 번호를 구해보자.

입력
첫째 줄에 N이 주아진다. 둘째 줄에는 공백으로 구분된 P0, ..., PN-1이 주어진다. 마지막 줄에는 M이 주어진다.

출력
첫째 줄에 M원을 사용해서 만들 수 있는 가장 큰 방 번호를 출력한다. 적어도 하나의 숫자를 살 수 있는 입력만 주어진다.
*/