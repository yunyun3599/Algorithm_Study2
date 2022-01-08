#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int n, ans, arr[10000][2], res[10001];
vector<pair<int, int>> vec;

bool cmp(pair<int, int>& a, pair<int, int>& b)
{
    if (a.first == b.first)
        return a.second > b.second;
    return a.first > b.first;
}


int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int p, d;
        scanf("%d %d", &p, &d);
        vec.push_back({ p, d });
    }

    sort(vec.begin(), vec.end(), cmp);

    for (auto p : vec) {
        for (int i = p.second; i > 0; i--) {
            if (p.first > res[i]) {
                res[i] = p.first; break;
            }
        }
    }

    for (int i = 1; i <= 10000; i++)
        ans += res[i];

    printf("%d", ans);
}
