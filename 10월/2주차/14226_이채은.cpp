#include <stdio.h>
#include <tuple>
#include <queue>
#include <algorithm>

using namespace std;

int S, ans = 12345;
int visit[2001][2001];

void emoji() {
    queue<tuple<int, int, int>> q;
    q.push(make_tuple( 0, 1, 0 ));
    while (!q.empty()) {
        int time, cnt, clip;
        tie(time, cnt, clip) = q.front(); q.pop();
        if (cnt == S) {
            ans = time; break;
        }
        if (visit[cnt][clip]) continue;
        visit[cnt][clip] = true;
        if (cnt > 0 && cnt < 2000) {
            q.push({ time + 1, cnt, cnt });
            q.push({ time + 1, cnt - 1, clip });
        }
        if (clip > 0 && cnt + clip < 2000)
            q.push({ time + 1, cnt + clip, clip });
    }
}

int main() {
    scanf("%d", &S);
    emoji();
    printf("%d", ans);
}
