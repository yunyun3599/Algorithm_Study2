#include <stdio.h>
#include <algorithm>

using namespace std;

int N, k;

int main() {
	scanf("%d %d", &N, &k);

	int l = 1, r = k, m = (1 + k) / 2;
	int res = 0;

	while (l <= r) {
		m = (l + r) / 2;

		int cnt = 0;
		for (int i = 1; i <= N; i++)
			cnt += min(N, m / i);

		if (cnt >= k) {
			res = m;
			r = m - 1;
		}
		else l = m + 1;
	}

	printf("%d", res);
}
