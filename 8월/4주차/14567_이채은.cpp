#include <stdio.h>                                                            
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<int> graph[1001];
int degree[1001], ans[1001];

int main() {
    scanf("%d %d", &N, &M);
    for (int i = 0; i < M; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        graph[x].push_back(y);
        degree[y]++;
    }

    queue<int> q;
    for (int i = 1; i <= N; i++) {
        if (degree[i] == 0) q.push(i);
        ans[i] = 1; 
    }

    while (!q.empty()) {
        int cur = q.front(); q.pop();
        int size = graph[cur].size();
        for (int i = 0; i < size; i++) {
            int next = graph[cur][i];
            degree[next]--;
            if (degree[next] == 0) {
                q.push(next);
                ans[next] = max(ans[next], ans[cur] + 1); 
            }
        }
    }

    for (int i = 1; i <= N; i++)
        printf("%d ", ans[i]);
}
