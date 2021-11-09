#include <stdio.h>
#include <string.h>

int mem[11][11], ans;
bool chk[11];

void pick(int cnt, int sum) {
    if (cnt == 11) {
        if (ans < sum) ans = sum; return;
    }

    for (int i = 0; i < 11; i++) {
        if (mem[cnt][i] != 0 && chk[i] == false) {
            chk[i] = true;
            pick(cnt + 1, sum + mem[cnt][i]);
            chk[i] = false;
        }
    }
}

int main() {
    int C;
    scanf("%d", &C);
    for (int t = 0; t < C; t++) {
        ans = 0;
        memset(chk, false, sizeof(chk));
        memset(mem, 0, sizeof(mem));

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                scanf("%d", &mem[i][j]);
            }
        }

        for (int i = 0; i < 11; i++) {
            if (mem[0][i] == 0) continue;
            chk[i] = true;
            pick(1, mem[0][i]);
            chk[i] = false;
        }

        printf("%d\n", ans);
    }
}
