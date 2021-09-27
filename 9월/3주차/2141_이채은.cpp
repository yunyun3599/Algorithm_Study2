#include <stdio.h>
#include <algorithm>
#include <vector>
#define ll long long

using namespace std;

ll N, ans = 2000000000;
ll sum[100000];
vector<pair<ll, ll>> list;

void search() {
    ll l = 0, r = N - 1;
    while (l <= r) {
        ll mid = (l + r) / 2;
        long long left = sum[mid], right = sum[N - 1] - sum[mid]; //mid 기준 왼쪽 인구수, 오른쪽 인구수
        if (left >= right) {
            r = mid - 1;
            ans = min(ans, list[mid].first);
          //답이 여러 개일 경우 가장 왼쪽의 것을 구하라 하였으므로 왼쪽 인구수가 더 클 때만 갱신
        }
        else {
            l = mid + 1;
        }
    }
} //이분 탐색

int main() {
    long long tmp = 0;
    scanf("%lld", &N);
    for (int i = 0; i < N; i++) {
        ll x, y;
        scanf("%lld %lld", &x, &y);
        list.push_back({ x, y });
    }
    sort(list.begin(), list.end());
    for (int i = 0; i < N; i++)
        sum[i] = (tmp += list[i].second);
    search();
    printf("%lld", ans);
}
