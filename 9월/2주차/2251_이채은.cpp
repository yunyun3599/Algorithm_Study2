#include <stdio.h>

int A, B, C;
bool visit[201][201];
bool ans[201];

void move(int curA, int curB, int curC) {
    if (visit[curA][curB]) return;
    if (curA == 0) ans[curC] = true;
    visit[curA][curB] = true;

    if (curA + curB > B) move(curA + curB - B, B, curC);
    else move(0, curA + curB, curC);

    if (curB + curA > A) move(A, curB + curA - A, curC);
    else move(curB + curA, 0, curC);

    if (curC + curA > A) move(A, curB, curC + curA - A);
    else move(curC + curA, curB, 0);

    if (curC + curB > B) move(curA, B, curC + curB - B);
    else move(curA, curC + curB, 0);

    move(curA, 0, curB + curC);
    move(0, curB, curA + curC);
}

int main() {
    scanf("%d%d%d", &A, &B, &C);
    move(0, 0, C);
    for (int i = 0; i <= C; i++) {
        if (ans[i]) printf("%d ", i);
    }
}
