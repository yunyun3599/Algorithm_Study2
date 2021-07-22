#include <stdio.h>
#include <utility>

using namespace std;

int N, root, cnt = 1, lmt, lev = 1, ans = 1;
int low[10001];
int high[10001];
bool chk[10001];
pair<int, int> tree[10001];

void inorder(int node, int depth) {
    if (depth > lmt) lmt = depth;
    int l = tree[node].first, r = tree[node].second;

    if (l != -1) inorder(l, depth + 1);

    if (cnt < low[depth]) low[depth] = cnt;
    if (cnt > high[depth]) high[depth] = cnt;
    cnt++;

    if (r != -1) inorder(r, depth + 1);
}

int main() {
    scanf("%d", &N);

    for (int i = 0; i < N; i++) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        tree[a] = { b, c };
        if (b != -1) chk[b] = true;
        if (c != -1) chk[c] = true;
    }

    for (int i = 1; i <= N; i++) {
        if (!chk[i]) {
            root = i; break;
        }
    }

    for (int i = 1; i <= N; i++)
        low[i] = 10001;

    inorder(root, 1);
    for (int i = 1; i <= lmt; i++) {
        if (high[i] - low[i] + 1 > ans) {
            ans = high[i] - low[i] + 1;
            lev = i;
        }
    }
    printf("%d %d", lev, ans);
}
