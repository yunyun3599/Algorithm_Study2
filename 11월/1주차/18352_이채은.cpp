#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M, K, X;
vector<int> graph[300001];
int visit[300001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> M >> K >> X;
    for (int i = 0; i < M; i++) {
        int A, B;
        cin >> A >> B;
        graph[A].push_back(B);
    }

    int cnt = 1; visit[X] = -1;
    queue<int> q; q.push(X);
    while (!q.empty()) {
        if (cnt > K) break;
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int num = q.front(); q.pop();
            for (int tmp : graph[num]) {
                if (visit[tmp] != 0) continue;
                visit[tmp] = cnt; q.push(tmp);
            }
        }
        cnt++;
    }

    if (q.empty()) cout << -1 << '\n';
    else
        for (int i = 1; i <= N; i++)
            if (visit[i] == K) cout << i << '\n';
}
