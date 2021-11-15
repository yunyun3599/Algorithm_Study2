#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int N, ans, l = -1000000001, r = -1000000001;
vector<pair<int, int>> line;

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        line.push_back({ x, y });
    }

    sort(line.begin(), line.end());

    for (int i = 0; i < N; i++) {
        if (r < line[i].first) {
            ans += r - l;
            l = line[i].first;
            r = line[i].second;
        }
        else r = max(r, line[i].second);
    }
    ans += r - l;
    printf("%d", ans);
}
