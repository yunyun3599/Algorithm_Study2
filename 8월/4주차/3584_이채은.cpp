#include <stdio.h>
#include <vector>

using namespace std;

int main() {
	int T, N;
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%d", &N);
		int x, y;
		int tree[10001] = { 0, };
		for (int j = 0; j < N - 1; j++) {
			scanf("%d %d", &x, &y);
			tree[y] = x;
		}
		scanf("%d %d", &x, &y);
		vector<int> route1; 
		vector<int> route2;
		int cur = x;
		while (cur > 0) {
			route1.push_back(cur);
			cur = tree[cur];
		}
		cur = y;
		while (cur > 0) {
			route2.push_back(cur);
			cur = tree[cur];
		}

		bool flag = false;
		for (int i = 0; i < route1.size(); i++) {
			if (flag) break;
			for (int j = 0; j < route2.size(); j++) {
				if (route1[i] == route2[j]) {
					printf("%d\n", route1[i]);
					flag = true;
					break;
				}
			}
		}
	}
}
