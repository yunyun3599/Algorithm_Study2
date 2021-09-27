#include <stdio.h>

int N, area;
int calendar[366];

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        int S, E;
        scanf("%d %d", &S, &E);
        for (int j = S; j <= E; j++)
            calendar[j]++;
    }

    for (int i = 1; i < 366; i++) {
        if (calendar[i] == 0) continue;
        int cnt = 0, max = 0; //cnt=가로, max=세로
        while (calendar[i] != 0) {
            cnt++;
            if (calendar[i] > max) max = calendar[i];
            i++;
        }
        area += cnt * max;
    }

    printf("%d", area);
}
