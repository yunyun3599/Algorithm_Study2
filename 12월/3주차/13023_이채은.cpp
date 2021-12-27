#include <stdio.h>
#include <vector>

using namespace std;

int N, M;
bool flag;
bool visit[2000];
vector<int> arr[2000];

void dfs(int num, int cnt) {
    if (flag) return;
    if (cnt == 5) {
        flag = true; return;
    }

    for (int x : arr[num]) {
        if (visit[x]) continue;
        visit[x] = true;
        dfs(x, cnt + 1);
        visit[x] = false;
    }
}

int main() {
    scanf("%d %d", &N, &M);
    int a, b;
    for (int i = 0; i < M; i++) {
        scanf("%d %d", &a, &b);
        arr[a].push_back(b);
        arr[b].push_back(a);
    }

    for (int i = 0; i < N; i++) {
        dfs(i, 0);
        if (flag) break;
    }
    printf("%d", flag);
}
