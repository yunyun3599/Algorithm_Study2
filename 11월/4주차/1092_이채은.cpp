#include <stdio.h>
#include <algorithm>

using namespace std;

int N, M, cnt, ans;
int crain[50], box[2][10000];

bool cmp(int x, int y) {
    return y < x;
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%d", &crain[i]);
    scanf("%d", &M);
    for (int i = 0; i < M; i++)
        scanf("%d", &box[0][i]);

    sort(crain, crain + N, cmp);
    sort(box[0], box[0] + M, cmp);
    for (int i = 0; i < M; i++)


        if (crain[0] < box[0][0]) {
            printf("-1"); return 0;
        }

    int val = N;
    while (cnt < M) {
        for (int i = 0; i < val; i++) {
            bool flag = false;
            for (int j = 0; j < M; j++) {
                if (box[1][j] != 0 || crain[i] < box[0][j]) continue;
                box[1][j] = 1; cnt++; flag = true; break;
            }
            if (!flag) val = i;
        }
        ans++;
    }

    printf("%d", ans);
}
