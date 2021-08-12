#include <stdio.h>
#include <algorithm>
#include <vector>

using namespace std;

long long N, M, l, r, total;
vector<pair<int, int>> v;

int main() {
    scanf("%lld%lld", &N, &M);
    for (int i = 0; i < N; i++) {
        int s, e;
        scanf("%d%d", &s, &e);
        if (s > e) v.push_back({ e, s });
    }
    sort(v.begin(), v.end());
    for (auto p : v) {
        if (r >= p.first) {
            if (p.second > r) r = p.second;
        }
        else {
            total += r - l;
            l = p.first;
            r = p.second;
        }
    }
    total += r - l;
    printf("%lld", total * 2 + M);
}
